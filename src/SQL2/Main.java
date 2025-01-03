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
    private static String[] types = new String[]{"Абиссинская кошка",
            "Австралийский мист",
            "Американская жесткошерстная",
            "Американская короткошерстная",
            "Американский бобтейл",
            "Американский кёрл",
            "Балинезийская кошка",
            "Бенгальская кошка",
            "Бирманская кошка",
            "Бомбейская кошка",
            "Бразильская короткошёрстная",
            "Британская длинношерстная",
            "Британская короткошерстная",
            "Бурманская кошка",
            "Бурмилла кошка",
            "Гавана",
            "Гималайская кошка",
            "Девон-рекс",
            "Донской сфинкс",
            "Европейская короткошерстная",
            "Египетская мау",
            "Канадский сфинкс",
            "Кимрик",
            "Корат",
            "Корниш-рекс",
            "Курильский бобтейл",
            "Лаперм",
            "Манчкин",
            "Мейн-ку́н",
            "Меконгский бобтейл",
            "Мэнкс кошка",
            "Наполеон",
            "Немецкий рекс",
            "Нибелунг",
            "Норвежская лесная кошка",
            "Ориентальная кошка",
            "Оцикет",
            "Персидская кошка",
            "Петерболд",
            "Пиксибоб",
            "Рагамаффин",
            "Русская голубая кошка",
            "Рэгдолл",
            "Саванна",
            "Селкирк-рекс",
            "Сиамская кошка",
            "Сибирская кошка",
            "Сингапурская кошка",
            "Скоттиш-фолд",
            "Сноу-шу",
            "Сомалийская кошка",
            "Тайская кошка",
            "Тойгер",
            "Тонкинская кошка",
            "Турецкая ангорская кошка",
            "Турецкий ван",
            "Украинский левкой",
            "Чаузи",
            "Шартрез",
            "Экзотическая короткошерстная",
            "Японский бобтейл"
    };

    public static void main(String[] args) {
        connectionDB();
        add_all_types(types);
        closeAll();
    }

    public static void connectionDB() {
        try {
            Class.forName(urlDriverSQLite);
            con = DriverManager.getConnection(urlDB);
            statement = con.createStatement();
            System.out.println("connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String query) {
        try {
            statement.execute(query);
            System.out.println("created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert_type(String type) {
        try {
            if (type.startsWith("INSERT")) {
                statement.execute(type);
                System.out.println("added a row");
            } else {
                throw new SQLException("request is not to add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add_all_types(String[] types) {
        try {
            for (String type : types) {
                statement.execute(String.format("INSERT INTO 'types'(type) VALUES('%s')", type));
            }
            System.out.println("Everything added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll() {
        try {
            con.close();
            statement.close();
            System.out.println("closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
