/*
    Author: Wahuuuuu
    Version: 1.0
    Date: 19/11/2025
 */

/*
  Comptar el nombre de digits 0,1, ....9 que hi ha als nombres múltiples
  de 7 menors a 10.000
 */
public class ComptarDigits {
    final static int TAMANY = 10;
    final static int MAX = 10000;
    final static int NOMBRE = 7;

    public static void main (String[] args) {
        int [] comptadorM = new int[TAMANY];
        int m;

        m = NOMBRE;
        while (m < MAX) {
            tractarMultiple(m, comptadorM);
            m = m + NOMBRE;
        }
        imprimirComptadors(comptadorM);
    }

    /*
      Inicia a 0 els valors de l'array
      @param1 comptador array que s'ha d'iniciar
     */
    static void iniciarComptadors(int [] comptador) {
	   /* Identif. seq.: indexos de l'array
	     Primer: i = 0
	     Següent(i):  i++
	     FiSeq(i): i >= 10
	     Esquema: Recorregut
	    */
        for (int idx=0; idx < TAMANY ; idx++) {
            comptador[idx] = 0;
        }
    }
    /*
      Actualitza en comptador el nombre de digits que hi han en els multiples de NOMBRE.
      Per exemple, si m es 124, incrementa en 1 el nombre d'ocurrències del dígit 1,
      incrementa en 1 el nombre d'ocurrències del dígit 2,
      i incrementa en 1 el nombre d'ocurrències del dígit 4

      @param1 m         multiple de NOMBRE
      @param2 comptador array que compta el nombre de digits 0,1,..9 dels multiples de NOMBRE
     */
    static void tractarMultiple( int m, int [] comptador) {
        /*
           Identif. sec: digit of m
           First: i = 0
           Next: i++
           Endsec(i): i >= String.valueOf(m).length()
           Scheme: traverse
         */
        int digits = String.valueOf(m).length();
        for (int i = 0; i < digits; i++){
            comptador[m % 10]++;
            m /= 10;
        }
    }
    /*
      Muestra los contadores de digitos (array de 10 elementos)
      @param1 t array de contadores
     */
    static void imprimirComptadors(int[] t) {
	    /* Identif. seq.: indexos de l'array
	        Primer: i =  0
	        Següent(i):  i++
	        FiSeq(i):    i >= t.length
	        Esquema: Recorregut
	    */
        for (int i=0; i < TAMANY; i++)
            System.out.println ("comptador "+i+": "+t[i]);
    }
}
