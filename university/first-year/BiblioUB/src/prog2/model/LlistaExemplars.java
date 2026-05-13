package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Defineix la llista d'exemplars de la biblioteca
 * @author Yanzhe Chen
 */
public class LlistaExemplars extends Llista<Exemplar> {
    // constructor
    /**
     * Crea una llista buida d'exemplars
     */
    public LlistaExemplars() {
        this.llista = new ArrayList<Exemplar>();
    }

    // methods
    /**
     * Returns true si la llista ja conté l'exemplar amb l'id passat, false si no
     *
     * @param idToSearch L'id a buscar
     * @return true si la llista ja conté l'exemplar amb l'id passat, false si no
     */
    protected boolean contains(String idToSearch) {
        Iterator<Exemplar> iterator = this.llista.iterator();
        while (iterator.hasNext()) {
            String currId = iterator.next().getId();
            if (currId.equals(idToSearch)) return true;
        }

        return false;
    }

    /**
     * Afegeix un exemplar a la llista
     *
     * @param exemplar l'exemplar a afegir
     * @throws BiblioException si la llista ja conté un exemplar amb el mateix id
     */
    @Override
    public void afegir(Exemplar exemplar) throws BiblioException {
        if (this.contains(exemplar.getId())) {
            throw new BiblioException("No s'ha pogut afegir l'exemplar: la llista ja conté un exemplar amb l'id " + exemplar.getId());
        }

        this.llista.add(exemplar);
    }



}
