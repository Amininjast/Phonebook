package com.aminhadad;

import com.aminhadad.services.PhoneBookService;
import com.aminhadad.view.View;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PhoneBookService phoneBookService=new PhoneBookService();
        View view=new View();

        phoneBookService.starting();
        phoneBookService.Menu();
        view.printPhonebook();
        view.showMenu();
        }
    }