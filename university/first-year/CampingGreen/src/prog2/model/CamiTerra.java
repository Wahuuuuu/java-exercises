package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra (String nom_, boolean accesibilitat_, float longitud_) {
        super(nom_, accesibilitat_, longitud_);
    }

    public String toString() {
        return ( "Longitud " + this.longitud + " metres");
    }

    public boolean isAccessibilitat() {
        return false;
    }
}
