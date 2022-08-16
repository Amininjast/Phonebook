package com.aminhadad;

import com.aminhadad.dao.ContactDao;
import com.aminhadad.dao.PhoneNumberDao;

import java.util.Scanner;

public class Servis {
    public static Scanner scanner=new Scanner(System.in);

    ContactDao contactDao=new ContactDao();
    PhoneNumberDao phoneNumberDao=new PhoneNumberDao();
    Function function=new Function();

    int selectedMenu=0;
    int id=0;
        while (selectedMenu!=12){
        System.out.println("Phonebook");
        function.showMenu();
        selectedMenu = scanner.nextInt();
        switch (selectedMenu) {
            case 1:
                contactDao.createContactTable();
                phoneNumberDao.createPhoneNumberTable();
                break;
            case 2:
                contactDao.insertContact();
                phoneNumberDao.insertPhoneNumber(contactDao.maxContacId());
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
