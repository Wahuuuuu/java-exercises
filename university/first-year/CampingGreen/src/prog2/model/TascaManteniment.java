package prog2.model;

public class TascaManteniment implements InTascaManteniment {

    protected int num;
    protected TascaManteniment.TipusTascaManteniment tipus;
    protected Allotjament allotjament;
    protected String data;
    protected int dies;


    // constructors
    // ------------------------

    public TascaManteniment(int num_, InTascaManteniment.TipusTascaManteniment tipus_, Allotjament allotjament_
                            , String data_, int dies_)
    {
        this.num = num_;
        this.tipus = tipus_;
        this.allotjament = allotjament_;
        this.data = data_;
        this.dies = dies_;

        allotjament.setIluminacio("0%");
    }


    // getters and setters
    // -------------------------

    /**
     * Retorna el número identificador de la tasca.
     * @return int
     */
    public int getNum() { return this.num; }

    /**
     * Retorna el tipus de tasca de manteniment.
     * @return TipusTascaManteniment
     */
    public TascaManteniment.TipusTascaManteniment getTipus() { return this.tipus; }

    /**
     * Retorna l'allotjament associat a la tasca.
     * @return Allotjament
     */
    public Allotjament getAllotjament() { return this.allotjament; }

    /**
     * Retorna la data de registre de la tasca.
     * @return String
     */
    public String getData() { return this.data; }

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     * @return int
     */
    public int getDies() { return this.dies; }

    /**
     * Assigna un nou número identificador a la tasca.
     * @param num_ Número identificador de la tasca.
     */
    public void setNum(int num_) { this.num = num_; }

    /**
     * Assigna el tipus de tasca de manteniment.
     * @param tipus_ Tipus de tasca.
     */
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {this.tipus = tipus_; }

    /**
     * Assigna l'allotjament associat a la tasca.
     * @param allotjament_ Allotjament afectat.
     */
    public void setAllotjament(Allotjament allotjament_) { this.allotjament = allotjament_; }

    /**
     * Assigna la data de registre de la tasca.
     * @param data_ Data de la tasca.
     */
    public void setData(String data_) { this.data = data_; }

    /**
     * Assigna el nombre de dies previstos per completar la tasca.
     * @param dies_ Nombre de dies.
     */
    public void setDies(int dies_) { this.dies = dies_; }

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca de manteniment.
     * @return String amb el percentatge d'il·luminació.
     */
    public String getIluminacioAllotjament() {
        return this.tipus.getIluminacio();
    }

    public String toString() {
        return (
                "num: " + this.num
              + ", tipus de tasca: " + this.tipus.toString()
              + ", id de l'allotjament corresponent: " + this.allotjament.getId()
              + ", data: " + this.data
              + ", dies: " + this.dies
                );
    }
}

