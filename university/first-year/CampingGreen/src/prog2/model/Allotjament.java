package prog2.model;

public abstract class Allotjament implements InAllotjament {
    protected String nom;
    protected String id;
    protected long estadaMinimaAlta, estadaMinimaBaixa;
    protected boolean operatiu;
    protected String iluminacio;


    // constructors:
    // --------------------------
    public Allotjament() {
        this("Default allotjament", "Default allotjament", -1, -1, false, "0%");
    }

    public Allotjament(String nom, String id, boolean operatiu, String iluminacio) {
        this(nom, id, -1, -1, operatiu, iluminacio);
    }

    public Allotjament(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa, boolean operatiu, String iluminacio) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;
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

    public boolean isOperatiu() { return this.operatiu; }

    public void setOperatiu(boolean operatiu) { this.operatiu = operatiu; }

    public String getIluminacio() { return this.iluminacio; }

    public void setIluminacio(String iluminacio) { this.iluminacio = iluminacio; }



    // other methods
    // --------------------
    public abstract boolean correcteFuncionament();

    /**
     * Generar un String dels atributs de l'objecte, amb el format:
     * Nom=<nom>, Id=<id>, estada mínima en temp ALTA: <estadaMinimaALTA>, estada mínima en temp BAIXA: <estadaMinimaBAIXA>.
     * @return String
     */
    public String toString() {
        return(
                "Nom = " + this.nom
              + ", Id = " + this.id
              + ", estada mínima en temp ALTA: " + this.estadaMinimaAlta
              + ", estada mínima en temp BAIXA: " + this.estadaMinimaBaixa
              + ", l'estat d'operacio és: " + this.operatiu
              + ", l'iluminació és: " + this.iluminacio
        );
    }

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     * @param tasca Objecte de tipus TascaManteniment.
     */
    public void tancarAllotjament(TascaManteniment tasca) {
        this.operatiu = false;
        this.iluminacio = tasca.getIluminacioAllotjament();
    }

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    public void obrirAllotjament() {
        this.operatiu = true;
        this.iluminacio = "100%";
    }
}
