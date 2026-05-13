package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

/**
 * Representa un préstec normal de la biblioteca
 * @author Yanzhe Chen
 */
public class PrestecNormal extends Prestec {
    // constructor
    /**
     * Crea un préstec normal amb les dades donades
     * @param exemplar_ L'exemplar del préstec
     * @param usuari_ L'usuari del préstec
     * @param dataCreacio_ La data creació del préstec
     */
    public PrestecNormal(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        super(exemplar_, usuari_, dataCreacio_);
    }

    // methods
    /**
     * Retorna el tipus de préstec.
     *
     * @return Tipus de préstec. En aquest cas, "Normal".
     */
    @Override
    public String tipusPrestec() { return "Normal"; }

    /**
     * Retorna la durada del préstec: 70000ms
     *
     * @return Durada del préstec.
     */
    @Override
    public long duradaPrestec() {
        return 70L * 1000;
    }

    /**
     * Retornar el préstec i decreix el num prestec normal de l'usuari
     *
     * @throws BiblioException si el préstec és retornat o si el préstec corresponent és disponible
     */
    @Override
    public void retorna() throws BiblioException {
        super.retorna();

        this.getUsuari().setNumPrestecsNormals(this.getUsuari().getNumPrestecsNormals() - 1);
    }
}
