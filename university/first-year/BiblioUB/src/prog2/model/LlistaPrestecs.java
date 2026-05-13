package prog2.model;

import java.util.ArrayList;

/**
 * Defineix la llista de préstecs de la biblioteca
 * @author Yanzhe Chen
 */
public class LlistaPrestecs extends Llista<Prestec> {
    // constructor
    /**
     * Crea una llista buida de préstecs
     */
    public LlistaPrestecs() {
        this.llista = new ArrayList<Prestec>();
    }

    // method
    /**
     * Afegeix un préstec a la llista
     * @param prestec El préstec a afegir
     */
    @Override
    public void afegir(Prestec prestec) {
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
