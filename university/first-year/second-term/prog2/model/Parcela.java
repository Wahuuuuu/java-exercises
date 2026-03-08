package model;

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;

    public Parcela(String nom, String idAllotjament, float metres, boolean connexioElectrica){
        this.nom = nom;
        this.id = idAllotjament;
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;

        // ?
        this.estadaMinimaAlta = 4;
        this.estadaMinimaBaixa = 2;
    }

    public boolean correcteFuncionament() { return this.connexioElectrica; }

}
