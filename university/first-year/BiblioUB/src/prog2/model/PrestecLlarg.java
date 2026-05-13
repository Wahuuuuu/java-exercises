package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

/**
 * Representa un préstec llarg de la biblioteca
 * @author Yanzhe Chen
 */
public class PrestecLlarg extends Prestec {
    // constructor
    /**
     * Crea un préstec llarg amb les dades donades
     * @param exemplar_ L'exemplar del préstec
     * @param usuari_ L'usuari del préstec
     * @param dataCreacio_ La data creació del préstec
     */
    public PrestecLlarg(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        super(exemplar_, usuari_, dataCreacio_);
    }

    // methods
    /**
     * Retorna el tipus de préstec.
     *
     * @return Tipus de préstec, en aquest cas, "Llarg".
     */
    @Override
    public String tipusPrestec() { return "Llarg"; }

    /**
     * Retorna la durada del préstec: 140000ms
     *
     * @return Durada del préstec.
     */
    @Override
    public long duradaPrestec() {
        return 140L * 1000;
    }

    /**
     * Retornar el préstec i decreix el num prestec llarg de l'usuari
     *
     * @throws BiblioException si el préstec és retornat o si el préstec corresponent és disponible
     */
    @Override
    public void retorna() throws BiblioException {
        super.retorna();

        this.getUsuari().setNumPrestecsLlargs(this.getUsuari().getNumPrestecsLlargs() - 1);
    }

}
