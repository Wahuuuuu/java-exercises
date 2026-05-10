package prog2.model;

public class Estudiant extends Usuari {
    // constructor
    public Estudiant(String email_, String nom_, String adreca_) {
        super(email_, nom_, adreca_);
    }

    // getters and setters:
    // ------------------------

    public String tipusUsuari() { return "Estudiant"; }

    public int getMaxPrestecsNormals() { return 2; }

    public int getMaxPrestecsLlargs() { return 1; }

}
