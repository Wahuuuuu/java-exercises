public class Cotxe {
    private String marca = "Unknown";
    private String model = "Unknown";
    private int any = -1;
    private double velocitatActual = 0;

    Cotxe(String marca, String model, int any) {
        this.marca = marca;
        this.model = model;
        this.any = any;
    }

    public void accelerar(double increment) {
        if (increment < 0) {
            System.out.println("L'increment no pot ser negatiu");
            return;
        }
        velocitatActual += increment;
    }

    public void frenar(double decrement) {
        if (decrement < 0) {
            System.out.println("El decrement no pot ser negatiu");
            return;
        }
        velocitatActual -= decrement;
    }

    public void mostrarInformacio() {
        System.out.println("marca = " + marca);
        System.out.println("model = " + model);
        System.out.println("any = " + any);
        System.out.println("valocitat actual = " + velocitatActual);
    }
}
