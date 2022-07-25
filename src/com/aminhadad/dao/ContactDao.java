package com.aminhadad.dao;

import com.aminhadad.Contact;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ContactDao {
    public void createDataBase() throws SQLException {
        String createQuery="create table contact (ID INT PRIMARY KEY,firstName VARCHAR(255),lastName VARCHAR(255),id INT)";
        Statement createStatement= H2JDBCUtils.getConnection().createStatement();
        createStatement.execute(createQuery);
    }

    public void dropDataBase() throws SQLException {
        String dropQuery="drop table contact ";
        Statement dropStatement= H2JDBCUtils.getConnection().createStatement();
        dropStatement.execute(dropQuery);
    }

    public void update(int id) throws SQLException {
        String updateQuery="delete from contact where id=? ";
        Statement updateStatement= H2JDBCUtils.getConnection().updateStatement();
        updateStatement.execute(updateQuery);
    }

    public void insert() throws SQLException {
        String insertQuery="INSERT INTO contact VALUES (?,?,?) ";
        Statement insertStatement= H2JDBCUtils.getConnection().insertStatement();
        insertStatement.execute(insertQuery);
    }

    public void delete(int id) throws SQLException {
        String deleteQuery="DELETE FROM contact where id=? ";
        Statement deleteStatement= H2JDBCUtils.getConnection().deleteStatement();
        deleteStatement.execute(deleteQuery);
    }

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
