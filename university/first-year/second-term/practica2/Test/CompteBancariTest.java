import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteBancariTest {
    // crea un compte amb nomero "10086" y saldo incial 1000 abans de cada test
    @BeforeEach
    void setUp() {
        CompteBancari cb = new CompteBancari("10086", 1000);
    }

    // Verifica que un saldo inicial negatiu es corregeix a 0
    @Test
    void constructor() {
        // en el constructor
        CompteBancari testNegatiu = new CompteBancari("001", -2);
        assertEquals(0.0, testNegatiu.saldo, 0.001, "Saldo negatiu no està corregit a 0: constructor");

        // en setSaldo
        testNegatiu.setSaldo(-2);
        assertEquals(0.0, testNegatiu.saldo, 0.001, "Saldo negatiu no està corregit a 0: setSaldo");
    }

    // Assegurar que només es pot dipositar quantitats positives
    @Test
    void dipositarDiners() {

    }


}