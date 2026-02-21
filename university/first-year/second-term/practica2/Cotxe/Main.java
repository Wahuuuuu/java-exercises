import java.util.Scanner;

public class Main {

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  Cotxe c = new Cotxe("marca", "model", 1990);

  boolean continuar = true;
  while (continuar) {

   System.out.println("accelerar: ");
   double increment = sc.nextDouble();
   c.accelerar(increment);
   c.mostrarInformacio();

   System.out.println("frenar: ");
   double decrement = sc.nextDouble();
   c.frenar(decrement);
   c.mostrarInformacio();

   System.out.println("Vols continuar? s/n");
   continuar = sc.next().equals("s");
  }
 }
}