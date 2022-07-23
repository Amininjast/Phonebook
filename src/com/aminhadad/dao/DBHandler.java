package com.aminhadad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
    private Connection connection;

    public DBHandler() throws ClassNotFoundException {
    Class.forName("org.h2.Driver");
    }
    private Statement connect() throws SQLException{
        connection = DriverManager.getConnection("jdbc:h2NotesDB","neo-one.ir","");
        Statement st= Connection.createStatement();
        st.execute("create table if not notes(id int auto_increment,name nvarchar(255),content nvarchar(65535),date datetime)");
                return st;
    }


}
