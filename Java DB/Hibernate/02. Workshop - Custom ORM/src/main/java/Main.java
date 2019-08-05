import entities.Car;
import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String dbName = "BMW_db";
        Connection connection =
                Connector.createConnection("root", "", dbName);

        EntityManager<Car> cars = new EntityManager<>(connection);
        cars.doCreate(Car.class);


    }
}
