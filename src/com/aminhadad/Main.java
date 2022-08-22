package com.aminhadad;

import com.aminhadad.dao.H2JDBCUtils;
import com.aminhadad.services.Servis;
import com.aminhadad.view.View;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Servis servis=new Servis();
        servis.c();
        }
    }
