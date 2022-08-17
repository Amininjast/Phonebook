package com.aminhadad;

import com.aminhadad.dao.ContactDao;
import com.aminhadad.dao.PhoneNumberDao;

import java.sql.SQLException;
import java.util.Scanner;

public class Servis {
    public static Scanner scanner = new Scanner(System.in);

    ContactDao contactDao = new ContactDao();
    PhoneNumberDao phoneNumberDao = new PhoneNumberDao();
    Function function = new Function();
    int selectedMenu = 0;
    int type = 0;
    String contactNumber, firstName, lastName;
    int id = 0;

        while(selectedMenu!=12)

    {
        System.out.println("Phonebook");
        function.showMenu();
        selectedMenu = scanner.nextInt();
        switch (selectedMenu) {
            case 1:
                try {
                    contactDao.createContactTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    phoneNumberDao.createPhoneNumberTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    contactDao.insertContact();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    phoneNumberDao.insertPhoneNumber(contactDao.maxContacId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
                try {
                    contactDao.updateRecord(id, firstName, lastName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    contactDao.deleteRecord(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                try {
                    phoneNumberDao.insertPhoneNumber();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                phoneNumberDao.selectById(id);
                break;
            case 9:
                phoneNumberDao.selectAll();
                break;
            case 10:
                try {
                    phoneNumberDao.updateRecord(id, contactNumber, type);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 11:
                try {
                    phoneNumberDao.deleteRecord(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 12:
                break;
        }
    }
}
