package com.aminhadad.view;

import com.aminhadad.dao.ContactDao;
import com.aminhadad.dao.H2JDBCUtils;
import com.aminhadad.entities.Contact;
import com.aminhadad.services.PhoneBookService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);

    private PhoneBookService service = new PhoneBookService();


    public void printPhonebook() {
        System.out.println("Phonebook");
    }


    private void insertContact(){
        System.out.println("PLZ Enter first name");
        String firstName = scanner.next();
        System.out.println("PLZ Enter last name");
        String lastName = scanner.next();

        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);

        try {
            service.save(contact);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("خطا داد");
        }

    }
    public void showMenu(){
        System.out.println("1-Create Table\n2-Insert Contact\n3-Show Contact\n4-Show All Contacts\n5-Update Contact\n" +
                "6-delete Contact\n7-Insert number\n8-Show PhoneNumber\n9-Show All PhoneNumber\n10-Update PhoneNumber\n11-delete PhoneNumber" +
                "\n12-Exit\n");
        System.out.print("Your Command : ");
    }
    /*
    private Contact findById() {
        System.out.println("enter id");
        int id = scanner.nextInt();
        return service.selectById(id);
    }*/
}
