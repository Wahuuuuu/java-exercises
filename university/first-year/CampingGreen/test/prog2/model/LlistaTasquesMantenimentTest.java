package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LlistaTasquesMantenimentTest {
    private LlistaTasquesManteniment tasques;
    private Allotjament all1, all2, all3;
    private TascaManteniment tasca1;
    // 2, "Neteja", all1, "1000-01-01", 3
    // 3, "Reparacio", all2, "2000-01-01", 4

    @BeforeEach
    void setUp() {
        tasques = new LlistaTasquesManteniment();
        all1 = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        all3 = new BungalowPremium("Bgl", "ID002", false, "50%", 65f, 99, 99, 99, true, true, true, true, "123456768");
        all2 = new MobilHome("MobilHome", "ID003", true, "100%", 66f, 99, 99, true);
        tasca1 = new TascaManteniment(1, TascaManteniment.TipusTascaManteniment.Reparacio, all1, "2024-03-25", 4);
    }

    // @Test
    void testAfegirTascaManteniment() {
        tasques.afegirTascaManteniment(2, "Neteja", all1, "1000-01-01", 3);
        System.out.println(tasques.llistarTasquesManteniment());

        // Excepcio: tipus tasca no conegut
        try { tasques.afegirTascaManteniment(3, "10086", all2, "1000-01-01", 3); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }

        // Excepcio: l'allotjament ja té tasca
        try { tasques.afegirTascaManteniment(4, "Neteja", all3, "1000-01-01", 3); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }
    }

    // @Test
    void testGetTascaManteniment() {
        tasques.afegirTascaManteniment(2, "Neteja", all1, "1000-01-01", 3);
        assertEquals(2, tasques.getTascaManteniment(2).getNum());

        try { tasques.getTascaManteniment(10086); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }
    }

    // @Test
    void testCompletarTascaManteniment() {
        // cas normal
        tasques.afegirTascaManteniment(2, "Neteja", all1, "1000-01-01", 3);

        tasques.completarTascaManteniment(new TascaManteniment(2, InTascaManteniment.TipusTascaManteniment.Neteja, all1, "1000-01-01", 3));

        // Excepció: la llista no conté la tasca passat com a paràmetre
        try { tasques.completarTascaManteniment(tasca1); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }

        // Excepció: l'allotjament de la tasca no té tasca
        tasques.afegirTascaManteniment(3, "Reparacio", all2, "2000-01-01", 4);
        TascaManteniment alliancaAll2 = tasques.getTascaManteniment(3);
        alliancaAll2.getAllotjament().obrirAllotjament();
        try {
            tasques.completarTascaManteniment(new TascaManteniment(3, InTascaManteniment.TipusTascaManteniment.Reparacio, all2, "2000-01-01", 4));
        } catch (ExcepcioCamping e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testLlistarTasquesManteniment() {
        // cas bàsic
        tasques.afegirTascaManteniment(2, "Neteja", all1, "1000-01-01", 3);
        tasques.afegirTascaManteniment(3, "Reparacio", all2, "2000-01-01", 4);
        System.out.println(tasques.llistarTasquesManteniment());

        LlistaTasquesManteniment llistaBuida = new LlistaTasquesManteniment();
        try { System.out.println(llistaBuida.llistarTasquesManteniment()); }
        catch (ExcepcioCamping e) { System.out.println(e.getMessage()); }
    }

}