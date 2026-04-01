package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LlistaAllotjamentsTest {
    private LlistaAllotjaments allotjaments;


    @BeforeEach
    void setup() {
        Allotjament ALL1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        Allotjament ALL2 = new BungalowPremium("Bgl", "ID002", true, "50%", 65f, 99, 99, 99, true, true, true, true, "123456768");
        Allotjament ALL3 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);

        allotjaments.afegirAllotjament(ALL1);

    }

    // constructor
    @Test
    void testAfegir() {

    }

    // afegirAllotjament

    // llistar

    // contains

    // get allotjament

    // contains allotjament operatiu
}
