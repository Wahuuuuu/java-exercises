package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;
import prog2.vista.BiblioException;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.*;
import java.util.Iterator;

/**
 * Adaptador utilitzada per intervenir entre la vista i les dades del model.
 * @author Yanzhe Chen
 */
public class Adaptador implements Serializable {
    public Dades dades;

    // constructor
    /**
     * Crea un adaptador amb dades buides
     */
    public Adaptador() {
        this.dades = new Dades();
    }

    // methods:
    // ------------

    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     *
     * @throws BiblioException Si l'id ja existeix
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        this.dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    /**
     * Retorna la llista d'exemplars en format textual.
     *
     * @return ArrayList amb tots els exemplars en format textual.
     */
    public ArrayList<String> recuperaExemplars() {
        return converteixAString(this.dades.recuperaExemplars());
    }


    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix.
     *
     * @throws BiblioException Si la llista ja conté un usuari amb el mateix email
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        this.dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    /**
     * Retorna la llista d'usuaris en format textual.
     *
     * @return ArrayList amb tots els usuaris.
     */
    public ArrayList<String> recuperaUsuaris() {
        return converteixAString(this.dades.recuperaUsuaris());
    }


    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar i usuari dins dels seus ArrayLists.
     *
     * @throws BiblioException Quan: - L'exemplar no és disponible
     *                               - L'usuari té préstec endarrerit
     *                               - L'usuari alcança el nombre màxim de préstecs
     *                               - Intentar fer un préstec llarg s'un exemplar que no ho permet
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        this.dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @throws BiblioException Si l'index és més gran que el size
     */
    public void retornarPrestec(int position) throws BiblioException { this.dades.retornarPrestec(position); }

    /**
     * Retorna la llista dels préstecs en format textual.
     *
     * @return ArrayList amb tots els préstecs en format textual.
     */
    public ArrayList<String> recuperaPrestecs() {
        return converteixAString(this.dades.recuperaPrestecs());
    }

    /**
     * Retorna la llista dels préstecs no retornats en format textual.
     *
     * @return ArrayList amb els préstecs no retornats en format textual.
     */
    public ArrayList<String> recuperaPrestecsNoRetornats() {
        return converteixAString(this.dades.recuperaPrestecsNoRetornats());
    }


    /**
     * Guarda els dades en el fixer del camí destí.
     *
     * @param camiDesti El path del fitxer.
     * @throws BiblioException Si no es troba el fitxer destí o si es ocorreix IOException.
     */
    public void guardaDades(String camiDesti) throws BiblioException {
        File fitxer = new File(camiDesti);

        try {
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(dades);

            fout.close();
        } catch (FileNotFoundException e) {
            throw new BiblioException("No s'ha pogut guardar els dades: fitxer destí no trobat");
        } catch (IOException e) {
            throw new BiblioException("No s'ha pogut guardar els dades: IOException ocorregut al guardar dades a fitxer");
        }
    }

    /**
     * Retorna un objecte adaptador, usant un fitxer.
     *
     * @param camiOrigen Camí al fitxer de dades.
     * @return Adaptador que guarda els dades.
     * @throws BiblioException Quan: - No es troba el fitxer
     *                               - Es ocorreix IOException
     *                               - Es ocorreix ClassNotFound
     */
    public Adaptador carregaDades(String camiOrigen) throws BiblioException {
        File fitxer = new File (camiOrigen);

        try {
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);

            return (Adaptador) ois.readObject();

        } catch (FileNotFoundException e) {
            throw new BiblioException("No s'ha pogut carregar els dades: fitxer no trobat");
        } catch (IOException e) {
            throw new BiblioException("No s'ha pogut carregar els dades: IOException ocurregut");
        } catch (ClassNotFoundException e) {
            throw new BiblioException("No s'ha pogut carregar els dades: ClassNotFound ocurregut");
        }
    }

    /**
     * Retorna un ArrayList<String> que conté resultat de .toString() a tots els elements del ArrayList original.
     * Itera la llista amb Iterator.
     *
     * @param llista La llista a convertir.
     * @return ArrayList<String>
     * @param <T> Tipus dels elements en la ArrayList original.
     */
    private <T> ArrayList<String> converteixAString(ArrayList<T> llista) {
        ArrayList<String> resultat = new ArrayList<>();

        Iterator<T> it = llista.iterator();
        while (it.hasNext()) {
            resultat.add(it.toString());
        }

        return resultat;
    }
}
