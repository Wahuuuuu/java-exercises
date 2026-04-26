package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static prog2.model.InTascaManteniment.TipusTascaManteniment.*;

import java.util.ArrayList;


public class LlistaAllotjamentsTest {
    private LlistaAllotjaments allotjaments;
    private Allotjament ALL1, ALL2, ALL3;

    @BeforeEach
    void setup() {
        ALL1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        ALL2 = new BungalowPremium("Bgl", "ID002", false, "50%", 65f, 99, 99, 99, true, true, true, true, "123456768");
        ALL3 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);

        allotjaments = new LlistaAllotjaments();
    }

    @Test
    void testAfegirBuidar() {
        allotjaments.afegirAllotjament(ALL1);
        allotjaments.afegirAllotjament(ALL2);
        allotjaments.afegirAllotjament(ALL3);
        System.out.println(allotjaments.toString());
        try {
            allotjaments.afegirAllotjament(ALL1);
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
        allotjaments.afegirAllotjament(ALL1);
        allotjaments.afegirAllotjament(ALL2);
        allotjaments.afegirAllotjament(ALL3);

        // casos bàsics
        System.out.println(allotjaments.llistarAllotjaments("Tot") + "\n");
        System.out.println(allotjaments.llistarAllotjaments("Operatiu") + "\n");
        System.out.println(allotjaments.llistarAllotjaments("No Operatiu") + "\n");

        // Excepcio: quan no hi hagi allotjament en l'estat
        ALL2.obrirAllotjament();
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
        assertEquals(false, allotjaments.contains(ALL1));

        allotjaments.afegirAllotjament(ALL1);
        assertEquals(true, allotjaments.contains(ALL1));
        assertEquals(true, allotjaments.containsAllotjamentOperatiu());
    }

    @Test
    void testGetAllotjament() {
        try { allotjaments.getAllotjament(ALL1.getId()); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }

        allotjaments.afegirAllotjament(ALL1);
        assertEquals(ALL1, allotjaments.getAllotjament(ALL1.getId()));
    }
}
