package prog2.model;

public class CarreteraTerra extends AccesTerra{
    protected float amplada;

    // constructor
    public CarreteraTerra (String nom_, boolean accesibilitat_, float longitud_, float amplada_) {
        super(nom_, accesibilitat_, longitud_);
        this.amplada = amplada_;
    }

    // methods
    public float getAmplada() { return this.amplada; }

    public void setAmplada(float amplada_) { this.amplada = amplada_; }

    public boolean isAccessibilitat() { return true; }

    public String toString() {
        return ("Longitud " + this.longitud + " metres, amplada " + this.amplada + " metres");
    }
}
