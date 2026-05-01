package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class CampingTest {
    private Camping camping;
    private LlistaAccessos accessos;
    private LlistaAllotjaments allotjaments;
    private LlistaTasquesManteniment tasques;
    /* Dades per afegirTascaManteniment:
     *     3, "Neteja", "ID002", "1000-01-01", 3
     *     4, "Reparacio", "ID004", "2000-01-01", 4
     */

    private Acces acces1, acces2;


    @BeforeEach
    void setUp() {
        Allotjament all1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        Allotjament all2 = new BungalowPremium("Bgl", "ID002", true, "100%", 65f, 99, 99, 99, true, true, true, true, "123456768");
        Allotjament all3 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);
        Allotjament all4 = new Glamping("Glamping", "ID004", true, "100%", 67f, 4, 4, "agua", true);
        allotjaments = new LlistaAllotjaments();
        allotjaments.afegirAllotjament(all1);
        allotjaments.afegirAllotjament(all2);
        allotjaments.afegirAllotjament(all3);
        allotjaments.afegirAllotjament(all4);

        acces1 = new CamiTerra("CamiTerra", true, 5f);
        acces1.afegirAllotjament(all1);
        acces1.afegirAllotjament(all2);
        acces2 = new CarreteraAsfaltada("CarreteraAsfaltada", true, 6f, 6f);
        acces2.afegirAllotjament(all3);
        acces2.afegirAllotjament(all4);
        accessos = new LlistaAccessos();
        accessos.afegirAcces(acces1);
        accessos.afegirAcces(acces2);

        tasques = new LlistaTasquesManteniment();
        tasques.afegirTascaManteniment(1, "Neteja", all1, "1000-01-01", 3);
        tasques.afegirTascaManteniment(2, "Reparacio", all3, "2000-01-01", 4);

        camping = new Camping("CampingTest") {
          @Override
          public void inicialitzaDadesCamping() {
              camping.llistaAccessos = accessos;
              camping.llistaAllotjaments = allotjaments;
              camping.llistaTasquesManteniment = tasques;
          }
        };
        camping.inicialitzaDadesCamping();
    }


    @Test
    void getNomCamping() {
        assertEquals("CampingTest", camping.getNomCamping());
    }

    @Test
    void llistarAllotjaments() {
        /* comprovar que la "llistarAllotjaments()" del classe Camping i la del classe LlistaAllotjaments fan lo mateix */
        assertEquals(allotjaments.llistarAllotjaments("Tot"), camping.llistarAllotjaments("Tot"));
        assertEquals(allotjaments.llistarAllotjaments("Operatiu"), camping.llistarAllotjaments("Operatiu"));
        assertEquals(allotjaments.llistarAllotjaments("No Operatiu"), camping.llistarAllotjaments("No Operatiu"));
    }

    @Test
    void llistarAccessos() {
        /* comprovar que la "llistarAccessos()" del classe Camping i la del classe LlistaAccessos fan lo mateix */
        assertEquals(accessos.llistarAccessos(true), camping.llistarAccessos("Obert"));
        acces1.tancarAcces();
        assertEquals(accessos.llistarAccessos(false), camping.llistarAccessos("Tancat"));

        /* Excepció: el paràmetre no coincideix a "Obert" i "Tancat" */
        try { camping.llistarAccessos("qwerty"); }
        catch (ExcepcioCamping e) {
            assertFalse(e.getMessage().isEmpty());
            // System.out.println(e.getMessage());
        }
    }

    @Test
    void llistarTasquesManteniment() {
        assertEquals(tasques.llistarTasquesManteniment(), camping.llistarTasquesManteniment());
    }

    @Test
    void afegirTascaManteniment() {
        camping.setTasques(new LlistaTasquesManteniment());

        assertThrows(ExcepcioCamping.class, () -> {
            camping.llistarTasquesManteniment();  // Excepció: llista buida
        });
        assertTrue(acces1.getEstat());  // No tots els allotjaments de l'acces1 té tasca

        camping.afegirTascaManteniment(1, "Neteja", "ID002", "1000-01-01", 3);
        camping.afegirTascaManteniment(2, "Reparacio", "ID004", "2000-01-01", 4);
        assertFalse(camping.llistarTasquesManteniment().isEmpty());
        // System.out.println(camping.llistarTasquesManteniment());

        assertFalse(acces1.getEstat());  // Tots els allotjaments de l'acces1 té tasca
    }

    @Test
    void calculaAccessosNoAccessibles() {
        assertEquals(1, camping.calculaAccessosNoAccessibles());

        /* Comprovar que las funcions de les dues classes fan lo mateix*/
        assertEquals(accessos.calculaAccessosNoAccessibles(), camping.calculaAccessosNoAccessibles());
    }

    @Test
    void completarTascaManteniment() {
        camping.afegirTascaManteniment(3, "Neteja", "ID002", "1000-01-01", 3);
        assertFalse(acces1.getEstat());  // Tots els allotjaments de l'acces1 té tasca

        camping.completarTascaManteniment(3);
        assertTrue(acces1.getEstat());   // Després de completar, no tots els allotjaments de l'acces1 té tasca
    }

    @Test
    void calculaMetresTerra() {
        assertEquals(accessos.calculaMetresTerra(), camping.calculaMetresTerra());
        assertEquals(5f, camping.calculaMetresTerra());
    }

}