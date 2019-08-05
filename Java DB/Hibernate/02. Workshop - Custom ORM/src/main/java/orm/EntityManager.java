package orm;

import orm.annotations.Column;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class EntityManager<E> implements DbContext<E> {
    public static final String INSERT_QUERY = "INSERT into %s (%s) VALUES (%s)";
    public static final String UPDATE_QUERY = "UPDATE %s SET %s WHERE id = %s";
    private static final String SELECT_ALL_WITH_WHERE = "SELECT * FROM %s WHERE 1 %s";


    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field idField = this.getId(entity.getClass());
        idField.setAccessible(true);
        Object idValue = idField.get(entity);

        if (idValue == null || (int)idValue <= 0){
            return this.doInsert(entity);
        }
        return this.doUpdate(entity, idField);
    }

    public Iterable<E> find(Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return this.find(table, null);
    }

    public Iterable<E> find(Class<E> table, String where) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String tableName = this.getTableName(table);

        Statement statement = connection.createStatement();
        String query = String.format(SELECT_ALL_WITH_WHERE,
                tableName,
                where == null ? "" : "AND " + where);

        ResultSet rs = statement.executeQuery(query);

        List<E> result = new ArrayList<>();

        while(rs.next()) {
            E entity = table.getDeclaredConstructor().newInstance();
            this.fillEntity(table, rs, entity);
            result.add(entity);
        }

        return result;
    }

    private void fillEntity(Class<E> table, ResultSet rs, E entity) throws SQLException, IllegalAccessException {
        Field[] fields = table.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            if (name.equals("id")){
                this.fillField(field, entity, rs, name);
            }else {
                this.fillField(field, entity, rs, field.getAnnotation(Column.class).name());
            }
        }
    }

    private void fillField(Field field, Object instance, ResultSet rs, String fieldName) throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        if (field.getType() == int.class || field.getType() == Integer.class){
            field.set(instance, rs.getInt(fieldName));
        }else if (field.getType() == long.class || field.getType() == Long.class){
            field.set(instance, rs.getLong(fieldName));
        }else if (field.getType() == String.class){
            field.set(instance, rs.getString(fieldName));
        }else if (field.getType() == Date.class){
            field.set(instance, rs.getDate(fieldName));
        }
    }

    public E findFirst(Class<E> table) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return findFirst(table, null);
    }

    public E findFirst(Class<E> table, String where) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return find(table, where == null ? " 1 LIMIT 1" : where + " LIMIT 1").iterator().next();
    }

    private Field getId(Class entity){
      return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() ->
                    new UnsupportedOperationException("Entity does not have primary key"));
    }

    private boolean doInsert(E entity) throws SQLException, IllegalAccessException {
        String tableName = this.getTableName(entity.getClass());
        List<String> fields = (List<String>) this.getFields(entity);
        List<String> values = this.getValues(entity);

        String query = String.format(INSERT_QUERY,
                tableName,
                String.join(", ", fields),
                String.join(", ", values));

        return connection.prepareStatement(query).execute();
    }

    private List<String> getValues(E entity) throws IllegalAccessException {
        List<String> result = new ArrayList<>();

        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Column.class)){
                result.add(getModifiedValue(entity, field));
            }
        }
        return result;
    }

    private String getModifiedValue(E entity, Field field) throws IllegalAccessException {
        String result = null;

        if (field.getType() == int.class) {
            result = (field.get(entity).toString());
        }else if (field.getType() == String.class || field.getType() == Date.class){
            result = ("'" + field.get(entity).toString() + "'");
        }

        return result;
    }

    private Iterable<String> getFields(E entity) {
        List<String> result = new ArrayList<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Column.class)){
                result.add(field.getAnnotation(Column.class).name());
            }
        }
        return result;
    }

    private boolean doUpdate(E entity, Field idField) throws IllegalAccessException, SQLException {
        List<String> fields = (List<String>) this.getFields(entity);
        List<String> values = this.getValues(entity);

        String[] pairs = IntStream.range(0, fields.size())
                .mapToObj(i -> fields.get(i) + " = " + values.get(i))
                .toArray(String[]::new);

        String id = idField.get(entity).toString();

        String query = String.format(UPDATE_QUERY,
                this.getTableName(entity.getClass()),
                        String.join(", ", pairs),
                        id);

        return connection.prepareStatement(query).execute();
    }

    private String getTableName(Class aClass) {
        return aClass.getSimpleName().toLowerCase() + "s";
    }

    public <E> void doCreate(Class entity) throws SQLException {
        String tableName = this.getTableName(entity);

        if (!tableExist(connection, tableName)) {
            String query = " CREATE TABLE " + tableName + "( ";
            List<String> columns = new ArrayList<>();

            Field[] fields = entity.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                String result;

                if (field.isAnnotationPresent(Id.class)) {
                    result = field.getName() + getDbType(field) + " PRIMARY KEY AUTO_INCREMENT";
                } else {
                    result = field.getName() + getDbType(field) + " NOT NULL";
                }
                columns.add(result);
            }

            query += String.join(", ", columns) + ")";
            connection.prepareStatement(query).execute();
        }
    }
    private String getDbType(Field field){
        field.setAccessible(true);
        String result = null;

        if (field.getType() == int.class || field.getType() == Integer.class){
            result = " INT";
        }else if (field.getType() == String.class){
            result = " VARCHAR(255)";
        }else if (field.getType() == Date.class){
            result = " Date";
        }
        return result;
    }

    private static boolean tableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (tName != null && tName.equals(tableName)) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }
}
