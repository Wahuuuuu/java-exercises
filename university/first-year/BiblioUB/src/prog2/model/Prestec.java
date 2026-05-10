package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

public abstract class Prestec implements InPrestec {
    private Exemplar exemplar;
    private Usuari usuari;
    private boolean retornat;

    private Date dataCreacio;
    private Date dataLimitRetorn;

    // constructor
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

    public void setExemplar(Exemplar exemplar) { this.exemplar = exemplar; }
    public Exemplar getExemplar() { return this.exemplar; }

    public void setUsuari(Usuari usuari) { this.usuari = usuari; }
    public Usuari getUsuari() { return this.usuari; }

    public void setDataCreacio(Date data) { this.dataCreacio = data; }
    public Date getDataCreacio() { return this.dataCreacio; }

    public void setDataLimitRetorn(Date data) { this.dataLimitRetorn = data; }
    public Date getDataLimitRetorn() { return this.dataLimitRetorn; }

    public String tipusPrestec() { return "Undefined prestec"; }

    public void setRetornat(boolean retornat) { this.retornat = retornat; }
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
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    public long duradaPrestec() {
        return 0L;  // valor default
    }

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    public boolean prestecEndarrerit() {
        Date ara = new Date();
        return (!this.retornat && ara.after(this.dataLimitRetorn));
    }

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
