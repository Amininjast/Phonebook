package com.aminhadad.dao;

import java.sql.*;
import java.util.Scanner;

public class PhoneNumberDao {
    Scanner scanner=new Scanner(System.in);


    private static final String createTablePhoneNumber = "CREATE TABLE PHONENUMBER (ID  INT PRIMARY KEY NOT NULL ," +
            "  number VARCHAR (20), numberType VARCHAR(20), fk_contact INT NOT NULL ,FOREIGN KEY (fk_contact) REFERENCES CONTACTS(ID)"+ "  );";
    private static final String insertPhoneNumberSQL = "INSERT INTO PHONENUMBER" +
            "  (ID, number, numberType) VALUES (?, ?, ?);";
    private static final String deleteTableSQL = "delete from PHONENUMBER where ID = ?";
    private static final String updateUsersSQL = "update PHONENUMBER set FIRSTNAME = ?,LASTNAME = ? where id = ?;";
    private static final String selectQuery = "select id, firstName, lastName from PHONENUMBER where id =?";
    private static final String selectAll = "select * FROM PHONENUMBER";
    private static final String maxIdQuery = "SELECT MAX(ID) maxId FROM PHONENUMBER";

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

    public void insertContact() throws SQLException {
        System.out.println(insertPhoneNumberSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(insertPhoneNumberSQL)) {
            int idcounter=maxId();
            preparedStatement.setInt(1, ++idcounter);
            System.out.println("PLZ enter type of number\n[home =1,work =2 ,other =3,phone =4]");
            int type=scanner.nextInt();
//            switch (type){
//                case 1:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.home);
//                    break;
//                case 2:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.work);
//                    break;
//                case 3:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.other);
//                    break;
//                case 4:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.phone);
//                    break;
//            }
            System.out.println("PLZ enter contact number");

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
