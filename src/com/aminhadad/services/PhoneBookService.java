package com.aminhadad.services;

import com.aminhadad.dao.ContactDao;
import com.aminhadad.dao.PhoneNumberDao;
import com.aminhadad.entities.Contact;

import java.sql.SQLException;

public class PhoneBookService {

    ContactDao contactDao = new ContactDao();
    PhoneNumberDao phoneNumberDao = new PhoneNumberDao();



    private void insertPhoneNumber() throws SQLException {
        phoneNumberDao.insertPhoneNumber(contactDao.maxContacId());
    }

    public void starting() throws SQLException {
        contactDao.createContactTable();
        phoneNumberDao.createPhoneNumberTable();
    }


    public void save(Contact contact) throws SQLException {
        contactDao.insertContact(contact);
    }

    public void update(Contact contact) {
        Contact oldContact = contactDao.selectById(contact.getId());
        oldContact.setFirstName(contact.getFirstName());
        oldContact.setLastName(contact.getLastName());
        contactDao.update(contact);
    }
}
