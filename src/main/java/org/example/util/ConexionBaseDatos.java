package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "sasa";
    private static Connection conection;

    public static Connection getInstance() throws SQLException {
        if (conection == null) {
            conection = DriverManager.getConnection(url,username,password);
        }
        return conection;
    }
}
