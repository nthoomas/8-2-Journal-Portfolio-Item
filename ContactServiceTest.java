
package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // Test adding contact
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
            "45687", "Bob", "Ross", "9108675309", "234 walnut st"
        );

        service.addContact(contact);
    }

    // Test adding null contact
    @Test
    void testAddNullContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    // Test duplicate contact ID
    @Test
    void testDuplicateContactId() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
            "45687", "Bob", "Ross", "9108675309", "234 walnut st"
        );

        Contact contact2 = new Contact(
            "45687", "John", "Smith", "1234567890", "123 Main St"
        );

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Test deleting contact
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
            "45687", "Bob", "Ross", "9108675309", "234 walnut st"
        );

        service.addContact(contact);
        service.deleteContact("45687");

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("45687");
        });
    }

    // Test updating first name
    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
            "45687", "Bob", "Ross", "9108675309", "234 walnut st"
        );

        service.addContact(contact);
        service.updateFirstName("45687", "John");

        assertEquals("John", contact.getFirstName());
    }

    // Test updating last name
    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
            "45687", "Bob", "Ross", "9108675309", "234 walnut st"
        );

        service.addContact(contact);
        service.updateLastName("45687", "Smith");

        assertEquals("Smith", contact.getLastName());
    }

    // Test updating phone
    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
            "45687", "Bob", "Ross", "9108675309", "234 walnut st"
        );

        service.addContact(contact);
        service.updatePhone("45687", "1234567890");

        assertEquals("1234567890", contact.getPhone());
    }

    // Test updating address
    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
            "45687", "Bob", "Ross", "9108675309", "234 walnut st"
        );

        service.addContact(contact);
        service.updateAddress("45687", "456 Oak St");

        assertEquals("456 Oak St", contact.getAddress());
    }

    // Test updating first name with ID not found
    @Test
    void testUpdateFirstNameNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "Bob");
        });
    }

    // Test updating last name with ID not found
    @Test
    void testUpdateLastNameNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("99999", "Ross");
        });
    }

    // Test updating phone with ID not found
    @Test
    void testUpdatePhoneNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("99999", "9108675309");
        });
    }

    // Test updating address with ID not found
    @Test
    void testUpdateAddressNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("99999", "234 walnut st");
        });
    }
}
