package prog2.model;

public class Professor extends Usuari {
    // constructor
    public Professor(String email_, String nom_, String adreca_) {
        super(email_, nom_, adreca_);
    }

    // getters and setters:
    // ------------------------

    public String tipusUsuari() { return "Professor"; }

    public int getMaxPrestecsNormals() { return 2; }

    public int getMaxPrestecsLlargs() { return 2; }
}
