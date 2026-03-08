package prog2.model;

public abstract class Allotjament implements InAllotjament {
    protected String nom;
    protected String id;
    protected long estadaMinimaAlta, estadaMinimaBaixa;


    // constructors:
    // --------------------------
    public Allotjament() {
        this("Default allotjament", "Default allotjament", -1, -1);
    }

    public Allotjament(String nom, String id) {
        this(nom, id, -1, -1);
    }

    public Allotjament(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
    }


    // getters and setters:
    // ---------------------------
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getEstadaMinima(Temp temp) {
        return (temp == Temp.ALTA) ? estadaMinimaAlta : estadaMinimaBaixa;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaAlta = estadaMinimaALTA_;
        this.estadaMinimaBaixa = estadaMinimaBAIXA_;
    }


    // other methods
    // --------------------
    public abstract boolean correcteFuncionament();
}
