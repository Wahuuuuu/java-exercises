package model;

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;
    {
        estadaMinimaBaixa = 2;
        estadaMinimaAlta = 4;
    }


    // Constructors
    // ----------------------
    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica){
        this.nom = nom;
        this.id = idAllotjament;
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }


    // getters and setters
    // --------------------------
    public float getMetres() { return this.metres; }
    public void setMetres(float metres) { this.metres = metres; }

    public boolean getConnexioElectrica() { return this.connexioElectrica; }
    public void setConnexioElectrica(boolean connexioElectrica) { this.connexioElectrica = connexioElectrica; }


    // other methods
    // --------------------------
    public boolean correcteFuncionament() { return this.connexioElectrica; }

}
