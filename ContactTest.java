package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

    // Contact used for testing
    Contact contact = new Contact(
        "45687",
        "Bob",
        "Ross",
        "9108675309",
        "234 walnut st"
    );

    // Test valid contact
    @Test
    void testContact() {
        assertEquals("45687", contact.getContactId());
        assertEquals("Bob", contact.getFirstName());
        assertEquals("Ross", contact.getLastName());
        assertEquals("9108675309", contact.getPhone());
        assertEquals("234 walnut st", contact.getAddress());
    }

    // Test contact ID over 10 characters
    @Test
    void testContactId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                "12345678901",
                "Bob",
                "Ross",
                "9108675309",
                "234 walnut st"
            );
        });
    }

    // Test contact ID null
    @Test
    void testContactIdNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                null,
                "Bob",
                "Ross",
                "9108675309",
                "234 walnut st"
            );
        });
    }

    // Test first name over 10 characters
    @Test
    void testSetFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("TommyPickles");
        });
    }

    // Test first name null
    @Test
    void testSetFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // Test last name over 10 characters
    @Test
    void testSetLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("TommyPickles");
        });
    }

    // Test last name null
    @Test
    void testSetLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    // Test phone number exactly 10 digits
    @Test
    void testSetPhone() {
        contact.setPhone("9107652874");
        assertEquals("9107652874", contact.getPhone());
    }

    // Test phone number null
    @Test
    void testSetPhoneNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    // Test phone number contains letters
    @Test
    void testSetPhoneLetters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345qazws");
        });
    }

    // Test address over 30 characters
    @Test
    void testSetAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("4323 west east north south walnut lane dr");
        });
    }

    // Test address null
    @Test
    void testSetAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}