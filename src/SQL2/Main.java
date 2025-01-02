package SQL2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static Statement statement;
    private static String urlDriverSQLite = "org.sqlite.JDBC";
    private static String urlDB = "jdbc:sqlite:F:\\курс разработчик\\курс java\\GUI-tasks\\src\\SQL2\\My_cats.db";
    private static Connection con;
    public static void main(String[] args) {
        connectionDB();
        insert_type("INSERT INTO 'types'(type) VALUES('Абиссинская кошка')");
        insert_type("INSERT INTO 'types'(type) VALUES('Австралийский мист')");
        insert_type("INSERT INTO 'types'(type) VALUES('Американская жесткошерстная')");
        closeAll();
    }

    public static void connectionDB(){
        try {
            Class.forName(urlDriverSQLite);
            con = DriverManager.getConnection(urlDB);
            statement = con.createStatement();
            System.out.println("connection");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void createTable(String query){
        try {
            statement.execute(query);
            System.out.println("created");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void insert_type(String type){
        try{
            if(type.startsWith("INSERT")){
                statement.execute(type);
                System.out.println("added a row");
            }else{
                throw new SQLException("request is not to add");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void closeAll(){
        try {
            con.close();
            statement.close();
            System.out.println("closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
