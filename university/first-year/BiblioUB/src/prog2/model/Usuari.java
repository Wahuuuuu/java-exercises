package prog2.model;

public abstract class Usuari implements InUsuari {
    private String email;
    private String nom;
    private String adreca;

    private int numPrestecsNormals;
    private int numPrestecstLlargs;

    // constructor
    public Usuari(String email_, String nom_, String adreca_) {
        this.email = email_;
        this.nom = nom_;
        this.adreca = adreca_;
        this.numPrestecsNormals = 0;
        this.numPrestecstLlargs = 0;
    }


    // getters and setters:
    // ----------------------
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return this.email; }

    public void setNom(String nom) { this.nom = nom; }
    public String getNom() { return this.nom; }

    public void setAdreca(String adreca) { this.adreca = adreca; }
    public String getAdreca() { return this.adreca; }

    public String tipusUsuari() { return "Undefined user"; }

    public void setNumPrestecsNormals(int numPrestecsNormals) { this.numPrestecsNormals = numPrestecsNormals; }
    public int getNumPrestecsNormals() { return this.numPrestecsNormals; }

    public void setNumPrestecsLlargs(int numPrestecstLlargs) { this.numPrestecstLlargs = numPrestecstLlargs; }
    public int getNumPrestecsLlargs() { return this.numPrestecstLlargs; }

    public abstract int getMaxPrestecsNormals();
    public abstract int getMaxPrestecsLlargs();

    // methods:
    // ----------------------
    @Override
    public String toString() {
        return ("Tipus=" + this.tipusUsuari() +
                ", Email=" + this.email +
                ", Nom=" + this.nom +
                ", Adreca=" + this.adreca +
                ", Num.prestecs normals=" + this.numPrestecsNormals +
                ", Num.prestecs llargs=" + this.numPrestecstLlargs
        );
    }

}
