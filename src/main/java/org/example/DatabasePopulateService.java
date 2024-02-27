package org.example;

import com.feature.prefs.Database;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static com.feature.prefs.Database.POPULATE_DB_SQL;

public class DatabasePopulateService {

    private static void executeSqlStatements(String sqlContent) throws SQLException {
        try (Connection connection = Database.getInstance().getConnection()) {
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    if (statement != null) {
                        statement.execute(sqlContent);
                    }
                }
            }
        }
    }

    private static String readSqlFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    public static void main(String[] args) {
        try {
            String sqlContent = readSqlFile(POPULATE_DB_SQL);

            System.out.println("Before getting connection");
            try (Connection connection = Database.getInstance().getConnection()) {
                System.out.println("After getting connection");

                if (connection != null) {
                    System.out.println("Before creating statement");
                    try (Statement statement = connection.createStatement()) {
                        System.out.println("After creating statement");
                        executeSqlStatements(sqlContent);
                    }
                }
            }

            System.out.println("Database initialization successful.");
        } catch (IOException | SQLException e) {
            System.out.println("Database initialization failed.");
            e.printStackTrace();
        }
    }



}
