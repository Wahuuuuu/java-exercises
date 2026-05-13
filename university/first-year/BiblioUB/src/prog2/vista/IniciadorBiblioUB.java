package prog2.vista;

/**
 * Classe iniciadora de l'aplicació BiblioUB.
 * S'encarrega de crear la vista principal i iniciar la gestió de la biblioteca.
 * @author Yanzhe Chen
 */
public class IniciadorBiblioUB {
    /** Vista principal de l'aplicació BiblioUB. */
    private BiblioUB biblioUB;

    /**
     * Crea un nou iniciador de l'aplicació i inicialitza la vista principal.
     */
    public IniciadorBiblioUB() {
        this.biblioUB = new BiblioUB();
    }

    /**
     * Inicia l'execució de l'aplicació BiblioUB.
     */
    public void iniciar() {
        biblioUB.gestioBiblioUB();
    }

}
