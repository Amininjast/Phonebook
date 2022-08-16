package com.aminhadad.dao;

import java.sql.*;
import java.util.Scanner;

public class ContactDao {
    Scanner scanner=new Scanner(System.in);
    PhoneNumberDao phoneNumberDao=new PhoneNumberDao();
    private static final String createTableSQL = "CREATE TABLE CONTACTS (ID  INT PRIMARY KEY NOT NULL ," +
            "  FIRSTNAME VARCHAR (20), LASTNAME VARCHAR(20));";
    private static final String insertContactsSql = "INSERT INTO CONTACTS" +
            "  (id, firstName, lastName) VALUES " +
            " (?, ?, ?);";
    private static final String deleteContactQuery = "delete from CONTACTS where ID = ?";
    private static final String deletePhoneNumberQuery = "delete from PHONENUMBER where fk_contact = ?";

    private static final String updateUsersSQL = "update CONTACTS set FIRSTNAME = ?,LASTNAME = ? where id = ?;";
    private static final String selectQuery = "select id, firstName, lastName from CONTACTS where id =?";
    private static final String selectAll = "select * FROM CONTACTS";
    private static final String maxContacIdQuery = "SELECT MAX(ID) maxId FROM CONTACTS";

    public void createContactTable() throws SQLException {

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
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(insertContactsSql)) {
            int contacIdCouner= maxContacId();
            preparedStatement.setInt(1, ++contacIdCouner);
            System.out.println("PLZ Enter first name");
            String firstName=scanner.next();
            preparedStatement.setString(2, firstName);
            System.out.println("PLZ Enter last name");
            String lastName=scanner.next();
            preparedStatement.setString(3, lastName);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public void deleteRecord() throws SQLException {
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement deleteStatement = connection.prepareStatement(deletePhoneNumberQuery);) {
            System.out.println("PLZ Enter id");
            int id=scanner.nextInt();
            deleteStatement.setInt(1,id);
            deleteStatement.execute();
            PreparedStatement deleteStatement2 = connection.prepareStatement(deleteContactQuery);
            deleteStatement2.setInt(1,id);
            deleteStatement2.execute();
        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void updateRecord() throws SQLException {
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
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {
            System.out.println("enter id");
            int id=scanner.nextInt();
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String FIRSTNAME = rs.getString("FIRSTNAME");
                String LASTTNAME = rs.getString("LASTNAME");
                System.out.println(ID + "," + FIRSTNAME + "," + LASTTNAME );
                phoneNumberDao.selectById(id);
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public  void selectAll() {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectAll);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String FIRSTNAME = rs.getString("FIRSTNAME");
                String LASTTNAME = rs.getString("LASTNAME");
                System.out.println(ID + "-" + FIRSTNAME + " " + LASTTNAME );
                System.out.println();
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public int maxContacId()throws SQLException {
        int id = 0;
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement maxIdStatement = connection.prepareStatement(maxContacIdQuery);) {
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
