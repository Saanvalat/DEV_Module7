package org.example;

import AccessorMethods.*;
import com.feature.prefs.AddWorkers;
import com.feature.prefs.Database;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.feature.prefs.Constants.*;
import static org.example.SqlReader.*;


public class DatabaseQueryService {
    public static List<MaxProjectCountClient> countMaxProjectCountClients(){
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(readSqlFileFromMaxProjectsClient(FIND_MAX_PROJECTS_CLIENT_SQL));
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("name"));
                client.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                maxProjectCountClients.add(client);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return maxProjectCountClients;
    }
    public static List<FindLongestProject> longestProjectList(){
        List<FindLongestProject> longestProjects = new ArrayList<>();
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(readSqlFileFromLongestProject(FIND_LONGEST_PROJECT_SQL));
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                FindLongestProject projects = new FindLongestProject();
                projects.setName(resultSet.getString("name"));
                projects.setMonthCount(resultSet.getInt("mounth_count"));
                longestProjects.add(projects);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return longestProjects;
    }
    public static List<MaxSalaryWorker> countMaxSalaryList(){
        List<MaxSalaryWorker> maxCountMaxSalary = new ArrayList<>();
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(readSqlFileFromMaxSalary(FIND_MAX_SALARY_WORKER_SQL));
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MaxSalaryWorker workers = new MaxSalaryWorker();
                workers.setName(resultSet.getString("name"));
                workers.setSalary(resultSet.getInt("salary"));
                maxCountMaxSalary.add(workers);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return maxCountMaxSalary;
    }
    public static List<YoungestEldestWorkers> youngestEldestWorkersList(){
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(readSqlFileFromYoungestEldestWorkers(FIND_YOUNGEST_ELDEST_WORKERS_SQL));
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                YoungestEldestWorkers workers = new YoungestEldestWorkers();
                workers.setType(resultSet.getString("type"));
                workers.setName(resultSet.getString("name"));
                java.sql.Date birthdaySQL = resultSet.getDate("birthday");
                LocalDate birthday = birthdaySQL.toLocalDate();
                workers.setBirthday(birthday);
                youngestEldestWorkers.add(workers);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return youngestEldestWorkers;
    }

    public static List<PrintProjectPrices> projectPricesList(){
        List<PrintProjectPrices> projectPrices = new ArrayList<>();
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(readSqlFileFromPrintProjectSalary(FIND_PRINT_PROJECT_PRICES_SQL));
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                PrintProjectPrices projects = new PrintProjectPrices();
                projects.setName(resultSet.getString("name"));
                BigDecimal price = resultSet.getBigDecimal("price");
                Integer priceInteger = price.intValue();
                projects.setSalary(priceInteger);
                projectPrices.add(projects);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return projectPrices;
    }

    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();
        List<MaxProjectCountClient> maxProjectCountClients = queryService.countMaxProjectCountClients();
        List<FindLongestProject> longestProjects = queryService.longestProjectList();
        List<MaxSalaryWorker> maxCountMaxSalary = queryService.countMaxSalaryList();
        List<YoungestEldestWorkers> youngestEldestWorkers = queryService.youngestEldestWorkersList();
        List<PrintProjectPrices> projectPrices = queryService.projectPricesList();
        AddWorkers.newPerson(11,"Georg","1998-02-03","Middle", 2500);



        System.out.println("Max Project Count Clients: " + maxProjectCountClients);
        System.out.println("longestProjects = " + longestProjects);
        System.out.println("maxCountMaxSalary = " + maxCountMaxSalary);
        System.out.println("youngestEldestWorkers = " + youngestEldestWorkers);
        System.out.println("projectPrices = " + projectPrices);
    }
}

