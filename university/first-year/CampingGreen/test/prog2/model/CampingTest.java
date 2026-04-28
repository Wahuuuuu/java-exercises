package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampingTest {
    private Camping camping;
    private LlistaAccessos accessos;
    private LlistaAllotjaments allotjaments1, allotjaments2;
    private LlistaTasquesManteniment tasques;

    private Acces acces1, acces2;

    private TascaManteniment tasca1, tasca2;
    // 1, "Neteja", all1, "1000-01-01", 3
    // 2, "Reparacio", all2, "2000-01-01", 4
    private Allotjament all1, all2, all3, all4;

    @BeforeEach
    void setUp() {
        all1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        all2 = new BungalowPremium("Bgl", "ID002", true, "100%", 65f, 99, 99, 99, true, true, true, true, "123456768");
        all3 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);
        all4 = new Glamping("Glamping", "ID004", true, "100%", 67f, 4, 4, "agua", true);
        allotjaments1 = new LlistaAllotjaments();
        allotjaments2 = new LlistaAllotjaments();
        allotjaments1.afegirAllotjament(all1);
        allotjaments1.afegirAllotjament(all2);
        allotjaments2.afegirAllotjament(all3);
        allotjaments2.afegirAllotjament(all4);

        acces1 = new CamiTerra("CamiTerra", true, 5f);
        acces2 = new CarreteraAsfaltada("CarreteraAsfaltada", true, 6f, 6f);
        accessos = new LlistaAccessos();
        accessos.afegirAcces(acces1);
        accessos.afegirAcces(acces2);

        tasques = new LlistaTasquesManteniment();
        tasques.afegirTascaManteniment(1, "Neteja", all1, "1000-01-01", 3);
        tasques.afegirTascaManteniment(2, "Reparacio", all3, "2000-01-01", 4);

        camping = new Camping("CampingTest");
    }


    @Test
    void getNomCamping() {
        assertEquals("CampingTest", camping.getNomCamping());
    }

    @Test
    void llistarAllotjaments() {
        assertEquals(allotjaments1.llistarAllotjaments("Tot"), camping.llistarAllotjaments("Tot"));
        assertEquals(allotjaments1.llistarAllotjaments("Operatiu"), camping.llistarAllotjaments("Operatiu"));
        assertEquals(allotjaments1.llistarAllotjaments("No Operatiu"), camping.llistarAllotjaments("No Operatiu"));

        assertEquals(allotjaments2.llistarAllotjaments("Tot"), camping.llistarAllotjaments("Tot"));
        assertEquals(allotjaments2.llistarAllotjaments("Operatiu"), camping.llistarAllotjaments("Operatiu"));
        assertEquals(allotjaments2.llistarAllotjaments("No Operatiu"), camping.llistarAllotjaments("No Operatiu"));
    }

    // @Test
    void llistarAccessos() {
    }

    // @Test
    void llistarTasquesManteniment() {
    }

    // @Test
    void afegirTascaManteniment() {
    }

    // @Test
    void completarTascaManteniment() {
    }

    // @Test
    void calculaAccessosNoAccessibles() {
    }

    // @Test
    void calculaMetresTerra() {
    }

    // @Test
    void save() {
    }

    // @Test
    void load() {
    }

    // @Test
    void inicialitzaDadesCamping() {
    }
}