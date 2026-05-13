package prog2.vista;

public class IniciadorBiblioUB {
    private BiblioUB biblioUB;

    public IniciadorBiblioUB() {
        this.biblioUB = new BiblioUB();
    }

    public void iniciar() {
        biblioUB.gestioBiblioUB();
    }

}
