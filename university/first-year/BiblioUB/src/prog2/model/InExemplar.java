package prog2.model;

/**
 * Defineix les operacions bàsiques d'un exemplar de la biblioteca.
 */
public interface InExemplar {
    /**
     * Assigna l'identificador de l'exemplar.
     *
     * @param id Nou identificador de l'exemplar.
     */
    void setId(String id);
    /**
     * Retorna l'identificador de l'exemplar.
     *
     * @return Identificador de l'exemplar.
     */
    String getId();
    /**
     * Assigna el títol de l'exemplar.
     *
     * @param titol Nou títol de l'exemplar.
     */
    void setTitol(String titol);
    /**
     * Retorna el títol de l'exemplar.
     *
     * @return Títol de l'exemplar.
     */
    String getTitol();
    /**
     * Assigna l'autor de l'exemplar.
     *
     * @param autor Nou autor de l'exemplar.
     */
    void setAutor(String autor);
    /**
     * Retorna l'autor de l'exemplar.
     *
     * @return Autor de l'exemplar.
     */
    String getAutor();
    /**
     * Assigna si l'exemplar admet préstec llarg.
     *
     * @param admetPrestecLlarg Cert si l'exemplar admet préstec llarg, fals altrament.
     */
    void setAdmetPrestecLlarg(boolean admetPrestecLlarg);
    /**
     * Indica si l'exemplar admet préstec llarg.
     *
     * @return Cert si l'exemplar admet préstec llarg, fals altrament.
     */
    boolean getAdmetPrestecLlarg();

    /**
     * Return un string que conté totes les informacions de l'usuari
     * @return string
     */
    @Override
    String toString();
}
