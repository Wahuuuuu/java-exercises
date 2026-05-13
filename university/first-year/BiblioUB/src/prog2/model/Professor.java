package prog2.model;

/**
 * Representa un usuari de tipus professor de la biblioteca
 * @author Yanzhe Chen
 */
public class Professor extends Usuari {
    // constructor
    /**
     * Crea un nou professor amb les dades indicades.
     *
     * @param email_ Email de l'estudiant.
     * @param nom_ Nom de l'estudiant.
     * @param adreca_ Adreça de l'estudiant.
     */
    public Professor(String email_, String nom_, String adreca_) {
        super(email_, nom_, adreca_);
    }

    // getters and setters:
    // ------------------------
    /**
     * Retorna el tipus d'usuari.
     *
     * @return Tipus d'usuari, en aquest cas, "Professor".
     */
    public String tipusUsuari() { return "Professor"; }
    /**
     * Retorna el nombre màxim de préstecs normals que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs normals per a un professor
     */
    public int getMaxPrestecsNormals() { return 2; }
    /**
     * Retorna el nombre màxim de préstecs llargs que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs llargs pèr a un professor.
     */
    public int getMaxPrestecsLlargs() { return 2; }
}
