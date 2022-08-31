package com.aminhadad.view;

import com.aminhadad.entities.Contact;

import java.util.Scanner;

public class PhoneBookView {
    private Scanner scanner = new Scanner(System.in);

    public Contact getUpdateFields(){
        System.out.println("PLZ Enter first name");
        String firstName = scanner.next();
        System.out.println("PLZ Enter last name");
        String lastName = scanner.next();

        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);

        return contact;


    }
}
