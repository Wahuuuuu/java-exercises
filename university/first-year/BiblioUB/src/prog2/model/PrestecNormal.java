package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

public class PrestecNormal extends Prestec {
    // constructor
    public PrestecNormal(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) throws BiblioException {
        super(exemplar_, usuari_, dataCreacio_);
    }

    // methods
    @Override
    public String tipusPrestec() { return "Normal"; }

    @Override
    public long duradaPrestec() {
        return 70L * 1000;
    }

    @Override
    public void retorna() {
        super.retorna();

        this.getUsuari().setNumPrestecsNormals(this.getUsuari().getNumPrestecsNormals() - 1);
    }
}
