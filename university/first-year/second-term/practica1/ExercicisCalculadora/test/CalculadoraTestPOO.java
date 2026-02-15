import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTestPOO {

    private Calculadora calculadora;

    @BeforeEach
    void setup() {
        calculadora = new Calculadora();
    }

    //Comprova que la suma de dos nombres es calcula correctament.
    @Test
    void testSumaDosNumeros() {
        calculadora.sumar(2.5, 3.5);
        double resultat = calculadora.getResult();
        assertEquals(6.0f, resultat, 0.0001, "La suma ha de ser 6.0");
    }

    //Comprova que afegir un número a un resultat existent funciona correctament.
    @Test
    void testSumaUnNumero() {
        calculadora.sumar(2.0, 3.0);
        calculadora.sumar(1.5);
        double resultat = calculadora.getResult();
        assertEquals(6.5, resultat, 0.0001, "El resultat ha de ser 6.5 després d'afegir 1.5");
    }

    // Comprova que métode buclePerSumar funciona correctament
    @Test
    void testBuclePerSumar() {
        calculadora.buclePerSumar(10.0);
        assertEquals(65.0, calculadora.getResult(), 0.0001, "El resultat ha de ser 65.0");
    }

   //Comprova que la resta de dos nombres es calcula correctament.
    @Test
    void testRestaDosNumeros() {
        calculadora.restar(10.0, 5.0);
        double resultat = calculadora.getResult();
        assertEquals(5.0, resultat, 0.0001, "La suma ha de ser 5.0");
    }

   //Comprova que la resta de dos nombres iguals es calcula correctament.
    @Test
    void testRestaDosNumerosIguals() {
        calculadora.restar(5.5, 5.5);
        double resultat = calculadora.getResult();
        assertEquals(0.0, resultat, 0.0001, "La suma ha de ser 0.0");
    }

    //Comprova que restar un número a un resultat existent funciona correctament.
    @Test
    void testRestaUnNumero() {
        calculadora.restar(5.0, 3.0);
        calculadora.restar(1.5);
        double resultat = calculadora.getResult();
        assertEquals(0.5, resultat, 0.0001, "El resultat ha de ser 0.5 després de restar 1.5");
    }

    // Comprova que el producte de dos nombres es calcula correstament
    @Test
    void testMultiplicaDosNumeros() {
        calculadora.multiplicar(5.0, 8.0);
        assertEquals(40.0, calculadora.getResult(), 0.0001, "El producte de 5 i 8 ha de ser 40.0");
    }

    // Comprova que el producte de un número al resultat existent és correcte
    @Test
    void testMultiplicaUnNumero() {
        calculadora.multiplicar(5.0, 8.0);
        calculadora.multiplicar(2.0);
        assertEquals(80.0, calculadora.getResult(), 0.0001, "El producte ha de ser 80.0 després "
                + "de multiplicar per 2.0");
    }

    //Verifica que el valor inicial de result és 0.0.
    @Test
    void testResultInicial() {
        assertEquals(0.0, calculadora.getResult(), 0.0001, "El resultat inicial ha de ser 0.0");
    }

    //Assegura que el mètode reset() posa result a 0.0.
    @Test
    void testReset() {
        calculadora.sumar(5.0);
        calculadora.reset();
        assertEquals(0.0, calculadora.getResult(), 0.0001, "Després del reset, el resultat ha de ser 0.0");
    }






}


