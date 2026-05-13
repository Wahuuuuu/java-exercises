package prog2.model;

/**
 * Defineix el comportament comú dels diferents tipus d'usuari de la biblioteca.
 */
public interface InUsuari {
    /**
     * Assigna l'email de l'usuari.
     *
     * @param email Nou email de l'usuari.
     */
    void setEmail(String email);
    /**
     * Retorna l'email de l'usuari.
     *
     * @return Email de l'usuari.
     */
    String getEmail();

    /**
     * Assigna el nom de l'usuari.
     *
     * @param nom Nou nom de l'usuari.
     */
    void setNom(String nom);
    /**
     * Retorna el nom de l'usuari.
     *
     * @return Nom de l'usuari.
     */
    String getNom();

    /**
     * Assigna l'adreça de l'usuari.
     *
     * @param adreca Nova adreça de l'usuari.
     */
    void setAdreca(String adreca);
    /**
     * Retorna l'adreça de l'usuari.
     *
     * @return Adreça de l'usuari.
     */
    String getAdreca();

    /**
     * Retorna el tipus d'usuari.
     *
     * @return Tipus d'usuari.
     */
    String tipusUsuari();

    /**
     * Assigna el nombre de préstecs normals de l'usuari.
     *
     * @param numPrestecsNormals Nou nombre de préstecs normals.
     */
    void setNumPrestecsNormals(int numPrestecsNormals);
    /**
     * Retorna el nombre de préstecs normals de l'usuari.
     *
     * @return Nombre de préstecs normals.
     */
    int getNumPrestecsNormals();

    /**
     * Assigna el nombre de préstecs llargs de l'usuari.
     *
     * @param numPrestecstLlargs Nou nombre de préstecs llargs.
     */
    void setNumPrestecsLlargs(int numPrestecstLlargs);
    /**
     * Retorna el nombre de préstecs llargs de l'usuari.
     *
     * @return Nombre de préstecs llargs.
     */
    int getNumPrestecsLlargs();

    /**
     * Retorna el nombre màxim de préstecs normals que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs normals.
     */
    int getMaxPrestecsNormals();
    /**
     * Retorna el nombre màxim de préstecs llargs que pot tenir l'usuari.
     *
     * @return Nombre màxim de préstecs llargs.
     */
    int getMaxPrestecsLlargs();

    /**
     * Retorna un string que conté totes les informacions de l'usuari
     * @return String que conté totes les informacions de l'usuari
     */
    @Override
    String toString();
}
