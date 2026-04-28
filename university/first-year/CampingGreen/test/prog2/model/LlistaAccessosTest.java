package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaAccessosTest {
    private LlistaAccessos accessos;
    private CarreteraAsfaltada acces1;
    private CamiAsfaltat acces2;
    private CarreteraTerra acces3;
    private CamiTerra acces4;

    @BeforeEach
    void setUp() {
        accessos = new LlistaAccessos();
        acces1 = new CarreteraAsfaltada("carreteraAsfaltada", true, 2f, 2f);
        acces2 = new CamiAsfaltat("camiAsfaltat", true, 3f);
        acces3 = new CarreteraTerra("carreteraTerra", true, 5f, 5f);
        acces4 = new CamiTerra("camiTerra", true, 7.5f);

        accessos.afegirAcces(acces1);
        accessos.afegirAcces(acces2);
        accessos.afegirAcces(acces3);
        accessos.afegirAcces(acces4);
    }

    @Test
    void llistarAccessos() {
        /* cas bàsic: llistar true */
        assertEquals(false, accessos.llistarAccessos(true).isEmpty());
        // System.out.println(accessos.llistarAccessos(true));

        /* Excepció: no conté acces amb l'estat passat com a paràmmetre */
        try { accessos.llistarAccessos(false); }
        catch (ExcepcioCamping e) {
            // System.out.println(e.getMessage());
        }

        /* cas bàsic: llistar false */
        acces3.tancarAcces();
        acces4.tancarAcces();
        assertEquals(false, accessos.llistarAccessos(false).isEmpty());
        // System.out.println(accessos.llistarAccessos(false));

        /* Excepció: llista buida */
        accessos.buidar();
        try { accessos.llistarAccessos(true); }
        catch (ExcepcioCamping e) {
            // System.out.println(e.getMessage());
        }
    }

    @Test
    void actualitzaEstatAccessos() {
        final Allotjament ALL_OPERATIU1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        final Allotjament ALL_OPERATIU2 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);
        final Allotjament ALL_NO_OPERATIU = new BungalowPremium("Bgl", "ID002", false, "50%", 65f, 99, 99, 99, true, true, true, true, "123456768");

        acces1.afegirAllotjament(ALL_NO_OPERATIU);
        acces2.afegirAllotjament(ALL_OPERATIU1);
        acces2.afegirAllotjament(ALL_OPERATIU2);

        /* cas bàsic */
        accessos.actualitzaEstatAccessos();
        assertFalse(acces1.getEstat());
        assertTrue(acces2.getEstat());

        /* modificar els estats i torna d'actualitzar */
        ALL_NO_OPERATIU.obrirAllotjament();
        accessos.actualitzaEstatAccessos();
        assertTrue(acces1.getEstat());
    }

    @Test
    void calculaAccessosNoAccessibles() {
        assertEquals(2, accessos.calculaAccessosNoAccessibles());

        accessos.afegirAcces(new CamiAsfaltat("ca", true, 1f));
        assertEquals(3, accessos.calculaAccessosNoAccessibles());
    }

    @Test
    void calculaMetresTerra() {
        assertEquals(5f + 7.5f, accessos.calculaMetresTerra());
    }
}