package org.example;

import java.sql.*;

public class DatabaseConnection {
    public Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:src/bookstore.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
//            e.printStackTrace();
        }
        return connection;
    }

    public void selectAllBooks() {
        String sql = "SELECT * FROM Bookstore";
        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("Title") + "\t" +
                        rs.getString("Author") + "\t" +
                        rs.getDouble("Price"));
            }
        } catch (SQLException e) {
            System.out.println("Error selecting books");
//            e.printStackTrace();
        }
    }
}
