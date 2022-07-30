package com.aminhadad.dao;

import java.sql.*;
import java.util.List;

public class PhoneNumberDao {
    private static final String createTablePhoneNumber = "CREATE TABLE PhoneNumber (ID  INT PRIMARY KEY NOT NULL ," +
            "  number VARCHAR (20), numberType VARCHAR(20), fk_contact INT NOT NULL ,FOREIGN KEY (fk_contact) REFERENCES CONTACTS(ID)"+ "  );";
    private static final String deleteTableSQL = "delete from users where id = 1";
    private static final String UPDATE_USERS_SQL = "update users set name = ? where id = ?;";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (id, name, email, country, password) VALUES " +
            " (?, ?, ?, ?, ?);";
    private static final String QUERY = "select id,name,email,country,password from users where id =?";
    public void createTable() throws SQLException {

        System.out.println(createTablePhoneNumber);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTablePhoneNumber);

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

}
