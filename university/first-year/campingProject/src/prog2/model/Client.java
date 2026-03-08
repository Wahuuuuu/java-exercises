package model;

public class Client implements InClient {
    private String nom;
    private String dni;

    public String getNom() { return this.nom; }

    public String getDni() { return this.dni; }

    public void setNom(String nom) { this.nom = nom; }

    public void setDni(String dni) { this.dni = dni; }
}
