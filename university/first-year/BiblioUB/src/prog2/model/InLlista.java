package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;

/**
 * Defineix el comportament comú de les llistes de la biblioteca
 * @param <T> Tipus dels elements continguts a la llista.
 * @author Yanzhe Chen
 */
public interface InLlista<T> {
    /**
     * Retorna el nombre d'elements continguts a la llista.
     *
     * @return Nombre d'elements de la llista.
     */
    int getSize();

    /**
     * Afegeix un element a la llista.
     *
     * @param t Element que s'ha d'afegir a la llista.
     * @throws BiblioException Si l'element no es pot afegir.
     */
    void afegir(T t) throws BiblioException;

    /**
     * Esborra un element de la llista.
     *
     * @param t Element que s'ha d'esborrar de la llista.
     */
    void esborrar(T t);

    /**
     * Retorna l'element situat a la posició indicada.
     *
     * @param position Posició de l'element dins de la llista.
     * @return Element situat a la posició indicada.
     */
    T getAt(int position);

    /**
     * Buidar tots el elements de la llista
     */
    void clear();

    /**
     * Indica si la llista és buida.
     *
     * @return True si la llista és buida, False altrament.
     */
    boolean isEmpty();

    /**
     * Retorna l'ArrayList intern utilitzat per la llista.
     *
     * @return ArrayList intern de la llista.
     */
    ArrayList<T> getArrayList();
}
