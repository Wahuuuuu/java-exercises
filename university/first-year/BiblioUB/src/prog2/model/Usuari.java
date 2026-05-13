package prog2.model;

/**
 * Representa un usuari de la biblioteca
 *
 * @author Yanzhe Chen
 */
public abstract class Usuari implements InUsuari {
    private String email;
    private String nom;
    private String adreca;

    private int numPrestecsNormals;
    private int numPrestecstLlargs;

    // constructor amb paràmetres

    /**
     * Crea un nou exemplar amb les dades indicades.
     * @param email_ Email de l'usuari
     * @param nom_ Nom de l'usuari
     * @param adreca_ Adreça de l'usuari
     */
    public Usuari(String email_, String nom_, String adreca_) {
        this.email = email_;
        this.nom = nom_;
        this.adreca = adreca_;
        this.numPrestecsNormals = 0;
        this.numPrestecstLlargs = 0;
    }


    // getters and setters:
    // ----------------------

    /**
     * Assigna l'email de l'usuari.
     *
     * @param email Nou email de l'usuari.
     */
    public void setEmail(String email) { this.email = email; }
    /**
     * Retorna l'email de l'usuari.
     *
     * @return Email de l'usuari.
     */
    public String getEmail() { return this.email; }

    /**
     * Assigna el nom de l'usuari.
     *
     * @param nom Nou nom de l'usuari.
     */
    public void setNom(String nom) { this.nom = nom; }
    /**
     * Retorna el nom de l'usuari.
     *
     * @return Nom de l'usuari.
     */
    public String getNom() { return this.nom; }

    /**
     * Assigna l'adreça de l'usuari.
     *
     * @param adreca Nova adreça de l'usuari.
     */
    public void setAdreca(String adreca) { this.adreca = adreca; }
    /**
     * Retorna l'adreça de l'usuari.
     *
     * @return Adreça de l'usuari.
     */
    public String getAdreca() { return this.adreca; }

    /**
     * Retorna el tipus d'usuari.
     *
     * @return Tipus d'usuari.
     */
    public String tipusUsuari() { return "Undefined user"; }

    /**
     * Assigna el nombre de préstecs normals de l'usuari.
     *
     * @param numPrestecsNormals Nou nombre de préstecs normals.
     */
    public void setNumPrestecsNormals(int numPrestecsNormals) { this.numPrestecsNormals = numPrestecsNormals; }
    /**
     * Retorna el nombre de préstecs normals de l'usuari.
     *
     * @return Nombre de préstecs normals.
     */
    public int getNumPrestecsNormals() { return this.numPrestecsNormals; }

    /**
     * Assigna el nombre de préstecs llargs de l'usuari.
     *
     * @param numPrestecstLlargs Nou nombre de préstecs llargs.
     */
    public void setNumPrestecsLlargs(int numPrestecstLlargs) { this.numPrestecstLlargs = numPrestecstLlargs; }
    /**
     * Retorna el nombre de préstecs llargs de l'usuari.
     *
     * @return Nombre de préstecs llargs.
     */
    public int getNumPrestecsLlargs() { return this.numPrestecstLlargs; }

    /**
     * Retorna el nombre màxim de préstecs normals que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs normals.
     */
    public abstract int getMaxPrestecsNormals();
    /**
     * Retorna el nombre màxim de préstecs llargs que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs llargs.
     */
    public abstract int getMaxPrestecsLlargs();

    // methods:
    // ----------------------
    /**
     * Retorna un string que conté totes les informacions de l'usuari
     * @return String que conté totes les informacions de l'usuari
     */
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
