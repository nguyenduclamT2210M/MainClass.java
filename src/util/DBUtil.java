package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public DBUtil() {
    }

    public static Connection getConnection() throws Exception {
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=T2210M_Task", "sa", "12345678");
            return conn;
        } catch (Exception var2) {
            throw new Exception(var2.getMessage());
        }
    }
}
