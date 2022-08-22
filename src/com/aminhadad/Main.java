package com.aminhadad;

import com.aminhadad.dao.H2JDBCUtils;
import com.aminhadad.services.Servis;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Function function=new Function();
        int selectedMenu=0;
        while (selectedMenu!=12) {
        function.showMenu();
        selectedMenu=scanner.nextInt();

        }
    }
}
