package compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try{
            DBconnect singletonConnection = DBconnect.getSingletonConnection("C:\\Users\\Alexandra\\Desktop\\faculta\\An_II\\PA\\Laborator9\\lab9.db");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        ManagerEntity singletonManager = ManagerEntity.getSingletonManager();
        singletonManager.close();

        try {
            DBconnect.closeConnection();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
