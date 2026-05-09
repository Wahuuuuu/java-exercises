package prog2.model;

public class Exemplar implements InExemplar {
    protected int id;
    protected String titol;
    protected String autor;
    protected boolean AdmetPrestecLlarg;

    // Constructor:

    // getters and setters:
    // ------------------------
    public void setId(String id);
    public String getId();

    public void setTitol(String titol);
    public String getTitol();

    public void setAutor(String autor);
    public String getAutor();

    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg);
    public boolean getAdmetPrestecLlarg();


    // methods:
    // ------------------------
    public String toString();
}
