package com.aminhadad.view;

import com.aminhadad.dao.ContactDao;
import com.aminhadad.entities.Contact;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    ContactDao contactDao = new ContactDao();


    public void printPhonebook() {
        System.out.println("Phonebook");
    }

    private Contact findById() {
        System.out.println("enter id");
        int id = scanner.nextInt();
        return contactDao.selectById(id);
    }
}
