package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LlistaAllotjamentsTest {
    private LlistaAllotjaments allotjaments;
    private Allotjament allOperatiu1, allOperatiu2, allNoOperatiu;

    @BeforeEach
    void setup() {
        allOperatiu1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        allOperatiu2 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);
        allNoOperatiu = new BungalowPremium("Bgl", "ID002", false, "50%", 65f, 99, 99, 99, true, true, true, true, "123456768");

        allotjaments = new LlistaAllotjaments();
    }

    @Test
    void testAfegirBuidar() {
        allotjaments.afegirAllotjament(allOperatiu1);
        allotjaments.afegirAllotjament(allNoOperatiu);
        allotjaments.afegirAllotjament(allOperatiu2);
        System.out.println(allotjaments.toString());
        try {
            allotjaments.afegirAllotjament(allOperatiu1);
        } catch (ExcepcioCamping e) {
            System.out.println(e.getMessage());
        }

        allotjaments.buidar();
        try {
            System.out.println(allotjaments.toString());
        } catch (ExcepcioCamping e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testLlistarAllotjaments() {
        allotjaments.afegirAllotjament(allOperatiu1);
        allotjaments.afegirAllotjament(allNoOperatiu);
        allotjaments.afegirAllotjament(allOperatiu2);

        // casos bàsics
        System.out.println(allotjaments.llistarAllotjaments("Tot") + "\n");
        System.out.println(allotjaments.llistarAllotjaments("Operatiu") + "\n");
        System.out.println(allotjaments.llistarAllotjaments("No Operatiu") + "\n");

        // Excepcio: quan no hi hagi allotjament en l'estat
        allNoOperatiu.obrirAllotjament();
        try { allotjaments.llistarAllotjaments("No Operatiu"); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage() + "\n"); }

        // Excepcio: quan l'estat passat és invàlid
        try { allotjaments.llistarAllotjaments("123"); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage() + "\n"); }


        // Excepcio: quan no hi hagi ningú allotjament en la llista
        allotjaments.buidar();
        try { allotjaments.llistarAllotjaments("Tot"); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage() + "\n"); }
    }

    @Test
    void testContains() {
        assertEquals(false, allotjaments.containsAllotjamentOperatiu());
        assertEquals(false, allotjaments.contains(allOperatiu1));

        allotjaments.afegirAllotjament(allOperatiu1);
        assertEquals(true, allotjaments.contains(allOperatiu1));
        assertEquals(true, allotjaments.containsAllotjamentOperatiu());
    }

    @Test
    void testGetAllotjament() {
        try { allotjaments.getAllotjament(allOperatiu1.getId()); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }

        allotjaments.afegirAllotjament(allOperatiu1);
        assertEquals(allOperatiu1, allotjaments.getAllotjament(allOperatiu1.getId()));
    }
}
