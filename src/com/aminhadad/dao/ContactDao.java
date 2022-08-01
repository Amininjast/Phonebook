package com.aminhadad.dao;

import java.sql.*;
import java.util.Scanner;

public class ContactDao {
    Scanner scanner=new Scanner(System.in);

    private static final String createTableSQL = "CREATE TABLE CONTACTS (ID  INT PRIMARY KEY NOT NULL ," +
            "  FIRSTNAME VARCHAR (20), LASTNAME VARCHAR(20));";
    private static final String INSERT_CONTACTS_SQL = "INSERT INTO CONTACTS" +
            "  (id, firstName, lastName) VALUES " +
            " (?, ?, ?);";
    private static final String deleteTableSQL = "delete from CONTACTS where ID = ?";
    private static final String updateUsersSQL = "update CONTACTS set FIRSTNAME = ?,LASTNAME = ? where id = ?;";
    private static final String selectQuery = "select id, firstName, lastName from CONTACTS where id =?";
    private static final String selectAll = "select * FROM CONTACTS";
    private static final String maxIdQuery = "SELECT MAX(ID) maxId FROM CONTACTS";

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

    public void insertContact() throws SQLException {
        System.out.println(INSERT_CONTACTS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACTS_SQL)) {
            int idcounter=maxId();
            preparedStatement.setInt(1, ++idcounter);
            System.out.println("PLZ Enter first name");
            String firstName=scanner.nextLine();
            preparedStatement.setString(2, firstName);
            System.out.println("PLZ Enter last name");
            String lastName=scanner.nextLine();
            preparedStatement.setString(3, lastName);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public void deleteRecord() throws SQLException {

        System.out.println(deleteTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement delstatement = connection.prepareStatement(deleteTableSQL);) {
            System.out.println("PLZ Enter id");
            int id=scanner.nextInt();
            delstatement.setInt(1,id);

            // Step 3: Execute the query or update query
            delstatement.execute();

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void updateRecord() throws SQLException {
        System.out.println(updateUsersSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement updateUserStatement = connection.prepareStatement(updateUsersSQL)) {
            System.out.println("PLZ Enter id");
            int id=scanner.nextInt();
            updateUserStatement.setInt(3,id);
            System.out.println("PLZ Enter first name");
            String firstName=scanner.next();
            updateUserStatement.setString(1, firstName);
            System.out.println("PLZ Enter last name");
            String lastName=scanner.next();
            updateUserStatement.setString(2, lastName);

            // Ste8p 3: Execute the query or update query
            updateUserStatement.execute();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public  void selectById() {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {
            System.out.println("enter id");
            int id=scanner.nextInt();
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String FIRSTNAME = rs.getString("FIRSTNAME");
                String LASTTNAME = rs.getString("LASTNAME");
            //
                System.out.println(ID + "," + FIRSTNAME + "," + LASTTNAME );
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }

    public  void selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(selectAll);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String FIRSTNAME = rs.getString("FIRSTNAME");
                String LASTTNAME = rs.getString("LASTNAME");
                //
                System.out.println(ID + "-" + FIRSTNAME + " " + LASTTNAME );
                System.out.println();
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }

    public int maxId()throws SQLException {
        int id = 0;
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement maxIdStatement = connection.prepareStatement(maxIdQuery);) {
            System.out.println(maxIdQuery);
            ResultSet resultSet = maxIdStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt("maxId");
            System.out.println(id);
            System.out.println();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        return id;
    }

}
