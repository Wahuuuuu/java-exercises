package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testConstructors() {
        // Default constructor
        Client cDefault = new Client();
        assertEquals("Default", cDefault.getNom());
        assertEquals("Default", cDefault.getDni());

        // with parameters
        Client cParam = new Client("Wahuuuuu", "A12345678");
        assertEquals("Wahuuuuu", cParam.getNom());
        assertEquals("A12345678", cParam.getDni());

        // Excepcio: dni no és de 9 dígits
        try { Client c = new Client("Excepc", "1234567890"); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }
    }

    @Test
    void testSetters() {
        Client c = new Client();
        c.setNom("Wahuuuuu");
        c.setDni("A12345678");

        assertEquals("Wahuuuuu", c.getNom());
        assertEquals("A12345678", c.getDni());
    }

    @Test
    void testToString() {
        Client c = new Client("Wahuuuuu", "A12345678");
        assertEquals("Wahuuuuu amb DNI: A12345678.", c.toString());
    }
}