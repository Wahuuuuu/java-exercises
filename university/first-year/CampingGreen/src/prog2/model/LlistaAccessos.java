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


    //  methods
    // -------------------
    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     * @param acc Objecte de tipus Acces.
     * @throws ExcepcioCamping si ja existeix l'accés en la llista
     */
    public void afegirAcces(Acces acc) {
        if (this.accessos.contains(acc)) {
            throw new ExcepcioCamping("No s'ha pogut afegir l'accés: ja existeix l'accés amb el nom " + acc.getNom() +
                                      " en la llista.");
        }
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
     */
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        if (this.accessos.isEmpty()) throw new ExcepcioCamping("No s'ha pogut llistar els accessos: la llista és buida." );

        StringBuffer missatge = new StringBuffer();
        for (Acces a : this.accessos) {
            if (a.getEstat() == estat) {
                if (!missatge.isEmpty()) missatge.append(", ");
                missatge.append(a.getNom());
            }
        }

        if (missatge.isEmpty()) throw new ExcepcioCamping("No s'ha pogut llistar els accessos: " +
                                                          "la llista no conté ningú accés amb l'estat " + estat + ".");
        return missatge.toString();
    }

    /**
     * Recorre tota la llista d'accessos i els tanca.
     * Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     */
    public void actualitzaEstatAccessos() {
        for (Acces a : this.accessos) {
            if (a.getAAllotjaments().containsAllotjamentOperatiu()) a.obrirAcces();
            else a.tancarAcces();
        }
    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat amb vehicles.
     * @return int
     */
    public int calculaAccessosNoAccessibles() {
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
    public float calculaMetresTerra() {
        float sumaMetres = 0;
        for (Acces a : this.accessos) {
            if (a instanceof AccesTerra) {
                sumaMetres += ((AccesTerra) a).getLongitud();
            }
        }

        return sumaMetres;
    }

}
