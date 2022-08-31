package com.aminhadad.view;

import com.aminhadad.entities.Contact;
import com.aminhadad.services.PhoneBookService;

import java.sql.SQLException;
import java.util.Scanner;

public class PhonebookController {
    private Scanner scanner = new Scanner(System.in);
    PhoneBookView phoneBookView = new PhoneBookView();

    private PhoneBookService service = new PhoneBookService();

    public void showMenu() {
        System.out.println("1-Insert Contact\n2-Show Contact\n3-Show All Contacts\n4-Update Contact\n" +
                "5-delete Contact\n6-Insert number\n7-Show PhoneNumber\n8-Show All PhoneNumber\n9-Update PhoneNumber\n10-delete PhoneNumber" +
                "\n11-Exit\n");
        System.out.print("Your Command : ");
    }

    public void dispatcherMenu(){
        int menuId = scanner.nextInt();
        switch (menuId) {
            case 1:
                   saveContact();
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

    private void saveContact(){
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

    private void updateContact(){

        Contact contact  = phoneBookView.getUpdateFields();
        service.update(contact);

    }

    public void init() {
        System.out.println("Phonebook");
        showMenu();
        dispatcherMenu();
    }


    /*
    private Contact findById() {
        System.out.println("enter id");
        int id = scanner.nextInt();
        return service.selectById(id);
    }*/
}
