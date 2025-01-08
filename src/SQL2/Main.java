package SQL2;

import java.sql.*;

public class Main {
    private static Statement statement;
    private static String urlDriverSQLite = "org.sqlite.JDBC";
    private static String urlDB = "jdbc:sqlite:F:\\курс разработчик\\курс java\\GUI-tasks\\src\\SQL2\\My_cats.db";
    private static Connection con;
    private static ResultSet resSet;
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
    static String[] names = {"Гарфилд",
            "Том",
            "Гудвин",
            "Рокки",
            "Ленивец",
            "Пушок",
            "Спорти",
            "Бегемот",
            "Пират",
            "Гудини",
            "Зорро",
            "Саймон",
            "Альбус",
            "Базилио",
            "Леопольд",
            "Нарцисс",
            "Атос",
            "Каспер",
            "Валлито",
            "Оксфорд",
            "Бисквит",
            "Соня",
            "Клеопатра",
            "Цунами",
            "Забияка",
            "Матильда",
            "Кнопка",
            "Масяня",
            "Царапка",
            "Серсея",
            "Ворсинка",
            "Амели",
            "Наоми",
            "Маркиза",
            "Изольда",
            "Вальс",
            "Несквик",
            "Златан",
            "Баскет",
            "Изюм",
            "Цукат",
            "Мокко",
            "Месси",
            "Кокос",
            "Адидас",
            "Бейлиз",
            "Тайгер",
            "Зефир",
            "Мохи",
            "Валенсия",
            "Баунти",
            "Свити",
            "Текила",
            "Ириска",
            "Карамель",
            "Виски",
            "Кукуруза",
            "Гренка",
            "Фасолька",
            "Льдинка",
            "Китана",
            "Офелия",
            "Дайкири",
            "Брусника",
            "Аватар",
            "Космос",
            "Призрак",
            "Изумруд",
            "Плинтус",
            "Яндекс",
            "Крисмас",
            "Метеор",
            "Оптимус",
            "Смайлик",
            "Цельсий",
            "Краска",
            "Дейзи",
            "Пенка",
            "Веста",
            "Астра",
            "Эйприл",
            "Среда",
            "Бусинка",
            "Гайка",
            "Елка",
            "Золушка",
            "Мята",
            "Радость",
            "Сиам",
            "Оскар",
            "Феликс",
            "Гарри",
            "Байрон",
            "Чарли",
            "Симба",
            "Тао",
            "Абу",
            "Ватсон",
            "Енисей",
            "Измир",
            "Кайзер",
            "Васаби",
            "Байкал",
            "Багира",
            "Айрис",
            "Диана",
            "Мими",
            "Сакура",
            "Индия",
            "Тиффани",
            "Скарлетт",
            "Пикси",
            "Лиззи",
            "Алиса",
            "Лило",
            "Ямайка",
            "Пэрис",
            "Мальта",
            "Аляска"
    };

    public static void main(String[] args) {
        try {
            connectionDB();
//            add_all_types(types);
//            delete_/type(3);
//            update_type(7, "Балинезийская cat");
//            System.out.println(get_type(5));
//            get_type_where("type LIKE '%а'");
//            get_all_types();
//            createTable("CREATE TABLE IF NOT exists cats(" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    "name VARCHAR(20) NOT NULL, " +
//                    "type_id INTEGER NOT NULL, " +
//                    "age INTEGER NOT NULL, " +
//                    "weight DOUBLE, " +
//                    "CONSTRAINT name_unique UNIQUE(id), " +
//                    "FOREIGN KEY (type_id)  REFERENCES types (id))");
//            insert_cat("Kis", "Камышовый кот", 2, 10.5);
//            insert_cat("Tom", "Американская жесткошерстная", 1, 12.3);
//            insert_cat("Bats", "Мейн-ку́н", 4, 15.8);
            System.out.println(types.length);
            System.out.println(names.length);
            closeAll();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void connectionDB() throws ClassNotFoundException, SQLException {
        Class.forName(urlDriverSQLite);
        con = DriverManager.getConnection(urlDB);
        statement = con.createStatement();
        System.out.println("connection");
    }

    public static void createTable(String query) throws SQLException {
        statement.execute(query);
        System.out.println("created");
    }

    public static void insert_type(String type) throws SQLException {

        resSet = statement.executeQuery(String.format("SELECT type FROM types WHERE type = '%s'", type));
        if (!(resSet.next())) {
            statement.executeUpdate(String.format("INSERT INTO types(type) VALUES('%s')", type));
            System.out.println("added a row");
            statement.close();
        }

    }

    public static void insert_cat(String name, String type, int age, Double weight) throws SQLException {
        resSet = statement.executeQuery(String.format("SELECT id FROM types WHERE type='%s'", type));
        if (!(resSet.next())) {
            insert_type(type);
            resSet = statement.executeQuery(String.format("SELECT id FROM types WHERE type='%s'", type));
        }
        int id = resSet.getInt("id");
        statement.executeUpdate(String.format("INSERT INTO cats(name, type_id, age, weight) " +
                "VALUES('%s', '%d', '%d', '%f')", name, id, age, weight));

    }

    public static void  add_more_cats(int n){
        int typeFromTypes = (int)(Math.random() * types.length);
        int nameFromNames = (int)(Math.random() * names.length);
    }

    public static void add_all_types(String[] types) throws SQLException {

        for (String type : types) {
            insert_type(type);
        }
        System.out.println("Everything added");

    }

    public static void delete_type(int id) throws SQLException {

        resSet = statement.executeQuery(String.format("SELECT id FROM types WHERE id=%d", id));
        if (resSet.next()) {
            statement.executeUpdate(String.format("DELETE FROM types WHERE id=%d", id));
        } else {
            System.out.println("Not id");
        }

    }

    public static void update_type(int id, String new_type) throws SQLException {

        int check = statement.executeUpdate(String.format("UPDATE types SET type='%s' WHERE id=%d", new_type, id));
        if (check == 1) {
            System.out.println("update");
        } else {
            System.out.println("not exists");
        }

    }

    public static String get_type(int id) throws SQLException {
        resSet = statement.executeQuery(String.format("SELECT type FROM types WHERE id=%d", id));
        if (resSet.next()) {
            return resSet.getString("type");
        } else {
            return "ID does not exists";
        }
    }

    public static void get_type_where(String where) throws SQLException {
        resSet = statement.executeQuery(String.format("SELECT id, type FROM types WHERE %s", where));
        while (resSet.next()) {
            System.out.printf("%d - %s;%n", resSet.getInt(1), resSet.getString(2));
        }
    }

    public static void get_all_types() throws SQLException {
        resSet = statement.executeQuery("SELECT id, type FROM types");
        while (resSet.next()) {
            System.out.printf("%d - %s;%n", resSet.getInt(1), resSet.getString(2));
        }
    }

    public static void closeAll() throws SQLException {

        con.close();
        statement.close();
        if (resSet != null) {
            resSet.close();
        }
        System.out.println("closed");

    }
}
