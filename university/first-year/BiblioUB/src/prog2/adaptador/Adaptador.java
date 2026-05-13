package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;
import prog2.vista.BiblioException;
import java.util.ArrayList;

import java.io.*;

public class Adaptador implements Serializable {
    public Dades dades;

    public Adaptador() {
        this.dades = new Dades();
    }


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
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        this.dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     */
    public ArrayList<Exemplar> recuperaExemplars() {
        return this.dades.recuperaExemplars();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        this.dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    public ArrayList<Usuari> recuperaUsuaris() {
        return this.dades.recuperaUsuaris();
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar
     * i usuari dins dels seus ArrayLists
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        this.dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     */
    public void retornarPrestec(int position) throws BiblioException { this.dades.retornarPrestec(position); }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    public ArrayList<Prestec> recuperaPrestecs() {
        return this.dades.recuperaPrestecs();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     */
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        return this.dades.recuperaPrestecsNoRetornats();
    }



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
}
