package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaAccessosTest {
    private LlistaAccessos accessos;
    private CarreteraAsfaltada carreteraAsfaltada;
    private CamiAsfaltat camiAsfaltat;
    private CarreteraTerra carreteraTerra;
    private CamiTerra camiTerra;

    @BeforeEach
    void setUp() {
        accessos = new LlistaAccessos();
        carreteraAsfaltada = new CarreteraAsfaltada("carreteraAsfaltada", true, 2f, 2f);
        camiAsfaltat = new CamiAsfaltat("camiAsfaltat", true, 3f);
        carreteraTerra = new CarreteraTerra("carreteraTerra", true, 5f, 5f);
        camiTerra = new CamiTerra("camiTerra", true, 7f);
    }

    @Test
    void llistarAccessos() {
        // cas bàsic: llistar true
        accessos.afegirAcces(carreteraAsfaltada);
        accessos.afegirAcces(camiAsfaltat);
        assertEquals(false, accessos.llistarAccessos(true).isEmpty());
        // System.out.println(accessos.llistarAccessos(true));

        // Excepció: no conté acces amb l'estat passat com a paràmmetre
        try { accessos.llistarAccessos(false); }
        catch (ExcepcioCamping e) {
            // System.out.println(e.getMessage());
        }

        // cas bàsic: llistar false
        accessos.afegirAcces(carreteraTerra);
        accessos.afegirAcces(camiTerra);
        carreteraTerra.tancarAcces();
        camiTerra.tancarAcces();
        assertEquals(false, accessos.llistarAccessos(false).isEmpty());
        // System.out.println(accessos.llistarAccessos(false));

        // Excepció: llista buida
        accessos.buidar();
        try { accessos.llistarAccessos(true); }
        catch (ExcepcioCamping e) {
            // System.out.println(e.getMessage());
        }
    }

    @Test
    void actualitzaEstatAccessos() {
    }

    @Test
    void calculaAccessosNoAccessibles() {
    }

    @Test
    void calculaMetresTerra() {
    }
}