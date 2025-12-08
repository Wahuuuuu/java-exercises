
public class Fibonacci {

    public static void main(String[] args) {

     int x=1, y=1, z;

     System.out.println(x);
     System.out.println(y);

     for (int i = 0; i < 45; i++) {
         z = sum(x, y);
         x = y;
         y = z;
         System.out.println(z);
     }
     System.out.println("end");
    }

    public static int sum(int val1, int val2) {

        return val1 + val2;
    }
}