package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades {
    private LlistaExemplars exemplars;
    private LlistaPrestecs prestecs;
    private LlistaUsuaris usuaris;

    public Dades() {
        this.exemplars = new LlistaExemplars();
        this.prestecs = new LlistaPrestecs();
        this.usuaris = new LlistaUsuaris();
    }

    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     * @throws BiblioException si l'id ja existeix
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        Exemplar exemplar = new Exemplar(id, titol, autor, admetPrestecLlarg);
        this.exemplars.afegir(exemplar);
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     */
    public ArrayList<Exemplar> recuperaExemplars() {
        return this.exemplars.getArrayList();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        Usuari usuari;
        if (esEstudiant) usuari = new Estudiant(email, nom, adreca);
        else usuari = new Professor(email, nom, adreca);

        this.usuaris.afegir(usuari);
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    public ArrayList<Usuari> recuperaUsuaris() {
        return this.usuaris.getArrayList();
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar i usuari dins dels seus ArrayLists
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        Exemplar exemplar = this.exemplars.getAt(exemplarPos);
        Usuari usuari = this.usuaris.getAt(usuariPos);
        Prestec prestec;

        // Comprovacions d'exepcions:

        String iniciExcept = "No s'ha pogut afegir el préstec: ";
        if (!exemplar.isDisponible()) {  // 借阅一本不可借阅的书
            throw new BiblioException(iniciExcept + "l'exemplar amb l'id " + exemplar.getId() + " no és disponible!");
        }

        // 有超时书籍的用户借书
        Iterator<Prestec> it = this.prestecs.getArrayList().iterator();
        while (it.hasNext()) {
            Prestec p = it.next();
            if (p.prestecEndarrerit() && (p.getUsuari().getEmail().equals(usuari.getEmail()))) {
                throw new BiblioException(iniciExcept + "l'usuari amb l'email " + usuari.getEmail() + " té préstec exdarrerit");
            }
        }

        // 在已经达到借阅上限时借书
        if (esLlarg) {
            if (!exemplar.getAdmetPrestecLlarg()) {  // 尝试用不能长期借阅的书籍新建 PrestecLlarg 对象
                throw new BiblioException(iniciExcept + "l'exemplar amb l'id " + exemplar.getId() + "no admet préstec llarg!");
            }
            if (usuari.getMaxPrestecsLlargs() <= usuari.getNumPrestecsLlargs()) {  // 在已经达到借阅上限时借书 Llarg
                throw new BiblioException(iniciExcept + "l'usuari ha alcançat el sel límit de préstecs llargs!");
            }
            prestec = new PrestecLlarg(exemplar, usuari, new Date());
        } else {
            if (usuari.getMaxPrestecsNormals() <= usuari.getNumPrestecsNormals()) {  // 在已经达到借阅上限时借书 Normal
                throw new BiblioException(iniciExcept + "l'usuari ha alcançat el seu límit de préstecs normals!");
            }
            prestec = new PrestecNormal(exemplar, usuari, new Date());
        }

        // Fi dels comprovacions, comencar d'afegir
        this.prestecs.afegir(prestec);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     */
    public void retornarPrestec(int position) throws BiblioException {
        this.prestecs.getAt(position).retorna();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    public ArrayList<Prestec> recuperaPrestecs() {
        return this.prestecs.getArrayList();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
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
