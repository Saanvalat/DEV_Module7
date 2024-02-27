package com.feature.prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String INIT_DB_SQL = "/Users/mac/Documents/3. Code/DEV_Module6/sql/init_db.sql";
    public static final String POPULATE_DB_SQL = "/Users/mac/Documents/3. Code/DEV_Module6/sql/populate_db.sql";
    public static final String DB_URL = "jdbc:h2:./test";
    public static final String USER = "";
    public static final String PASSWORD = "";
    private static Database instance;

    private Database() {

    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Не вдалося отримати підключення до бази даних.", e);
        }
    }

    public static void main(String args[]) {
        try {
            Class.forName("org.h2.Driver");

            try (Connection con = Database.getInstance().getConnection()) {
                System.out.println("Connected");
            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("H2 JDBC Driver not found");
            e.printStackTrace();
        }
    }
}
