package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

/**
 * Representa un préstec de la biblioteca
 * @author Yanzhe Chen
 */
public abstract class Prestec implements InPrestec {
    private Exemplar exemplar;
    private Usuari usuari;
    private boolean retornat;

    private Date dataCreacio;
    private Date dataLimitRetorn;

    // constructor
    /**
     * Crea un préstec amb les dades donades
     * @param exemplar_ L'exemplar del préstec
     * @param usuari_ L'usuari del préstec
     * @param dataCreacio_ La data creació del préstec
     */
    public Prestec(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        this.exemplar = exemplar_;
        this.usuari = usuari_;
        this.dataCreacio = new Date(dataCreacio_.getTime());
        this.dataLimitRetorn = new Date(this.dataCreacio.getTime() + this.duradaPrestec());
        this.retornat = false;

        this.exemplar.setDisponible(false);
    }

    // getters and setters:
    // ------------------------
    /**
     * Assigna l'exemplar associat al préstec.
     *
     * @param exemplar Exemplar associat al préstec.
     */
    public void setExemplar(Exemplar exemplar) { this.exemplar = exemplar; }
    /**
     * Retorna l'exemplar associat al préstec.
     *
     * @return Exemplar associat al préstec.
     */
    public Exemplar getExemplar() { return this.exemplar; }

    /**
     * Assigna l'usuari associat al préstec.
     *
     * @param usuari Usuari associat al préstec.
     */
    public void setUsuari(Usuari usuari) { this.usuari = usuari; }
    /**
     * Retorna l'usuari associat al préstec.
     *
     * @return Usuari associat al préstec.
     */
    public Usuari getUsuari() { return this.usuari; }

    /**
     * Assigna la data de creació del préstec.
     *
     * @param data Nova data de creació del préstec.
     */
    public void setDataCreacio(Date data) { this.dataCreacio = data; }
    /**
     * Retorna la data de creació del préstec.
     *
     * @return Data de creació del préstec.
     */
    public Date getDataCreacio() { return this.dataCreacio; }

    /**
     * Assigna la data límit de retorn del préstec.
     *
     * @param data Nova data límit de retorn del préstec.
     */
    public void setDataLimitRetorn(Date data) { this.dataLimitRetorn = data; }
    /**
     * Retorna la data límit de retorn del préstec.
     *
     * @return Data límit de retorn del préstec.
     */
    public Date getDataLimitRetorn() { return this.dataLimitRetorn; }

    /**
     * Retorna el tipus de préstec.
     *
     * @return Tipus de préstec.
     */
    public String tipusPrestec() { return "Undefined prestec"; }

    /**
     * Assigna l'estat de retorn del préstec.
     *
     * @param retornat Cert si el préstec ha estat retornat, fals altrament.
     */
    public void setRetornat(boolean retornat) { this.retornat = retornat; }
    /**
     * Indica si el préstec ha estat retornat.
     *
     * @return Cert si el préstec ha estat retornat, fals altrament.
     */
    public boolean getRetornat() { return this.retornat; }


    // methods:
    // ------------------------

    /**
     * Retornar el préstec
     *
     * @throws BiblioException si el préstec és retornat o si el préstec corresponent és disponible
     */
    public void retorna() throws BiblioException {
        if (this.exemplar.isDisponible() || this.retornat) {
            throw new BiblioException("No s'ha pogut retornar l'exemplar: l'exemplar amb l'id " + this.exemplar.getId() +
                                      " va ser retornat anteriorment!");
        }

        this.retornat = true;
        this.exemplar.setDisponible(true);
    }

    /**
     * Retorna la durada del préstec en ms.
     * La durada del préstec depèn del tipus de préstec.
     *
     * @return Durada del préstec.
     */
    public long duradaPrestec() {
        return 0L;  // valor default
    }

    /**
     * Indica si el préstec està endarrerit respecte a la data actual.
     *
     * @return Cert si el préstec està endarrerit, fals altrament.
     */
    public boolean prestecEndarrerit() {
        Date ara = new Date();
        return (!this.retornat && ara.after(this.dataLimitRetorn));
    }

    /**
     * Retorna un String que conté totes les informacions del préstec
     *
     * @return String que conté totes les informacions del préstec
     */
    @Override
    public String toString() {
        return ("Tipus=" + this.tipusPrestec() +
                ", Exemplar=" + this.exemplar.getTitol() +
                ", Usuari=" + this.usuari.getNom() +
                ", Data de creacio=" + this.dataCreacio.toString() +
                ", Data límit de retorn=" + this.dataLimitRetorn.toString() +
                ", Retornat=" + this.retornat
        );
    }

}
