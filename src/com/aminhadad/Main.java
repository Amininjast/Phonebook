package com.aminhadad;

import com.aminhadad.services.PhoneBookService;
import com.aminhadad.view.PhonebookController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PhoneBookService phoneBookService = new PhoneBookService();
        PhonebookController phonebookController = new PhonebookController();

        phoneBookService.starting();
        phonebookController.init();


    }
}