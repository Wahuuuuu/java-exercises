package prog2.model;

/**
 * Representa un usuari de tipus estudiant de la biblioteca
 * @author Yanzhe Chen
 */
public class Estudiant extends Usuari {
    // constructor
    /**
     * Crea un nou estudiant amb les dades indicades.
     *
     * @param email_ Email de l'estudiant.
     * @param nom_ Nom de l'estudiant.
     * @param adreca_ Adreça de l'estudiant.
     */
    public Estudiant(String email_, String nom_, String adreca_) {
        super(email_, nom_, adreca_);
    }

    // getters and setters:
    // ------------------------

    /**
     * Retorna el tipus d'usuari.
     *
     * @return Tipus d'usuari, en aquest cas "Estudiant".
     */
    public String tipusUsuari() { return "Estudiant"; }

    /**
     * Retorna el nombre màxim de préstecs normals que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs normals per a un estudiant
     */
    public int getMaxPrestecsNormals() { return 2; }
    /**
     * Retorna el nombre màxim de préstecs llargs que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs llargs pèr a un estudiant.
     */
    public int getMaxPrestecsLlargs() { return 1; }

}
