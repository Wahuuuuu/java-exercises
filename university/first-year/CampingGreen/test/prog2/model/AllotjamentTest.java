package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllotjamentTest {

    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Creem una instància anònima d'Allotjament per a tests
        allotjament = new Parcela("Allotjament Test", "ID001", true, "100%", 64.0f, true);
    }

    @Test
    void comprovarConstructor() {
        assertEquals("Allotjament Test", allotjament.getNom());
        assertEquals("ID001", allotjament.getId());
        assertEquals(4, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(2, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
        assertEquals(true, allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testCorrecteFuncionament() {
        Parcela parcela = (Parcela) allotjament;
        assertEquals(true, parcela.correcteFuncionament());

        parcela.setConnexioElectrica(false);
        assertEquals(false, parcela.correcteFuncionament());
    }

    @Test
    void testToString() {
        assertEquals("Nom = Allotjament Test, Id = ID001" +
                ", estada mínima en temp ALTA: 4, estada mínima en temp BAIXA: 2" +
                ", l'estat d'operacio és: true, l'iluminació és: 100%" +
                ", mida: 64.0, connexió eléctrica: true",
                allotjament.toString()
        );
    }

    @Test
    void testObrirTancar() {
        TascaManteniment tasca = new TascaManteniment(1, InTascaManteniment.TipusTascaManteniment.Reparacio, allotjament, "01/01/2000", 3);

        allotjament.tancarAllotjament(tasca);
        assertEquals(false, allotjament.isOperatiu());

        allotjament.obrirAllotjament();
        assertEquals(true, allotjament.isOperatiu());
    }

}