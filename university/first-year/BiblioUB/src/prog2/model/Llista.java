/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import prog2.vista.BiblioException;

/**
 * @author Yanzhe Chen
 * Defineix les llistes de la biblioteca
 * @param <T> Tipus dels elements continguts a la llista.
 */
public abstract class Llista<T> implements Serializable, InLlista<T> {
   protected ArrayList<T> llista;

    /**
     * Crea una llista buida.
     */
   public Llista() {
       llista = new ArrayList<>();
    }

    /**
     * Retorna el nombre d'elements continguts a la llista.
     *
     * @return Nombre d'elements de la llista.
     */
    public int getSize() {
          return this.llista.size();
    }

    /**
     * Afegeix un element a la llista.
     *
     * @param t Element que s'ha d'afegir a la llista.
     * @throws BiblioException Si l'element no es pot afegir a la llista.
     */
    public void afegir(T t) throws BiblioException {
          this.llista.add(t);
    }

    /**
     * Esborra un element de la llista.
     *
     * @param t Element que s'ha d'esborrar de la llista.
     */
    public void esborrar(T t) {
          this.llista.remove(t);
    }

    /**
     * Retorna l'element situat a la posició indicada.
     *
     * @param position Posició de l'element dins de la llista.
     * @return Element situat a la posició indicada.
     * @throws BiblioException Si l'index és més gran que el size
     */
    public T getAt(int position) throws BiblioException {
        if (position > this.getSize()) throw new BiblioException("No s'ha pogut retornar l'element: index out of range");

        return llista.get(position);
    }

    /**
     * Buidar tots el elements de la llista
     */
    public void clear() {
          this.llista.clear();
    }

    /**
     * Indica si la llista és buida.
     *
     * @return True si la llista és buida, False altrament.
     */
    public boolean isEmpty() {
          return this.llista.isEmpty();
    }

    /**
     * Retorna l'ArrayList intern utilitzat per la llista.
     *
     * @return ArrayList intern de la llista.
     */
    public ArrayList<T> getArrayList() {
        return new ArrayList<>(llista);
    }
}
