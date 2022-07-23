package com.aminhadad.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class H2CreateExample {

    private static final String createTableSQL = "create table users (\r\n" + "  id  int(3) primary key,\r\n" +
            "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
            "  password varchar(20)\r\n" + "  );";

    public static void main(String[] argv) throws SQLException {
        H2CreateExample createTableExample = new H2CreateExample();
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

        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }

    public static class ContactDao {
        public void createDataBase() throws SQLException {
            String createQuery="create table contact (ID INT PRIMARY KEY,firstName VARCHAR(255),lastName VARCHAR(255),id INT)";
            Statement createStatement= H2JDBCUtils.getConnection().createStatement();
            createStatement.execute(createQuery);
        }

        public void dropDataBase(){}
        public void update(){}
        public void insert(){}
        public void delete(){}
        public Contact selectById(int id) throws SQLException {
            String selectByIdQuery="select * from contact as c where c.id=?";
            Statement selectByIdStatement= H2JDBCUtils.getConnection().createStatement();
            selectByIdStatement.executeQuery(selectByIdQuery);
            return null;
        }
        public Contact select(){
            return null;
        }
        public List<Contact> selectAll(){
            return null;
        }

    }
}