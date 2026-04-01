package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    protected String nom;
    protected boolean accesibilitat;
    protected boolean estat;
    protected ArrayList<Allotjament> allotjaments;


    // constructor
    public Acces(String nom_, boolean accesibilitat_) {
        this.nom = nom_;
        this.accesibilitat = accesibilitat_;
        this.estat = accesibilitat_;
        this.allotjaments = new ArrayList<Allotjament>();
    }


    // getters and setters
    // --------------------

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     * @param allotjament nova allotjament accessible
     */
    public void afegirAllotjament(Allotjament allotjament) { this.allotjaments.add(allotjament); }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces() { this.accesibilitat = false; }

    /**
     * Canvia l'estat de l'accés a obert
     */
    public void obrirAcces() { this.accesibilitat = true; }

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
     * @return
     */
    public LlistaAllotjaments getAAllotjaments() {
        return new LlistaAllotjaments();
    }
}
