package prog2.model;

public class Client implements InClient {
    private String nom;
    private String dni;  // 9 digits String


    public Client() {
        this("Default", "Default");
    }

    public Client(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    public String getNom() { return this.nom; }
    public String getDni() { return this.dni; }

    public void setNom(String nom) { this.nom = nom; }
    public void setDni(String dni) { this.dni = dni; }

    /**
     * Retorna un String indecant els atributs de la classe Client
     * Format: <nom> amb DNI: <dni>.
     * @return
     */
    public String toString() {
        return( this.nom + " amb DNI: " + this.dni + ". ");
    }
}
