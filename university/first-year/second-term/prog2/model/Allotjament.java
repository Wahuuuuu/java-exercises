package model;

public abstract class Allotjament implements InAllotjament {
    protected String nom;
    protected String id;
    protected long estadaMinimaAlta, estadaMinimaBaixa;

    // getters and setters:
    // ---------------------------
    public String getNom() { return this.nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }

    public long getEstadaMinima(Temp temp) { return ()? estadaMinimaAlta:estadaMinimaBaixa; }
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaAlta = estadaMinimaALTA_;
        this.estadaMinimaBaixa = estadaMinimaBAIXA_;
    }


    // action method
    public abstract boolean correcteFuncionament();

}
