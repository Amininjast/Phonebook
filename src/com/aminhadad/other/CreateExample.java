package com.aminhadad.other;

import com.aminhadad.dao.H2JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateExample {

    private static final String createTableSQL = "CREATE TABLE CONTACTS (ID  INT PRIMARY KEY NOT NULL ," +
            "  FIRSTNAME VARCHAR (20), LASTNAME VARCHAR(20), COUNTRY VARCHAR(20) );";

    private static final String createTablePhoneNumber = "CREATE TABLE PhoneNumber (ID  INT PRIMARY KEY NOT NULL ," +
            "  number VARCHAR (20), numberType VARCHAR(20), fk_contact INT NOT NULL ,FOREIGN KEY (fk_contact) REFERENCES CONTACTS(ID)"+ "  );";

    public static void main(String[] argv) throws SQLException {
        CreateExample createTableExample = new CreateExample();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);
            statement.execute(createTablePhoneNumber);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
}