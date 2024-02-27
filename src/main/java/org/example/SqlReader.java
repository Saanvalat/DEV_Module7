package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SqlReader {


    public static String readSqlFileFromMaxProjectsClient(String FIND_MAX_PROJECTS_CLIENT_SQL) throws IOException {
        return Files.readString(Path.of(FIND_MAX_PROJECTS_CLIENT_SQL));
    }

    public static String readSqlFileFromLongestProject(String FIND_LONGEST_PROJECT_SQL) throws IOException {
        return Files.readString(Path.of(FIND_LONGEST_PROJECT_SQL));
     }
    public static String readSqlFileFromMaxSalary(String FIND_MAX_SALARY_WORKER_SQL) throws IOException {
        return Files.readString(Path.of(FIND_MAX_SALARY_WORKER_SQL));
    }

    public static String readSqlFileFromYoungestEldestWorkers(String FIND_YOUNGEST_ELDEST_WORKERS_SQL) throws IOException {
        return Files.readString(Path.of(FIND_YOUNGEST_ELDEST_WORKERS_SQL));
    }

    public static String readSqlFileFromPrintProjectSalary(String FIND_PRINT_PROJECT_PRICES_SQL) throws IOException {
        return Files.readString(Path.of(FIND_PRINT_PROJECT_PRICES_SQL));
    }

}
