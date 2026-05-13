package prog2.model;

import prog2.vista.BiblioException;
import java.util.Date;

/**
 * Defineix el comportament comú dels préstecs de la bibioteca.
 */
public interface InPrestec {

    /**
     * Assigna l'exemplar associat al préstec.
     *
     * @param exemplar Exemplar associat al préstec.
     */
    void setExemplar(Exemplar exemplar);
    /**
     * Retorna l'exemplar associat al préstec.
     *
     * @return Exemplar associat al préstec.
     */
    Exemplar getExemplar();

    /**
     * Assigna l'usuari associat al préstec.
     *
     * @param usuari Usuari associat al préstec.
     */
    void setUsuari(Usuari usuari);
    /**
     * Retorna l'usuari associat al préstec.
     *
     * @return Usuari associat al préstec.
     */
    Usuari getUsuari();

    /**
     * Assigna la data de creació del préstec.
     *
     * @param data Nova data de creació del préstec.
     */
    void setDataCreacio(Date data);
    /**
     * Retorna la data de creació del préstec.
     *
     * @return Data de creació del préstec.
     */
    Date getDataCreacio();

    /**
     * Assigna la data límit de retorn del préstec.
     *
     * @param data Nova data límit de retorn del préstec.
     */
    void setDataLimitRetorn(Date data);
    /**
     * Retorna la data límit de retorn del préstec.
     *
     * @return Data límit de retorn del préstec.
     */
    Date getDataLimitRetorn();

    /**
     * Retorna el tipus de préstec.
     *
     * @return Tipus de préstec.
     */
    String tipusPrestec();

    /**
     * Assigna l'estat de retorn del préstec.
     *
     * @param retornat Cert si el préstec ha estat retornat, fals altrament.
     */
    void setRetornat(boolean retornat);
    /**
     * Indica si el préstec ha estat retornat.
     *
     * @return Cert si el préstec ha estat retornat, fals altrament.
     */
    boolean getRetornat();

    /**
     * Retornar prestec. Pot throw BiblioException.
     *
     * @throws BiblioException Si l'exemplar és disponible o si aquest préstec és retornat
     */
    void retorna() throws BiblioException;

    /**
     * Retorna la durada del préstec.
     * La durada del préstec depèn del tipus de préstec.
     *
     * @return Durada del préstec.
     */
    long duradaPrestec();

    /**
     * Indica si el préstec està endarrerit respecte a la data actual.
     *
     * @return Cert si el préstec està endarrerit, fals altrament.
     */
    boolean prestecEndarrerit();

    /**
     * Retorna un String que conté totes les informacions del préstec
     *
     * @return String que conté totes les informacions del préstec
     */
    @Override
    String toString();
}
