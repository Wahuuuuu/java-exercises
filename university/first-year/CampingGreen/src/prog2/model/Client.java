package prog2.model;

import prog2.vista.ExcepcioCamping;

public class Client implements InClient {
    private String nom;
    private String dni;  // 9 digits String


    public Client() {
        this.nom = "Default";
        this.dni = "Default";
    }

    public Client(String nom, String dni) throws ExcepcioCamping {
        if (dni.length() != 9) throw new ExcepcioCamping("No s'ha pogut inicialitzar el client: el dni ha de tenir 9 dígits.");
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
        return( this.nom + " amb DNI: " + this.dni + ".");
    }
}
