package com.aminhadad.dao;

import java.sql.*;

public class ContactDao {

    private static final String createTableSQL = "CREATE TABLE CONTACTS (ID  INT PRIMARY KEY NOT NULL ," +
            "  FIRSTNAME VARCHAR (20), LASTNAME VARCHAR(20));";
    private static final String INSERT_CONTACTS_SQL = "INSERT INTO CONTACTS" +
            "  (id, firstName, lastName) VALUES " +
            " (?, ?, ?);";
    private static final String deleteTableSQL = "delete from CONTACTS where id = 1";
    private static final String UPDATE_USERS_SQL = "update CONTACTS set name = ? where id = ?;";
    private static final String QUERY = "select id, firstName, lastName from CONTACTS where id =?";

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void deleteRecord() throws SQLException {

        System.out.println(deleteTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(deleteTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "Amin");
            preparedStatement.setInt(2, 1);

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public void insertRecord() throws SQLException {
        System.out.println(INSERT_CONTACTS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACTS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Reza");
            preparedStatement.setString(3, "Heydari");


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }


    public  void SelectById() {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 2);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }

}
