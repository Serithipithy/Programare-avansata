package compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try{
            DBConnect singletonConnection = DBConnect.getSingletonConnection("./database/lab8bd.db");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        Movie Interstellar = new Movie(123,"Interstellar","07/11/2014",169,10);
        Interstellar.insert();
    }
}
