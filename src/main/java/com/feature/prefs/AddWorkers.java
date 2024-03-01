package com.feature.prefs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddWorkers {
    public static void newPerson(int id, String name, String birthday, String level, int salary){
        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO worker (id, name, birthday, level, salary) VALUES (?,?,?,?,?)")){
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, birthday);
            preparedStatement.setString(4, level);
            preparedStatement.setInt(5, salary);

            preparedStatement.executeUpdate();

            System.out.println("Add successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
