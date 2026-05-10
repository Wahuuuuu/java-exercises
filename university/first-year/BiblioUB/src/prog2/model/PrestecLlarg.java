package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

public class PrestecLlarg extends Prestec {
    // constructor
    public PrestecLlarg(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) throws BiblioException {
        super(exemplar_, usuari_, dataCreacio_);
    }

    // methods
    @Override
    public String tipusPrestec() { return "Llarg"; }

    @Override
    public long duradaPrestec() {
        return 140L * 1000;
    }

    @Override
    public void retorna() {
        super.retorna();

        this.getUsuari().setNumPrestecsLlargs(this.getUsuari().getNumPrestecsLlargs() - 1);
    }

}
