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
     * @throws ExcepcioCamping quan l'allotjament ja té una tasca o
     *                              el tipus de tasca que es vol afegir no existeix.
     */
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        InTascaManteniment.TipusTascaManteniment tipusTasca;
        try {
            tipusTasca = InTascaManteniment.TipusTascaManteniment.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("No s'ha pogut afegir la tasca: tipus " + tipus + " no conegut. " +
                                      "Ha de ser un de les següents opcions: Reparacio, Neteja, RevisioTecnica, Desinfeccio");
        }

        // Crea tascaManteniment
        TascaManteniment tasca = new TascaManteniment(num, tipusTasca, allotjament, data, dies);

        // Comprovar l'allotjament no té tasca
        if (!allotjament.isOperatiu()) {
            throw new ExcepcioCamping("no s'ha pogut afegit la tasca, " +
                                      "l'allotjament amb l'id " + allotjament.getId() + " ja té tasca");
        }

        // afegir tasca
        this.tasques.add(tasca);
        allotjament.tancarAllotjament(tasca);
    }

    /**
     * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     * @param tasca Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping quan la llista no conté la tasca passat com a paràmetre
     *                         o quan l'allotjament no té tasca
     */
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        // comprovar que la llista conté la tasca
        try {
            this.getTascaManteniment(tasca.getNum());
        } catch (ExcepcioCamping e) {
            throw new ExcepcioCamping("No es pot completar la tasca: la llista no conté la tasca amb el nombre " + tasca.getNum() + " .");
        }

        //  comprovar que el allotjament té tasca
        Allotjament allotjament = tasca.getAllotjament();
        if (allotjament.isOperatiu()) {
            throw new ExcepcioCamping("No s'ha pogut completar la tasca: l'allotjament amb l'id " + tasca.getAllotjament().getId() +
                                      " no té ninguma tasca.");
        }

        // completar la tasca
        allotjament.obrirAllotjament();
        this.tasques.remove(tasca);
    }

    /**
     * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
     * En cas que no hi hagi cap tasca llança una excepció.
     * @return String
     * @throws ExcepcioCamping si la llista és buida
     */
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        if (this.tasques.isEmpty()) throw new ExcepcioCamping("No s'ha pogut llistar les tasques: la llista és buida." );

        StringBuffer missatge = new StringBuffer();
        for (TascaManteniment tasca : this.tasques) {
            if (!missatge.isEmpty()) missatge.append(", \n");
            missatge.append(tasca.toString());
        }

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

        throw new ExcepcioCamping("la llista no conté la tasca amb el nombre " + num + " .");
    }

}

