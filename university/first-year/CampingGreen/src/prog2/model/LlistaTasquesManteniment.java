package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {
    protected ArrayList<TascaManteniment> tasques;


    public LlistaTasquesManteniment() {
        this.tasques = new ArrayList<TascaManteniment>();
    }


    /**
     * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
     * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
     * @param num Número d'identificació de la tasca.
     * @param tipus Aquest String permet crear el enum TipusTascaManteniment
     * @param allotjament Allotjament on s'afegeix la tasca
     * @param data Data quan genera la tasca
     * @param dies Número de dies esperats per completar la tasca
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
     */
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        InTascaManteniment.TipusTascaManteniment tipusTasca;
        try {
            tipusTasca = InTascaManteniment.TipusTascaManteniment.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("no s'ha pogut afegit la tasca, tipus no conegut");
        }

        // Crea tascaManteniment
        TascaManteniment tasca = new TascaManteniment(num, tipusTasca, allotjament, data, dies);

        // Comprovar l'allotjament no té tasca
        if (!allotjament.isOperatiu()) throw new ExcepcioCamping("no s'ha pogut afegit la tasca, l'allotjament ja té tasca");

        // afegir tasca
        this.tasques.add(tasca);

    }

    /**
     * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     * @param tasca Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping quan l'allotjament no té tasca
     */
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        if (!tasca.getAllotjament().isOperatiu()) throw new ExcepcioCamping("L'allotjament no té ninguma tasca, no es pot completar la seva tasca");

        tasca.getAllotjament().obrirAllotjament();
    }

    /**
     * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
     * En cas que no hi hagi cap tasca llança una excepció.
     * @return String
     * @throws ExcepcioCamping
     */
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        boolean found = false;
        StringBuffer missatge = new StringBuffer();
        for (TascaManteniment tasca : this.tasques) {
            if (found) missatge.append(", ");
            found = true;
            missatge.append(tasca.getNum());
        }

        if (!found) throw new ExcepcioCamping("no hi hagi cap tasca en la llista" );
        return missatge.toString();
    }

    /**
     * Busca la tasca amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     * @param num Número d'identificació de la tasca.
     * @return Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
     */
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        for (TascaManteniment tasca : this.tasques) {
            if (tasca.getNum() == num) return tasca;
        }

        throw new ExcepcioCamping("No existeix la tasca " + num + " en la llista de tasques");
    }

}

