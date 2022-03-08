package com;

public class Driver {

    private static final String LIST_CONTACTS = "1";
    private static final String ADD = "2";
    private static final String REMOVE = "3";
    private static final String UPDATE = "4";
    private static final String EXIT = "5";

    public static void main(String[] args) {

        ContactList contactList = new ContactList();
        boolean stillRunning = true;

        while (stillRunning) {
            String input = InputCollector.getUserInput("Enter your option: ");

            switch (input) {
                case LIST_CONTACTS -> {
                    contactList.getAllContacts();
                    InputCollector.setAsOptionTurn();
                }
                case ADD -> {
                    String contactName =
                            InputCollector.getUserInput("Add the contact name: ");
                    String contactEmail =
                            InputCollector.getUserInput("Enter the email: ");
                    String mobileNumber =
                            InputCollector.getUserInput("Enter the mobile number: ");
                    String workNumber =
                            InputCollector.getUserInput("Enter the work number: ");
                    String homeNumber =
                            InputCollector.getUserInput("Enter the home number: ");
                    String city =
                            InputCollector.getUserInput("Enter the city: ");
                    Contact contact = new Contact(mobileNumber, city);
                    contact.setContactName(contactName);
                    contact.setContactEmail(contactEmail);
                    contactList.addContact(contact);
                    InputCollector.setAsOptionTurn();
                }
                case REMOVE -> {
                    contactList.getAllContacts();
                    String idRemove = InputCollector.getUserInput("Enter the index: ");
                    Contact contactToRemove = contactList.getContactById(Integer.parseInt(idRemove));
                    if (contactToRemove == null) {
                        System.out.printf("Contact at index %s does not exists.%n", idRemove);
                        InputCollector.setAsOptionTurn();
                        continue;
                    }
                    contactList.removeContact(contactToRemove);
                    InputCollector.setAsOptionTurn();
                }
                case UPDATE -> {
                    contactList.getAllContacts();
                    String idUpdate = InputCollector.getUserInput("Enter the contact index: ");
                    Contact contactToUpdate = contactList.getContactById(Integer.parseInt(idUpdate));
                    if (contactToUpdate == null) {
                        System.out.printf("Contact at index %s does not exists.%n", idUpdate);
                        InputCollector.setAsOptionTurn();
                        continue;
                    }
                    String updatedContactName =InputCollector.getUserInput("Add the contact name: ");
                    String updatedContactEmail =InputCollector.getUserInput("Enter the email: ");
                    String updatedContactMobileNumber = InputCollector.getUserInput("Enter the mobile number: ");
                    String updatedContactCity = InputCollector.getUserInput("Enter the city: ");
                    String updatedWorkNumber = InputCollector.getUserInput("Enter the work number: ");
                    String updatedHomeNumber = InputCollector.getUserInput("Enter the home number: ");
                    Contact updatedContact = new Contact(updatedContactMobileNumber, updatedContactCity);
                    updatedContact.setContactName(updatedContactName);
                    updatedContact.setContactEmail(updatedContactEmail);
                    updatedContact.setMobilePhoneNumber(updatedContactMobileNumber);
                    updatedContact.setContactCity(updatedContactCity);
                    updatedContact.setWorkPhoneNumber(updatedWorkNumber);
                    updatedContact.setHomePhoneNumber(updatedHomeNumber);


                    contactList.updateContact(Integer.parseInt(idUpdate), updatedContact);
                    InputCollector.setAsOptionTurn();
                }
                case EXIT -> {
                    stillRunning = false;
                    System.out.println("Bye!\nAu revoir!" );
                }
                default -> {
                    System.out.println("Invalid Input. Enter a number between 1 and 5.");
                }
            }
        }
    }

}