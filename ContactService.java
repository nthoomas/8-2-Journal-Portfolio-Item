package main;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Contact storage 
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add new contact
    public void addContact(Contact contact) {

        // Contact cannot be null
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        // Contact ID must be different
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID exists, use different one");
        }

        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact with ID
    public void deleteContact(String contactId) {

        // Contact existence check
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactId);
    }

    // Update first name with ID
    public void updateFirstName(String contactId, String firstName) {

        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contact.setFirstName(firstName);
    }

    // Update last name with ID
    public void updateLastName(String contactId, String lastName) {

        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contact.setLastName(lastName);
    }

    // Update phone number with ID
    public void updatePhone(String contactId, String phone) {

        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contact.setPhone(phone);
    }

    // Update address with ID
    public void updateAddress(String contactId, String address) {

        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contact.setAddress(address);
    }
}