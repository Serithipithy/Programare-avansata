package compulsory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {
    private static DBConnect singletonConnection=null;
    private Connection conn ;

    public DBConnect(String path) throws SQLException {
        Connection conn = null;
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

    public Connection getConn() {
        return conn;
    }
}
