package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class ReservaTest {
    private Reserva reserva;
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada, dataSortida;

    @BeforeEach
    void setUp() {
        allotjament = new Parcela("Parcela", "ID001", true, "100%", 64.0f, true);
        client = new Client ("Wahuuuuu", "123456789");
        dataEntrada = LocalDate.of(2000, 1, 1);
        dataSortida = LocalDate.of(2000, 2, 1);
        reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
    }

    @Test
    void testConstructor() {
        /* cas bàsics */
        assertEquals(allotjament, reserva.getAllotjament_());
        assertEquals(client, reserva.getClient());
        assertEquals(dataEntrada, reserva.getDataEntrada());
        assertEquals(dataSortida, reserva.getDataSortida());
    }

    @Test
    void calcularDiesEstada() {
        assertEquals(31, reserva.calcularDiesEstada());
    }

    @Test
    void calcularTemporada() {
        assertEquals(InAllotjament.Temp.BAIXA, reserva.calcularTemporada());
    }
}