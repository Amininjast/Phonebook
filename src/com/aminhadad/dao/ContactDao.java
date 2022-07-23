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
