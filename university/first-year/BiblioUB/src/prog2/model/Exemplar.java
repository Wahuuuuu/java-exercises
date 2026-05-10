package prog2.model;

public class Exemplar implements InExemplar {
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean disponible;

    // Constructor:
    public Exemplar(String id_, String titol_, String autor_, boolean admetPrestecLlarg_, boolean disponible_) {
        this.id = id_;
        this.titol = titol_;
        this.autor = autor_;
        this.admetPrestecLlarg = admetPrestecLlarg_;
        this.disponible = disponible_;
    }

    // getters and setters:
    // ------------------------
    public void setId(String id) { this.id = id; }
    public String getId() { return this.id; }

    public void setTitol(String titol) { this.titol = titol; }
    public String getTitol() { return this.titol; }

    public void setAutor(String autor) { this.autor = autor; }
    public String getAutor() { return this.autor; }

    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) { this.admetPrestecLlarg = admetPrestecLlarg; }
    public boolean getAdmetPrestecLlarg() { return this.admetPrestecLlarg; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public boolean isDisponible() { return this.disponible; }

    // methods:
    // ------------------------

    /* 	Id=0, Titol=El Quijote, Autor=Miguel de Cervantes Saavedra, Admet Prestec Llarg=true, Disponible=true */
    public String toString() {
        return ("Id=" + this.id +
                ", Titol=" + this.titol +
                ", Autor = " + this.autor +
                ", Admet Prestec Llarg=" + this.admetPrestecLlarg +
                "Disponible=" + this.disponible
        );
    }

}
