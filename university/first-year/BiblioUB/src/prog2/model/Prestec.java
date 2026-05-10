package prog2.model;

import java.util.Date;

public abstract class Prestec implements InPrestec {
    private Exemplar exemplar;
    private Usuari usuari;
    private boolean retornat;

    private Date dataCreacio;
    private Date dataLimitRetorn;

    // constructor
    public Prestec(Exemplar exemplar_, Usuari usuari_, Date dataCreacio, Date dataLimitRetorn /*, boolean retornat*/) {
        this.exemplar = exemplar_;
        this.usuari = usuari_;
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
     * Retornar prestec.
     */
    public void retorna() {
        // TODO
    }

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    public long duradaPrestec() {
        return 0; // TODO
    }

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    public boolean prestecEndarrerit() {
        return false; // TODO
    }

    @Override
    public String toString() {
        return "TODO"; // TODO
    }
}
