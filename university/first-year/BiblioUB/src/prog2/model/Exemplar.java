package prog2.model;

/**
 * Representa un exemplar de la biblioteca
 * @author Yanzhe Chen
 */
public class Exemplar implements InExemplar {
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean disponible;

    // Constructor:
    /**
     * Crea un nou exemplar amb les dades indicades.
     *
     * @param id_ Id de l'exemplar
     * @param titol_ Titil de l'exemplar
     * @param autor_ Autor de l'exemplar
     * @param admetPrestecLlarg_ Cert si admet préstec llarg, fals si no.
     */
    public Exemplar(String id_, String titol_, String autor_, boolean admetPrestecLlarg_) {
        this.id = id_;
        this.titol = titol_;
        this.autor = autor_;
        this.admetPrestecLlarg = admetPrestecLlarg_;
        this.disponible = true;
    }

    // getters and setters:
    // ------------------------
    /**
     * Assigna l'identificador de l'exemplar.
     *
     * @param id Nou identificador de l'exemplar.
     */
    public void setId(String id) { this.id = id; }
    /**
     * Retorna l'identificador de l'exemplar.
     *
     * @return Identificador de l'exemplar.
     */
    public String getId() { return this.id; }
    /**
     * Assigna el títol de l'exemplar.
     *
     * @param titol Nou títol de l'exemplar.
     */
    public void setTitol(String titol) { this.titol = titol; }
    /**
     * Retorna el títol de l'exemplar.
     *
     * @return Títol de l'exemplar.
     */
    public String getTitol() { return this.titol; }
    /**
     * Assigna l'autor de l'exemplar.
     *
     * @param autor Nou autor de l'exemplar.
     */
    public void setAutor(String autor) { this.autor = autor; }
    /**
     * Retorna l'autor de l'exemplar.
     *
     * @return Autor de l'exemplar.
     */
    public String getAutor() { return this.autor; }
    /**
     * Assigna si l'exemplar admet préstec llarg.
     *
     * @param admetPrestecLlarg Cert si l'exemplar admet préstec llarg, fals altrament.
     */
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) { this.admetPrestecLlarg = admetPrestecLlarg; }
    /**
     * Indica si l'exemplar admet préstec llarg.
     *
     * @return Cert si l'exemplar admet préstec llarg, fals altrament.
     */
    public boolean getAdmetPrestecLlarg() { return this.admetPrestecLlarg; }
    /**
     * Assigna la disponibilitat de l'exemplar.
     *
     * @param disponible Cert si l'exemplar està disponible, fals altrament.
     */
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    /**
     * Indica si l'exemplar està disponible.
     *
     * @return Cert si l'exemplar està disponible, fals altrament.
     */
    public boolean isDisponible() { return this.disponible; }

    // methods:
    // ------------------------

    /**
     * Return un string que conté totes les informacions de l'usuari
     * @return string
     */
    public String toString() {
        return ("Id=" + this.id +
                ", Titol=" + this.titol +
                ", Autor = " + this.autor +
                ", Admet Prestec Llarg=" + this.admetPrestecLlarg +
                "Disponible=" + this.disponible
        );
    }

}
