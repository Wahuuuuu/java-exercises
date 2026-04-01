package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    protected ArrayList<Allotjament> allotjaments;

    /**
     * Constructor default
     */
    public LlistaAllotjaments() {
        this.allotjaments = new ArrayList<Allotjament>();
    }


    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     * @param allotjament Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (this.contains(allotjament)) throw new ExcepcioCamping("In class LlistaAllotjaments.afegirAllotjament: " +
                                                                  "Afegint allotjament que ja existeix");
        this.allotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    public void buidar() { this.allotjaments.clear(); }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     * The message contains an extra space at the end
     * @param estat String
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        boolean llistarTot = false;
        boolean operatiu = false;
        switch (estat) {
            case "Operatiu": operatiu = true;     break;
            case "No Operatiu": operatiu = false; break;
            case "Tot": llistarTot = true;        break;
            default:
                throw new ExcepcioCamping("Argument invàlid al llistar Allotjaments: " + estat
                    + "ha de ser un en les següents opcions: operatiu / no operatiu / tot");
        }

        boolean found = false;
        StringBuffer missatge = new StringBuffer();
        for (Allotjament a : this.allotjaments) {
            // si llistarTot es true, append tots els allotjaments
            // si no, append següent els requisits
            if (llistarTot || a.isOperatiu() == operatiu) {
                if (found) missatge.append("\n");
                found = true;
                missatge.append(a.toString());
            }
        }

        if (!found) throw new ExcepcioCamping("no hi hagi allotjaments en l'estat passat com a paràmetre" );
        return missatge.toString();
    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     * @return boolean
     */
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament a : this.allotjaments) {
            if (a.isOperatiu()) return true;
        }
        return false;
    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     * @param allotjament
     * @return boolean
     */
    public boolean contains(Allotjament allotjament) {
        String id = allotjament.getId();
        for (Allotjament a : this.allotjaments) {
            if (a.getId().equals(id)) return true;
        }

        return false;
    }

    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     * @param id String amb el id de l'allotjament
     * @return  Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament a : this.allotjaments) {
            if (a.getId().equals(id)) return a;
        }

        throw new ExcepcioCamping ("In LlistaAllotjaments.getAllotament: no encontrat l'allotjament rebut per parametre en la llista");

    }




}
