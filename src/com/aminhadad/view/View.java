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
    /*
    private Contact findById() {
        System.out.println("enter id");
        int id = scanner.nextInt();
        return service.selectById(id);
    }*/
}
