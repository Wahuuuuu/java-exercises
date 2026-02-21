public class CompteBancari {
    public String numeroCompte = "Unknown";
    public double saldo = -1.0;

    CompteBancari(String numeroCompte, double saldo) {
        this.numeroCompte = numeroCompte;
        if (saldo < 0) {
            System.out.println("Saldo no pot set negatiu! Està corregit a 0");
            this.saldo = 0;
        }
        else this.saldo = saldo;
    }

    public void mostrarSaldo() {
        System.out.println("El saldo es " + saldo);
    }

    public void setSaldo(int nouSaldo) {
        if (nouSaldo >= 0) {
            saldo = nouSaldo;
        }
        else {
            System.out.println("Saldo no pot set negatiu! Està corregit a 0");
            saldo = 0;
        }
    }

    public void dipositar(double quantitat) {
        if (quantitat < 0) System.out.println("No es pot dipositar diners amb quantitat negatiu!");
        else {
            saldo += quantitat;
        }
    }

    public void retirar(double quantitat) {
        if (quantitat < 0) System.out.println("No es pot retirar diners amb quantitat negatiu!");
        else {
            if (saldo - quantitat < 0) System.out.println("Està retirant més diners dels que hi ha disponibles!");
            else {
                saldo -= quantitat;
            }
        }
    }

}