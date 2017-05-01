package my.server.dao.dao.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vladislav on 01.05.2017.
 */
public class Connector {
    private static final String URL      ="jdbc:mysql://localhost:3306/credentials";
    private static final String USER     = "root";
    private static final String PASSWORD ="root";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
