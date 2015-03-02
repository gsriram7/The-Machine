package service;

/**
 * Created by selvaram on 3/2/15.
 */

import model.Memory;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class MemoryServiceImpl {
    private static Connection connection;

    public static void initialize() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    public static ArrayList selectMemoriesByUsername(String userName) throws SQLException, ClassNotFoundException {
        ArrayList memories = new ArrayList<Memory>();
        initialize();
        openConnection();
        Statement statement = connection.createStatement();
        String selectMemoryData = "select message,reply from memory WHERE userName = '"+userName+"'";
        ResultSet resultSet = statement.executeQuery(selectMemoryData);
        while (resultSet.next()) {
            memories.add(new Memory(resultSet.getString("message"), resultSet.getString("reply")));
        }
        statement.close();
        closeConnection();
        return memories;
    }

    public static ArrayList selectAllMemories() throws SQLException, ClassNotFoundException {
        ArrayList memories = new ArrayList<Memory>();
        initialize();
        openConnection();
        Statement statement = connection.createStatement();
        String selectMemoryData = "select message,reply from memory";
        ResultSet resultSet = statement.executeQuery(selectMemoryData);
        while (resultSet.next()) {
            memories.add(new Memory(resultSet.getString("message"), resultSet.getString("reply")));
        }
        statement.close();
        closeConnection();
        return memories;
    }

    public static void addDataToMemory(User user) throws SQLException, ClassNotFoundException {
        initialize();
        openConnection();
        Statement statement = connection.createStatement();
        String insertDataToMemory = "insert into memory (message,reply,userName,messageTo) values ('" + user.getMemory().getMessage() + "','" + user.getMemory().getReply() + "','" + user.getFrom() + "','" + user.getTo() + "')";
        statement.execute(insertDataToMemory);
        closeConnection();
    }

    private static void openConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/selvaram", "postgres",
                    "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}