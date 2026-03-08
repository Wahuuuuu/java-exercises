package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassaBarbacoa;
    {
        estadaMinimaBaixa = 3;
        estadaMinimaAlta = 5;
    }


    public MobilHome(String nom, String idAllotjaments, String mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(nom, idAllotjaments, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }


    // getters and setters
    // ---------------------------
    public boolean getTerrassaBarbacoa() { return this.terrassaBarbacoa; }
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }


    @Override
    public boolean correcteFuncionament() { return this.terrassaBarbacoa; }
}
