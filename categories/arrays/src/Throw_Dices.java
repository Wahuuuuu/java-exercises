import java.util.Random;
import java.util.Scanner;

public class Throw_Dices {
    public static void main(String[] args) {
        /* @param array array d’enters aleatoris @param n
         * nombre d’enters a l’array
         * @return String amb els nombres iguals consecutius entre paréntesis ex. (6 6) 2 3
         * public static void main(String[] args){
         */
        Scanner sc = new Scanner(System.in);

        int n = -1;
        while (n != 0){
            System.out.println("Introdueix n, entre [2, 20], 0 para terminar: ");
            n = sc.nextInt();
            if (n == 0) break;

            int[] a = new int[n];
            System.out.println("Les tirades del dau són: ");
            System.out.println(repetits(a, n));
            System.out.println();
        }
    }


    static String repetits(int[] array, int n){
        Random dice = new Random();
        // throw dices
        for (int i = 0; i < n; i++) {
            array[i] = 1 + dice.nextInt(6);
        }




    }
}