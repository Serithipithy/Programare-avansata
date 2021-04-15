package compulsory;
import java.sql.*;

public class DBConnect {
    private static DBConnect singletonConnection=null;
    private Connection conn ;

    public DBConnect(String path) throws SQLException {
        try {
            // db parameters
            String url = "jdbc:sqlite:" + path;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static DBConnect getSingletonConnection(String path) throws SQLException{
        if(singletonConnection == null){
            singletonConnection = new DBConnect(path);
        }
        return singletonConnection;
    }

    public static void executeStatement(String toString) {
        try {
            Statement stmt = singletonConnection.conn.createStatement();
            stmt.execute(toString);
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (singletonConnection.conn != null) {
                singletonConnection.conn.close();
            }
        } catch (SQLException exc2) {
            System.out.println(exc2.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
