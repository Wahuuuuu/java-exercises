package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;

public class LlistaPrestecs extends Llista<Prestec> {
    // constructor
    public LlistaPrestecs() {
        this.llista = new ArrayList<Prestec>();
    }

    @Override
    public void afegir(Prestec prestec) throws BiblioException {
        this.llista.add(prestec);
        Usuari usuari = prestec.getUsuari();
        Exemplar exemplar = prestec.getExemplar();

        if (prestec.tipusPrestec().equals("Llarg")) {
            usuari.setNumPrestecsLlargs(usuari.getNumPrestecsLlargs() + 1);
        } else {
            usuari.setNumPrestecsNormals(usuari.getNumPrestecsNormals() + 1);
        }
    }

}
