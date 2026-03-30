package prog2.model;

public abstract class AccesTerra extends Acces {
    protected float longitud;  // longitud del acces en metro

    // constructor
    public AccesTerra(String nom_, boolean accesibilitat_, float longitud_) {
        super(nom_, accesibilitat_);
        this.longitud = longitud_;
    }

    // methods
    public float getLongitud() { return this.longitud; }

    public void setLongitud(float longitud_) { this.longitud = longitud_; }

    public abstract String toString();

    public abstract boolean isAccessibilitat();
}
