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
//        ContactDao contactDao=new ContactDao();
//        PhoneNumberDao phoneNumberDao=new PhoneNumberDao();
          Servis servis=new Servis();
        int selectedMenu=0;
        int id=0;
        while (selectedMenu!=12) {
        System.out.println("Phonebook");
        function.showMenu();
        selectedMenu=scanner.nextInt();
//            switch (selectedMenu) {
//                case 1:
//                    servis.contactDao.createContactTable();
//                    servis.phoneNumberDao.createPhoneNumberTable();
//                    break;
//                case 2:
//                    servis.contactDao.insertContact();
//                    servis.phoneNumberDao.insertPhoneNumber(servis.contactDao.maxContacId());
//                    break;
//                case 3:
//                    servis.contactDao.selectById();
//                    servis.phoneNumberDao.selectById(id);
//                    break;
//                case 4:
//                    servis.contactDao.selectAll();
//                    servis.phoneNumberDao.selectAll();
//                    break;
//                case 5:
//                    servis.contactDao.updateRecord();
//                    break;
//                case 6:
//                    servis.contactDao.deleteRecord();
//                    break;
//                case 7:
//                    servis.phoneNumberDao.insertPhoneNumber();
//                    break;
//                case 8:
//                    servis.phoneNumberDao.selectById();
//                    break;
//                case 9:
//                    servis.phoneNumberDao.selectAll();
//                    break;
//                case 10:
//                    servis.phoneNumberDao.updateRecord();
//                    break;
//                case 11:
//                    servis.phoneNumberDao.deleteRecord();
//                    break;
//                case 12:
//                    break;
//            }
        }
    }
}
