package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;

public class Dades implements InDades {

    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        // TODO
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     */
    public ArrayList<Exemplar> recuperaExemplars() {
        return new ArrayList<>(); // TODO
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        // TODO
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    public ArrayList<Usuari> recuperaUsuaris() {
        return new ArrayList<Usuari>(); // TODO
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar
     * i usuari dins dels seus ArrayLists
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        // TODO
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     */
    public void retornarPrestec(int position) throws BiblioException {
        // TODO
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    public ArrayList<Prestec> recuperaPrestecs() {
        return new ArrayList<Prestec>(); // TODO
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     */
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        return new ArrayList<Prestec>(); // TODO
    }
}
