package com.aminhadad.dao;

import com.aminhadad.entities.Contact;

import java.sql.*;
import java.util.Scanner;

public class ContactDao {
    Scanner scanner = new Scanner(System.in);
    PhoneNumberDao phoneNumberDao = new PhoneNumberDao();
    private static final String createTableSQL = "CREATE TABLE IF NOT EXISTS CONTACTS (ID  INT PRIMARY KEY NOT NULL ," +
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
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    public void insertContact(Contact contact) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertContactsSql)) {
            int contacIdCouner = maxContacId();
            preparedStatement.setInt(1, ++contacIdCouner);
            preparedStatement.setString(2, contact.getFirstName());
            preparedStatement.setString(3, contact.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    public void deleteRecord(int id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deletePhoneNumberQuery);) {
            deleteStatement.setInt(1, id);
            deleteStatement.execute();
            PreparedStatement deleteStatement2 = connection.prepareStatement(deleteContactQuery);
            deleteStatement2.setInt(1, id);
            deleteStatement2.execute();
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    public void deleteRecord() throws SQLException {
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseConnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement deleteStatement = connection.prepareStatement(deletePhoneNumberQuery);) {
            System.out.println("PLZ Enter id");
            int id = scanner.nextInt();
            deleteStatement.setInt(1, id);
            deleteStatement.execute();
            PreparedStatement deleteStatement2 = connection.prepareStatement(deleteContactQuery);
            deleteStatement2.setInt(1, id);
            deleteStatement2.execute();
        } catch (SQLException e) {
            // print SQL exception information
            DatabaseConnection.printSQLException(e);
        }
    }

    public Contact selectById(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("FIRSTNAME");
                String lastName = rs.getString("LASTNAME");
                return new Contact(id, firstName, lastName);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return null;
    }

    public void selectAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectAll);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String FIRSTNAME = rs.getString("FIRSTNAME");
                String LASTTNAME = rs.getString("LASTNAME");
                System.out.println(ID + "-" + FIRSTNAME + " " + LASTTNAME);
                System.out.println();
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    public int maxContacId() throws SQLException {
        int id = 0;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement maxIdStatement = connection.prepareStatement(maxContacIdQuery);) {
            ResultSet resultSet = maxIdStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt("maxId");
            System.out.println(id);
            System.out.println();
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return id;
    }

    public void update(Contact contact) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement updateUserStatement = connection.prepareStatement(updateUsersSQL)) {
            updateUserStatement.setInt(3, contact.getId());
            updateUserStatement.setString(1, contact.getFirstName());
            updateUserStatement.setString(2, contact.getLastName());
            updateUserStatement.execute();
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

}