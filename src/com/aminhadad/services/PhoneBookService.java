package com.aminhadad.services;

import com.aminhadad.Function;
import com.aminhadad.dao.ContactDao;
import com.aminhadad.dao.PhoneNumberDao;
import com.aminhadad.entities.Contact;
import com.aminhadad.view.View;

import java.sql.SQLException;
import java.util.Scanner;

public class PhoneBookService {


    private Scanner scanner = new Scanner(System.in);

    ContactDao contactDao = new ContactDao();
    PhoneNumberDao phoneNumberDao = new PhoneNumberDao();
    Function function = new Function();
    View view = new View();

    private void createTable() throws SQLException {
        contactDao.createContactTable();
        phoneNumberDao.createPhoneNumberTable();
    }



    private void insertPhoneNumber() throws SQLException {
        phoneNumberDao.insertPhoneNumber(contactDao.maxContacId());
    }


    public void c() throws SQLException, ClassNotFoundException {

        int selectedMenu = 0;
        int type = 0;
        String contactNumber = null;
        String firstName = null;
        String lastName = null;
        int id = 0;

        while (selectedMenu != 12) {
            view.printPhonebook();
            view.showMenu();
            selectedMenu = scanner.nextInt();
            switch (selectedMenu) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    phoneNumberDao.selectById(id);
                    break;
                case 4:
                    contactDao.selectAll();
                    phoneNumberDao.selectAll();
                    break;
                case 5:
                    contactDao.updateRecord(id, firstName, lastName);
                    break;
                case 6:
                    contactDao.deleteRecord(id);
                    break;
                case 7:
                    phoneNumberDao.insertPhoneNumber();
                    break;
                case 8:
                    phoneNumberDao.selectById(id);
                    break;
                case 9:
                    phoneNumberDao.selectAll();
                    break;
                case 10:
                    phoneNumberDao.updateRecord(id, contactNumber, type);
                    break;
                case 11:
                    phoneNumberDao.deleteRecord(id);
                    break;
                case 12:
                    break;
            }
        }
    }

    public void save(Contact contact) throws SQLException {
        contactDao.insertContact(contact);
    }
}
