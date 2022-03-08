package com;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<Contact> contactList;

    public ContactList() {
        this.contactList = contactList();
    }

    private List<Contact> contactList() {
        List<Contact> fullListing = new ArrayList<>();
        Contact me = new Contact("123-456-7890", "Taubate");
        me.setContactName("Self");
        fullListing.add(me);

        Contact batman = new Contact("123-456-7890", "Gotham City");
        batman.setContactName("Bruce Wayne");
        fullListing.add(batman);

        Contact derrick = new Contact("123-456-7890", "Vancouver");
        batman.setContactName("Derrick Park");
        fullListing.add(batman);
        return fullListing;
    }

    public void getAllContacts() {
        for (int index = 0; index < this.contactList.size(); index++) {
            Contact contact = this.contactList.get(index);
            String listContact = "%o. <%s> (mobile= %s, home= %s, work= %s, email= %s, city= %s)";
            String contactListFormatted = String.format(listContact, index,  contact.getContactName(), contact.getMobilePhoneNumber(), contact.getHomePhoneNumber(), contact.getWorkPhoneNumber(),contact.getContactEmail(),contact.getContactCity());
            System.out.println(contactListFormatted);
        }
    }

    public Contact getContactById(int contactId) {
        if (contactId <= this.contactList.size()) {
            return this.contactList.get(contactId);
        } else {
            return null;
        }
    }

    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }

    public void removeContact(Contact contact) {
        this.contactList.remove(contact);
    }

    public void updateContact(int indexOfContact, Contact contact) {
        this.contactList.set(indexOfContact, contact);
    }

}