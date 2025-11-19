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
        Random dice = new Random();
        int[] array = new int[20];

        System.out.println("Introdueix n, entre [2, 20], 0 para terminar: ");
        int n = sc.nextInt();
        switch (n) {
            case 1: System.out.println("The value can't be 1!");
            case 0: break;
            default:
                // throw dices
                for (int i = 0; i < n; i++) {
                    array[i] = 1 + dice.nextInt(6);
                }

                System.out.println("Les tirades del dau són: ");
                System.out.println(repetits(array, n));
                System.out.println();

                System.out.println("Introdueix n, entre [2, 20], 0 para terminar: ");
                n = sc.nextInt();
        }
    }


    static String repetits(int[] array, int n){
        StringBuffer sb = new StringBuffer();

        boolean sameChar = false;
        for(int j = 1; j < n; j++){
            int i = j - 1;

            if (!sameChar && (array[i] == array[j])) {
                sb.append("(");
                sameChar = true;
            }

            sb.append(array[i]);

            if (sameChar && (array[i] != array[j])) {
                sb.append(") ");
                sameChar = false;
            }
            else sb.append(" ");
        }
        // append the last element
        sb.append(array[n-1]);
        if (sameChar) sb.append(")");

        return sb.toString();
    }
}