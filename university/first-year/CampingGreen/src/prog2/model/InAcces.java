
package prog2.model;

import prog2.vista.ExcepcioCamping;

/**
 * Interfície que defineix les operacions bàsiques d'un accés.
 */
public interface InAcces {

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     * @param allotjament nova allotjament accessible
     * @throws ExcepcioCamping si l'allotjament ja existeix en la llista
     */
    public void afegirAllotjament(Allotjament allotjament);
    
    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces();
    
    /**
     * Canvia l'estat de l'accés a obert 
     */
    public void obrirAcces();

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return true if l'acces es accessible, false si no
     */
    public boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     * @return String nom
     */
    public String getNom();

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     * @return true si l'acces és obert, false si l'accés és tancat
     */
    public boolean getEstat();

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     * @return LlistaAllotjaments
     */
    public LlistaAllotjaments getAAllotjaments();
}
