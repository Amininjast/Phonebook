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
    public void showMenu(){
        System.out.println("1-Create Table\n2-Insert Contact\n3-Show Contact\n4-Show All Contacts\n5-Update Contact\n" +
                "6-delete Contact\n7-Insert number\n8-Show PhoneNumber\n9-Show All PhoneNumber\n10-Update PhoneNumber\n11-delete PhoneNumber" +
                "\n12-Exit\n");
        System.out.print("Your Command : ");
    }
}
