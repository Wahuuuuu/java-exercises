package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
public class LlistaAccessos {
    protected ArrayList<Acces> accessos;

    // Constructors
    // ------------------

    public LlistaAccessos() {
        this.accessos = new ArrayList<Acces>();
    }


    // other methods
    // -------------------

    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     * @param acc Objecte de tipus Acces.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        this.accessos.add(acc);
    }

    /**
     * Buida la llista d'accessos
     */
    public void buidar() {
        this.accessos.clear();
    }

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     * @param estat boolean
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     *
     */
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        boolean found = false;
        StringBuffer missatge = new StringBuffer();
        for (Acces a : this.accessos) {
            if (a.getEstat() == estat) {
                if (found) missatge.append(", ");
                found = true;
                missatge.append(a.getNom());

            }
        }

        if (!found) throw new ExcepcioCamping("no hi hagi accessos en l'estat passat com a paràmetre" );
        return missatge.toString();
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces a : this.accessos) {
            if (a.getAAllotjaments().containsAllotjamentOperatiu()) a.obrirAcces();
            else a.tancarAcces();
        }
    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     * @return int
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int comptador = 0;
        for (Acces a : this.accessos) {
            if (!a.isAccessibilitat()) comptador++;
        }

        return comptador;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     * @return float amb els metres totals.
     */
    public float calculaMetresTerra() throws ExcepcioCamping {
        float sumaMetres = 0;
        for (Acces a : this.accessos) {
            if (a instanceof AccesTerra) {
                sumaMetres += ((AccesTerra) a).getLongitud();
            }
        }

        return sumaMetres;
    }

}
