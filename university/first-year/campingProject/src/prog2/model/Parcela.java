package prog2.model;

public class Parcela extends Allotjament{
    private float mida;
    private boolean connexioElectrica;
    {
        estadaMinimaBaixa = 2;
        estadaMinimaAlta = 4;
    }


    // Constructors
    // ----------------------
    public Parcela(String nom, String idAllotjament, float mida, boolean connexioElectrica){
        this.nom = nom;
        this.id = idAllotjament;
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }


    // getters and setters
    // --------------------------
    public float getMida() { return this.mida; }
    public void setMida(float mida) { this.mida = mida; }

    public boolean isConnexioElectrica() { return this.connexioElectrica; }
    public void setConnexioElectrica(boolean connexioElectrica) { this.connexioElectrica = connexioElectrica; }


    // other methods
    // --------------------------
    public boolean correcteFuncionament() { return this.connexioElectrica; }

}
