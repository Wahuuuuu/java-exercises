package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesTest {

    private Acces acces1;
    private Acces acces2;

    @BeforeEach
    void setUp() {
        // Dos accessos inicials i un allotjament
        acces1 = new Acces("Acces 1", true){
            @Override
            public boolean isAccessibilitat() {
                return true;
            }
        };
        acces2 = new Acces("Acces 2", false){
            @Override
            public boolean isAccessibilitat() {
                return false;
            }
        };
    }

    @Test
    void comprovarConstructor(){
        assertEquals(acces1.getNom(), "Acces 1");
        assertEquals(acces2.getNom(), "Acces 2");
        assertTrue(acces1.isAccessibilitat());
        assertFalse(acces2.isAccessibilitat());
        assertTrue(acces1.getEstat());
        assertFalse(acces2.getEstat());
        assertTrue(acces1.getAAllotjaments() instanceof LlistaAllotjaments);
    }

    @Test
    void testAfegirAllotjament() {
        final Allotjament ALL_OPERATIU1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        final Allotjament ALL_OPERATIU2 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);
        acces1.afegirAllotjament(ALL_OPERATIU1);
        acces1.afegirAllotjament(ALL_OPERATIU2);

        assertFalse(acces1.getAAllotjaments().llistarAllotjaments("Tot").isEmpty());
        System.out.println(acces1.getAAllotjaments().llistarAllotjaments("Tot"));
    }

}
