package orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DbContext<E> {
    boolean persist(E entity) throws IllegalAccessException, SQLException;

    Iterable<E> find(Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    Iterable<E> find(Class<E> table, String where) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    E findFirst(Class<E> table) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    E findFirst(Class<E> table, String where) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
