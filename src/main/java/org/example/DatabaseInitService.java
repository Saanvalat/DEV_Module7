package org.example;

import com.feature.storage.Storage;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
    Connection connection = Storage.getInstance().getConnection();



    }
}