package com.aminhadad.dao;

import com.aminhadad.entities.PhoneNumber;

import java.sql.*;
import java.util.Scanner;

public class PhoneNumberDao {
    Scanner scanner = new Scanner(System.in);
    private static final String createTablePhoneNumber = "CREATE TABLE PHONENUMBER (ID  INT PRIMARY KEY NOT NULL ," +
            "  number VARCHAR (20), numberType VARCHAR(20), fk_contact INT NOT NULL ,FOREIGN KEY (fk_contact) REFERENCES CONTACTS(ID)" + "  );";

    private static final String insertPhoneNumberSQL = "INSERT INTO PHONENUMBER" +
            "  (ID, number, numberType,fk_contact) VALUES (?, ?, ?,?);";

    private static final String deletePhoneNumberQuery = "delete from PHONENUMBER where ID = ?";
    private static final String updatePhoneNumberQuery = "update PHONENUMBER set number = ?,numberType = ? where ID = ?;";
    private static final String selectQuery = "select * from PHONENUMBER where fk_contact =?";
    private static final String selectAll = "select * FROM PHONENUMBER";
    private static final String maxPhoneNumberIdQuery = "SELECT MAX(ID) maxId FROM PHONENUMBER";

    public void createPhoneNumberTable() throws SQLException {
        try (Connection connection = H2JDBCUtils.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(createTablePhoneNumber);
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void insertPhoneNumber() throws SQLException {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertPhoneNumberSQL)) {
            int phoneNumberIdCounter = maxPhoneNumberId();
            preparedStatement.setInt(1, ++phoneNumberIdCounter);
            System.out.println("PLZ enter contact number");
            String contactNumber = scanner.next();
            preparedStatement.setString(2, contactNumber);
            System.out.println("PLZ enter type of number\n[1=home , 2=work , 3=other , 4=phone]");
            PhoneNumber phoneNumber = new PhoneNumber();
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    preparedStatement.setString(3, "home");
                    break;
                case 2:
                    preparedStatement.setString(3, "work");
                    break;
                case 3:
                    preparedStatement.setString(3, "other");
                    break;
                case 4:
                    preparedStatement.setString(3, "phone");
                    break;
            }
            System.out.println("enter id of contact");
            int contacId = scanner.nextInt();
            preparedStatement.setInt(4, contacId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void insertPhoneNumber(int a) throws SQLException {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertPhoneNumberSQL)) {
            int phoneNumberIdCounter = maxPhoneNumberId();
            preparedStatement.setInt(1, ++phoneNumberIdCounter);
            System.out.println("PLZ enter contact number");
            String contactNumber = scanner.next();
            preparedStatement.setString(2, contactNumber);
            System.out.println("PLZ enter type of number\n[1=home , 2=work , 3=other , 4=phone]");
            PhoneNumber phoneNumber = new PhoneNumber();
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    preparedStatement.setString(3, "home");
                    break;
                case 2:
                    preparedStatement.setString(3, "work");
                    break;
                case 3:
                    preparedStatement.setString(3, "other");
                    break;
                case 4:
                    preparedStatement.setString(3, "phone");
                    break;
            }
            int contacId = a;
            preparedStatement.setInt(4, contacId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void deleteRecord() throws SQLException {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deletePhoneNumberQuery);) {
            System.out.println("PLZ Enter id");
            int id = scanner.nextInt();
            deleteStatement.setInt(1, id);
            deleteStatement.execute();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void deleteRecord(int id) throws SQLException {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deletePhoneNumberQuery);) {
            deleteStatement.setInt(1, id);
            deleteStatement.execute();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void updateRecord() throws SQLException {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement updateUserStatement = connection.prepareStatement(updatePhoneNumberQuery)) {
            System.out.println("PLZ Enter id");
            int id = scanner.nextInt();
            updateUserStatement.setInt(3, id);
            String contactNumber;
            System.out.println("PLZ enter contact number");
            contactNumber = scanner.next();
            updateUserStatement.setString(1, contactNumber);
            System.out.println("PLZ enter type of number\n[home =1,work =2 ,other =3,phone =4]");
            PhoneNumber phoneNumber = new PhoneNumber();
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    updateUserStatement.setString(2, "home");
                    break;
                case 2:
                    updateUserStatement.setString(2, "work");
                    break;
                case 3:
                    updateUserStatement.setString(2, "other");
                    break;
                case 4:
                    updateUserStatement.setString(2, "phone");
                    break;
            }
            updateUserStatement.execute();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void updateRecord(int id, String contactNumber, int type) throws SQLException {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement updateUserStatement = connection.prepareStatement(updatePhoneNumberQuery)) {
            enterId();
            updateUserStatement.setInt(3, id);
            enterPhonenumer();
            updateUserStatement.setString(1, contactNumber);
            enterType();
            switch (type) {
                case 1:
                    updateUserStatement.setString(2, "home");
                    break;
                case 2:
                    updateUserStatement.setString(2, "work");
                    break;
                case 3:
                    updateUserStatement.setString(2, "other");
                    break;
                case 4:
                    updateUserStatement.setString(2, "phone");
                    break;
            }
            updateUserStatement.execute();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void selectById() {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {
            System.out.println("enter id");
            int id = scanner.nextInt();
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String number = rs.getString("number");
                String numberType = rs.getString("numberType");
                System.out.println(ID + "," + number + "," + numberType);
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void selectById(int id) {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String number = rs.getString("number");
                String numberType = rs.getString("numberType");
                System.out.println(ID + "," + number + "," + numberType);
                System.out.println();
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void selectAll() {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectAll);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String number = rs.getString("number");
                String numberType = rs.getString("numberType");
                System.out.println(ID + "-" + number + " " + numberType);
                System.out.println();
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    public int maxPhoneNumberId() throws SQLException {
        int id = 0;
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement maxIdStatement = connection.prepareStatement(maxPhoneNumberIdQuery);) {
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

    public int enterId() {
        System.out.println("enter id");
        int id = scanner.nextInt();
        return id;
    }

    public String enterPhonenumer() {
        System.out.println("enter contact number");
        String contactNumber = scanner.next();
        return contactNumber;
    }

    public int enterType() {
        System.out.println("PLZ enter type of number\n[home =1,work =2 ,other =3,phone =4]");
        int type = scanner.nextInt();
        return type;
    }
}
