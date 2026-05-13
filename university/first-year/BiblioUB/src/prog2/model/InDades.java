/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.ArrayList;

import prog2.vista.BiblioException;

/**
 * Defineix les operacions principals per gestionar les dades de la biblioteca.
 * @author dortiz, Yanzhe Chen
 */
public interface InDades {

    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     * @param id Identificador de l'exemplar.
     * @param titol Títol de l'exemplar.
     * @param autor Autor de l'exemplar.
     * @param admetPrestecLlarg Indica si l'exemplar admet préstec llarg.
     * @throws BiblioException Si l'id ja existeix
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException;

    /**
     * Recuperar exemplars. Retorna un ArrayList amb tots els exemplars
     * @return ArrayList amb tots els exemplars.
     */
    public ArrayList<Exemplar> recuperaExemplars();

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     * @param email Email de l'usuari.
     * @param nom Nom de l'usuari.
     * @param adreca Adreça de l'usuari.
     * @param esEstudiant Indica si l'usuari és estudiant.
     * @throws BiblioException Si la llista ja conté un usuari amb el mateix email
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException;

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     * @return ArrayList amb tots els usuaris.
     */
    public ArrayList<Usuari> recuperaUsuaris();

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar i usuari dins dels seus ArrayLists.
     *
     * @param exemplarPos Posició de l'exemplar dins de la llista d'exemplars.
     * @param usuariPos Posició de l'usuari dins de la llista d'usuaris.
     * @param esLlarg Indica si el préstec és llarg.
     * @throws BiblioException Quan: - L'exemplar no és disponible
     *                               - L'usuari té préstec endarrerit
     *                               - L'usuari alcança el nombre màxim de préstecs
     *                               - Intentar fer un préstec llarg s'un exemplar que no ho permet
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException;

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position Posició del préstec dins de la llista de préstecs.
     * @throws BiblioException Si l'index és més gran que el size
     */
    public void retornarPrestec(int position) throws BiblioException;

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     * @return ArrayList amb tots els préstecs.
     */
    public ArrayList<Prestec> recuperaPrestecs();

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     * @return ArrayList amb els préstecs no retornats.
     */
    public ArrayList<Prestec> recuperaPrestecsNoRetornats();
}
