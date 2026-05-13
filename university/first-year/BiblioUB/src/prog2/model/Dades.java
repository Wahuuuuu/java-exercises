package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Defineix el conjunt de dades de la biblioteca.
 * @author Yanzhe Chen
 */
public class Dades implements InDades {
    private LlistaExemplars exemplars;
    private LlistaPrestecs prestecs;
    private LlistaUsuaris usuaris;

    /**
     * Crea un conjunt de dades buida
     */
    public Dades() {
        this.exemplars = new LlistaExemplars();
        this.prestecs = new LlistaPrestecs();
        this.usuaris = new LlistaUsuaris();
    }

    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     * @param id Identificador de l'exemplar.
     * @param titol Títol de l'exemplar.
     * @param autor Autor de l'exemplar.
     * @param admetPrestecLlarg Indica si l'exemplar admet préstec llarg.
     * @throws BiblioException si l'id ja existeix
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        Exemplar exemplar = new Exemplar(id, titol, autor, admetPrestecLlarg);
        this.exemplars.afegir(exemplar);
    }

    /**
     * Recuperar exemplars. Retorna un ArrayList amb tots els exemplars
     * @return ArrayList amb tots els exemplars.
     */
    public ArrayList<Exemplar> recuperaExemplars() {
        return this.exemplars.getArrayList();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     * @param email Email de l'usuari.
     * @param nom Nom de l'usuari.
     * @param adreca Adreça de l'usuari.
     * @param esEstudiant Indica si l'usuari és estudiant.
     * @throws BiblioException Si la llista ja conté un usuari amb el mateix email
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        Usuari usuari;
        if (esEstudiant) usuari = new Estudiant(email, nom, adreca);
        else usuari = new Professor(email, nom, adreca);

        this.usuaris.afegir(usuari);
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     * @return ArrayList amb tots els usuaris.
     */
    public ArrayList<Usuari> recuperaUsuaris() {
        return this.usuaris.getArrayList();
    }

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
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        Exemplar exemplar = this.exemplars.getAt(exemplarPos);
        Usuari usuari = this.usuaris.getAt(usuariPos);
        Prestec prestec;

        // Comprovacions d'exepcions:

        String iniciExcept = "No s'ha pogut afegir el préstec: ";
        if (!exemplar.isDisponible()) {  // L'exemplar no és disponible
            throw new BiblioException(iniciExcept + "l'exemplar amb l'id " + exemplar.getId() + " no és disponible!");
        }

        Iterator<Prestec> it = this.prestecs.getArrayList().iterator();
        while (it.hasNext()) {  // L'usuari té préstec endarrerit
            Prestec p = it.next();
            if (p.prestecEndarrerit() && (p.getUsuari().getEmail().equals(usuari.getEmail()))) {
                throw new BiblioException(iniciExcept + "l'usuari amb l'email " + usuari.getEmail() + " té préstec exdarrerit");
            }
        }

        if (esLlarg) {
            if (!exemplar.getAdmetPrestecLlarg()) {  // Intentar fer un préstec llarg s'un exemplar que no ho permet
                throw new BiblioException(iniciExcept + "l'exemplar amb l'id " + exemplar.getId() + "no admet préstec llarg!");
            }
            if (usuari.getMaxPrestecsLlargs() <= usuari.getNumPrestecsLlargs()) {  // L'usuari alcança el nombre màxim de préstecs Llargs
                throw new BiblioException(iniciExcept + "l'usuari ha alcançat el sel límit de préstecs llargs!");
            }
            prestec = new PrestecLlarg(exemplar, usuari, new Date());
        } else {
            if (usuari.getMaxPrestecsNormals() <= usuari.getNumPrestecsNormals()) {  // L'usuari alcança el nombre màxim de préstecs Normals
                throw new BiblioException(iniciExcept + "l'usuari ha alcançat el seu límit de préstecs normals!");
            }
            prestec = new PrestecNormal(exemplar, usuari, new Date());
        }

        // Fi dels comprovacions, afegir el préstec
        this.prestecs.afegir(prestec);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position Posició del préstec dins de la llista de préstecs.
     * @throws BiblioException Si l'index és més gran que el size
     */
    public void retornarPrestec(int position) throws BiblioException {
        this.prestecs.getAt(position).retorna();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     * @return ArrayList amb tots els préstecs.
     */
    public ArrayList<Prestec> recuperaPrestecs() {
        return this.prestecs.getArrayList();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     * @return ArrayList amb els préstecs no retornats.
     */
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        ArrayList<Prestec> prestecsNoRetornats = new ArrayList<Prestec>();

        Iterator<Prestec> it = this.prestecs.getArrayList().iterator();
        while (it.hasNext()) {
            Prestec p = it.next();
            if (!p.getRetornat()) prestecsNoRetornats.add(p);
        }

        return prestecsNoRetornats;
    }
}
