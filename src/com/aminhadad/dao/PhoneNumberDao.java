package com.aminhadad.dao;

import com.aminhadad.entity.PhoneNumber;

import java.sql.*;
import java.util.Scanner;

public class PhoneNumberDao {
    Scanner scanner=new Scanner(System.in);


    private static final String createTablePhoneNumber = "CREATE TABLE PHONENUMBER (ID  INT PRIMARY KEY NOT NULL ," +
            "  number VARCHAR (20), numberType VARCHAR(20), fk_contact INT NOT NULL ,FOREIGN KEY (fk_contact) REFERENCES CONTACTS(ID)"+ "  );";

    private static final String insertPhoneNumberSQL = "INSERT INTO PHONENUMBER" +
            "  (ID, number, numberType,fk_contact) VALUES (?, ?, ?,?);";

    private static final String deletePhoneNumberQuery = "delete from PHONENUMBER where ID = ?";
    private static final String updatePhoneNumberQuery = "update PHONENUMBER set number = ?,numberType = ? where ID = ?;";
    private static final String selectQuery = "select * from PHONENUMBER where id =?";
    private static final String selectAll = "select * FROM PHONENUMBER";
    private static final String maxPhoneNumberIdQuery = "SELECT MAX(ID) maxId FROM PHONENUMBER";

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

    public void insertPhoneNumber() throws SQLException {
        System.out.println(insertPhoneNumberSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(insertPhoneNumberSQL)) {
            int phoneNumberIdCounter= maxPhoneNumberId();
            preparedStatement.setInt(1, ++phoneNumberIdCounter);
            String contactNumber;
            System.out.println("PLZ enter contact number");
            contactNumber=scanner.nextLine();
            preparedStatement.setString(2, contactNumber);
            System.out.println("PLZ enter type of number\n[home =1,work =2 ,other =3,phone =4]");
            PhoneNumber phoneNumber=new PhoneNumber();
            int type=scanner.nextInt();
            switch (type){
                case 1:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.home);
                    preparedStatement.setString(3, "home");

                    break;
                case 2:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.work);
                    preparedStatement.setString(3, "work");

                    break;
                case 3:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.other);
                    preparedStatement.setString(3, "other");

                    break;
                case 4:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.phone);                    preparedStatement.setString(3, "home");
                    preparedStatement.setString(3, "phone");

                    break;
            }
            ContactDao contactDao=new ContactDao();
            int contacId=contactDao.maxContacId();
            preparedStatement.setInt(4, contacId);


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

        System.out.println(deletePhoneNumberQuery);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement deleteStatement = connection.prepareStatement(deletePhoneNumberQuery);) {
            System.out.println("PLZ Enter id");
            int id=scanner.nextInt();
            deleteStatement.setInt(1,id);

            // Step 3: Execute the query or update query
            deleteStatement.execute();

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void updateRecord() throws SQLException {
        System.out.println(updatePhoneNumberQuery);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement updateUserStatement = connection.prepareStatement(updatePhoneNumberQuery)) {
            System.out.println("PLZ Enter id");
            int id=scanner.nextInt();
            updateUserStatement.setInt(3,id);
            String contactNumber;
            System.out.println("PLZ enter contact number");
            contactNumber=scanner.nextLine();
            updateUserStatement.setString(1, contactNumber);
            System.out.println("PLZ enter type of number\n[home =1,work =2 ,other =3,phone =4]");
            PhoneNumber phoneNumber=new PhoneNumber();
            int type=scanner.nextInt();
            switch (type){
                case 1:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.home);
                    updateUserStatement.setString(2, "home");

                    break;
                case 2:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.work);
                    updateUserStatement.setString(2, "work");

                    break;
                case 3:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.other);
                    updateUserStatement.setString(2, "other");

                    break;
                case 4:
//                    phoneNumber.setNumberType(PhoneNumber.NumberType.phone);                    preparedStatement.setString(3, "home");
                    updateUserStatement.setString(2, "phone");

                    break;
            }

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
                String number = rs.getString("number");
                String numberType = rs.getString("numberType");
                //
                System.out.println(ID + "," + number + "," + numberType );
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
                String number = rs.getString("number");
                String numberType = rs.getString("numberType");
                //
                System.out.println(ID + "-" + number + " " + numberType );
                System.out.println();
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }

    public int maxPhoneNumberId()throws SQLException {
        int id = 0;
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement maxIdStatement = connection.prepareStatement(maxPhoneNumberIdQuery);) {
            System.out.println(maxPhoneNumberIdQuery);
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
