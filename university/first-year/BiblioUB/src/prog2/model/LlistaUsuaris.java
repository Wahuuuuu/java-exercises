package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> {
    // constructor
    public LlistaUsuaris() {
        this.llista = new ArrayList<Usuari>();
    }

    // methods:
    // ------------

    /**
     * Returns true si la llista ja conté l'usuari amb l'email passat, false si no
     *
     * @param emailToSearch L'email a buscar
     * @return true si la llista ja conté l'usuari amb l'email passat, false si no
     */
    protected boolean contains(String emailToSearch) {
        Iterator<Usuari> iterator = this.llista.iterator();
        while (iterator.hasNext()) {
            String currEmail = iterator.next().getEmail();
            if (currEmail.equals(emailToSearch)) return true;
        }

        return false;
    }

    /**
     * Afegir l'usuari a la llista
     * @param usuari l'usuari a afegir
     * @throws BiblioException si la llista ja conté un usuari amb el mateix email
     */
    @Override
    public void afegir(Usuari usuari) throws BiblioException {
        if (this.contains(usuari.getEmail())) {
            throw new BiblioException("No s'ha pogut afegir l'usuari: la llista ja conté un usuari amb l'email " + usuari.getEmail());
        }

        this.llista.add(usuari);
    }
}
