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
        int id=0;
        while (selectedMenu!=11) {
        System.out.println("Phonebook");
        function.showMenu();
        selectedMenu=scanner.nextInt();
            switch (selectedMenu) {
                case 1:
                    contactDao.createContactTable();
                    phoneNumberDao.createPhoneNumberTable();
                    break;
                case 2:
                    contactDao.insertContact();
                    phoneNumberDao.insertPhoneNumber();
                    break;
                case 3:
                    contactDao.selectById();
                    phoneNumberDao.selectById(id);
                    break;
                case 4:
                    contactDao.selectAll();
                    phoneNumberDao.selectAll();
                    break;
                case 5:
                    contactDao.updateRecord();
                    break;
                case 6:
                    contactDao.deleteRecord();
                    break;
                case 7:
                    phoneNumberDao.insertPhoneNumber();
                    break;
                case 8:
                    phoneNumberDao.selectById();
                    break;
                case 9:
                    phoneNumberDao.selectAll();
                    break;
                case 10:
                    phoneNumberDao.updateRecord();
                    break;
                case 11:
                    phoneNumberDao.deleteRecord();
                    break;
                case 12:
                    break;
            }
        }
    }
}
