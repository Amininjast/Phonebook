package com.aminhadad;

import com.aminhadad.dao.ContactDao;
import com.aminhadad.dao.H2JDBCUtils;
import com.aminhadad.dao.PhoneNumberDao;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        H2JDBCUtils dao=new H2JDBCUtils();
        Function function=new Function();
        ContactDao contactDao=new ContactDao();
        PhoneNumberDao phoneNumberDao=new PhoneNumberDao();
        int selectedMenu=0;

        while (selectedMenu!=6) {
        System.out.println("Phonebook");
        function.showMenu();
        selectedMenu=scanner.nextInt();
            switch (selectedMenu) {
                case 1:
                    contactDao.createTable();
                    phoneNumberDao.createTable();
                    break;
                case 2:
                    contactDao.insertContact();
                    break;
                case 3:
                    contactDao.selectById();
                    break;
                case 4:
                    contactDao.updateRecord();
                    break;
                case 5:
                    contactDao.deleteRecord();
                    break;
                case 6:
                    break;
                case 7:
                    contactDao.maxId();
                    break;

            }
        }
    }
}
