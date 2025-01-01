package SQL2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:F:\\курс разработчик\\курс java" +
                    "\\GUI-tasks\\src\\SQL2\\My_cats.db");
            Statement statement = con.createStatement();
            statement.execute("CREATE TABLE IF NOT exists 'types'(" +
                    "'id' INTEGER PRIMARY KEY AUTOINCREMENT , 'type' VARCHAR(100) NOT NULL," +
                    " CONSTRAINT name_unique UNIQUE(id))");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
