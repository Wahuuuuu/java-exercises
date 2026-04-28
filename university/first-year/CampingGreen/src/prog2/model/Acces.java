package prog2.model;

import prog2.vista.ExcepcioCamping;

public abstract class Acces implements InAcces {
    protected String nom;
    protected boolean estat;
    protected LlistaAllotjaments allotjaments;


    // constructor
    public Acces(String nom_, boolean accesibilitat_) {
        this.nom = nom_;
        this.estat = accesibilitat_;
        this.allotjaments = new LlistaAllotjaments();
    }


    // getters and setters
    // --------------------
    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return true if l'acces es accessible, false si no
     */
    public abstract boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     * @return String nom
     */
    public String getNom() { return this.nom; }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     * @return true si l'acces és obert, false si l'accés és tancat
     */
    public boolean getEstat() { return this.estat; }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     * @return LlistaAllotjaments
     */
    public LlistaAllotjaments getAAllotjaments() {
        return this.allotjaments;
    }


    // methods
    // ---------------------
    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     * @param allotjament nova allotjament accessible
     * @throws ExcepcioCamping si l'allotjament ja existeix en la llista
     */
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        this.allotjaments.afegirAllotjament(allotjament);
    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces() { this.estat = false; }

    /**
     * Canvia l'estat de l'accés a obert
     */
    public void obrirAcces() { this.estat = true; }

}
