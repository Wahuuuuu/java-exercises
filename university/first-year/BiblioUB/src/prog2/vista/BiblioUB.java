/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.List;
import java.util.Scanner;
import prog2.adaptador.Adaptador;

/**
 * Gestiona la interfície de text de l'aplicació BiblioUB.
 * Aquesta classe mostra els menús, llegeix les dades introduïdes per teclat
 * i crida l'adaptador per executar les operacions sobre la biblioteca.
 *
 * @author dortiz
 * @author Yanzhe Chen
 */
public class BiblioUB {

    /** Opcions disponibles al menú principal de l'aplicació. */
    static private enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_EXEMPLARS,
        MENU_PRINCIPAL_USUARIS,
        MENU_PRINCIPAL_PRESTECS,
        MENU_PRINCIPAL_SAVE,
        MENU_PRINCIPAL_LOAD,
        MENU_PRINCIPAL_EXIT};

    /** Descripcions de les opcions del menú principal. */
    static private String[] descMenuPrincipal={"Gestió Exemplars",
                                               "Gestió Usuaris",
                                               "Gestió Prestecs",
                                               "Guardar Dades",
                                               "Recuperar Dades",
                                               "Sortir"};

    /** Opcions disponibles al menú de gestió d'exemplars. */
    static private enum OpcionsMenuGestioExemplars {
        MENU_GESTIO_EXEMPLARS_ADD,
        MENU_GESTIO_EXEMPLARS_VIEW,
        MENU_GESTIO_EXEMPLARS_EXIT
    };
    /** Descripcions de les opcions del menú de gestió d'exemplars. */
    static private String[] descMenuGestioExemplars ={"Afegir Exemplar",
                                                      "Visualitzar Exemplars",
                                                      "Sortir"};

    /** Opcions disponibles al menú de gestió d'usuaris. */
    static private enum OpcionsMenuGestioClients {
        MENU_GESTIO_USUARIS_ADD,
        MENU_GESTIO_USUARIS_VIEW,
        MENU_GESTIO_USUARIS_EXIT
    };
    /** Descripcions de les opcions del menú de gestió d'usuaris. */
    static private String[] descMenuGestioUsuaris ={"Afegir Usuari",
                                                    "Visualitzar Usuaris",
                                                    "Sortir"};

    /** Opcions disponibles al menú de gestió de préstecs. */
    static private enum OpcionsMenuGestioPrestecs {
        MENU_GESTIO_PRESTECS_ADD,
        MENU_GESTIO_PRESTECS_REMOVE,
        MENU_GESTIO_PRESTECS_VIEW,
        MENU_GESTIO_PRESTECS_VIEW_URG,
        MENU_GESTIO_PRESTECS_EXIT
    };
    /** Descripcions de les opcions del menú de gestió de préstecs. */
    static private String[] descMenuGestioPrestecs ={"Afegir Prestec",
                                                     "Retornar Prestec",
                                                     "Visualitzar Prestecs",
                                                     "Visualitzar Prestecs no Retornats",
                                                     "Sortir"};

    
    /** Adaptador de l'aplicació */
    private Adaptador adaptador;

    // Constructor
    /* Constructor */
    public BiblioUB() {
        adaptador = new Adaptador();
    }


    // methods
    /**
     * Inicia la gestió principal de l'aplicació BiblioUB.
     * Mostra el menú principal i executa les opcions seleccionades per l'usuari.
     */
    public void gestioBiblioUB() {
        // Creem un objecte per llegir des del teclat
        Scanner sc = new Scanner(System.in);
        
        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Menu principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);
        
        OpcionsMenuPrincipal opcio;
        do {
            // Mostrem les opcions del menú i demanem una opció
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries per a la opció triada
            switch(opcio) {
                case MENU_PRINCIPAL_EXEMPLARS:
                    // Mostra el menú per a la gestió d'exemplars
                    menuGestioExemplars(sc);
                    break;

                case MENU_PRINCIPAL_USUARIS:
                    // Mostra el menú per a la gestió d'usuaris
                    menuGestioUsuaris(sc);
                    break;

                case MENU_PRINCIPAL_PRESTECS:
                    // Mostra el menú per a la gestió de prestecs
                    menuGestioPrestecs(sc);
                    break;

                case MENU_PRINCIPAL_SAVE:
                    // Guardar dades
                    String dstFile = getFilePath(sc,false); // Obtenir el fitxer de sortida
                    if(dstFile != null) {
                        // Guardar les dades al fitxer triat
                        try {
                             this.adaptador.guardaDades(dstFile);
                             System.out.println("Dades guardades");
                        } catch (BiblioException ex) {
                            System.err.println("Error guardant les dades: " + ex.getMessage());
                        }
                    }                   
                    break;
                case MENU_PRINCIPAL_LOAD:
                    // Carregar dades                   
                    String srcFile = getFilePath(sc,false); // Obtenir el fitxer d'entrada
                    if(srcFile != null) {
                        // Carregar les dades del fitxer triat
                        try {
                             this.adaptador.carregaDades(srcFile);
                             System.out.println("Dades carregades");
                        } catch(BiblioException ex) {
                            System.err.println("Error carregant les dades." + ex.getMessage());
                        }
                    }     
                    break;
                case MENU_PRINCIPAL_EXIT:
                    // Sortir      1
                    System.out.println("Sortint de l'aplicació...");
                    break;
            }
        } while(opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_EXIT);
    }

    /**
     * Mostra i gestiona el menú d'exemplars.
     * Permet afegir exemplars, visualitzar-los o tornar al menú principal.
     *
     * @param sc Scanner utilitzat per llegir les dades introduïdes per teclat.
     */
    private void menuGestioExemplars(Scanner sc) {
        Menu<OpcionsMenuGestioExemplars> menu = new Menu<>("Menu gestió dels exemplars", OpcionsMenuGestioExemplars.values());
        menu.setDescripcions(descMenuGestioExemplars);

        OpcionsMenuGestioExemplars opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch(opcio) {
                case MENU_GESTIO_EXEMPLARS_ADD:
                    afegirExemplar(sc);
                    break;

                case MENU_GESTIO_EXEMPLARS_VIEW:
                    showList("Llista dels exemplars", adaptador.recuperaExemplars());
                    break;

                case MENU_GESTIO_EXEMPLARS_EXIT:
                    System.out.println("Sortint del menú gestió dels exemplars...");
                    break;
            }

        } while (opcio != OpcionsMenuGestioExemplars.MENU_GESTIO_EXEMPLARS_EXIT);
    }

    /**
     * Demana les dades d'un nou exemplar i el crea a través de l'adaptador.
     *
     * @param sc Scanner utilitzat per llegir les dades introduïdes per teclat.
     */
    private void afegirExemplar(Scanner sc) {
        try {
            System.out.println("Introdueix l'id de l'exemplar: ");
            String id = sc.next();  sc.nextLine();

            System.out.println("Introdueix el títol: ");
            String titol = sc.nextLine();

            System.out.println("Introdueix l'autor: ");
            String autor = sc.nextLine();

            System.out.println("Admet préstec llarg? (s/n): ");
            boolean admetPrestecLlarg = textToBoolean(sc.next());  sc.nextLine();

            this.adaptador.afegirExemplar(id, titol, autor, admetPrestecLlarg);
            System.out.println("Exemplar afegit");

        } catch (BiblioException e) {
            System.err.println("Error al afegir exemplar: " + e.getMessage());
        }
    }

    /**
     * Mostra i gestiona el menú d'usuaris.
     * Permet afegir usuaris, visualitzar-los o tornar al menú principal.
     *
     * @param sc Scanner utilitzat per llegir les dades introduïdes per teclat.
     */
    private void menuGestioUsuaris(Scanner sc) {
        Menu<OpcionsMenuGestioClients> menu = new Menu<>("Menú gestió dels usuaris", OpcionsMenuGestioClients.values());
        menu.setDescripcions(descMenuGestioUsuaris);

        OpcionsMenuGestioClients opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch(opcio) {
                case MENU_GESTIO_USUARIS_ADD:
                    afegirUsuari(sc);
                    break;

                case MENU_GESTIO_USUARIS_VIEW:
                    showList("Llista del usuaris", adaptador.recuperaUsuaris());
                    break;

                case MENU_GESTIO_USUARIS_EXIT:
                    System.out.println("Sortint del menú gestió dels usuaris...");
                    break;
            }

        } while (opcio != OpcionsMenuGestioClients.MENU_GESTIO_USUARIS_EXIT);
    }

    /**
     * Demana les dades d'un nou usuari i el crea a través de l'adaptador.
     *
     * @param sc Scanner utilitzat per llegir les dades introduïdes per teclat.
     */
    private void afegirUsuari(Scanner sc){
        try {
            System.out.println("Introdueix l'email de l'usuari: ");
            String email = sc.next(); sc.nextLine();

            System.out.println("Introdueix el nom de l'usuari: ");
            String nom = sc.next(); sc.nextLine();

            System.out.println("Introdueix l'adreça de l'usuari: ");
            String adreca = sc.nextLine();

            System.out.println("L'usuari és Estudiant? (s/n): ");
            boolean esEstudiant = textToBoolean(sc.next()); sc.nextLine();

            this.adaptador.afegirUsuari(email, nom, adreca, esEstudiant);
            System.out.println("Usuari afegit");
        }
        catch (BiblioException e) {
            System.err.println("Error afegint l'usuari: " + e.getMessage());
        }
    }

    /**
     * Mostra i gestiona el menú de préstecs.
     * Permet afegir préstecs, retornar-los, visualitzar tots els préstecs
     * o visualitzar només els préstecs no retornats.
     *
     * @param sc Scanner utilitzat per llegir les dades introduïdes per teclat.
     */
    private void menuGestioPrestecs(Scanner sc) {
        Menu<OpcionsMenuGestioPrestecs> menu = new Menu<>("Menú gestió dels préstecs", OpcionsMenuGestioPrestecs.values());
        menu.setDescripcions(descMenuGestioPrestecs);

        OpcionsMenuGestioPrestecs opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch(opcio) {
                case MENU_GESTIO_PRESTECS_ADD:
                    afegirPrestec(sc);
                    break;

                case MENU_GESTIO_PRESTECS_REMOVE:
                    cancelarPrestec(sc);
                    break;

                case MENU_GESTIO_PRESTECS_VIEW:
                    showList("Llista dels préstecs", this.adaptador.recuperaPrestecs());
                    break;

                case MENU_GESTIO_PRESTECS_VIEW_URG:
                    showList("Llista del préstecs no retornats", this.adaptador.recuperaPrestecsNoRetornats());
                    break;

                case MENU_GESTIO_PRESTECS_EXIT:
                    System.out.println("Sortint del menú gestió dels préstecs...");
                    break;
            }

        } while(opcio != OpcionsMenuGestioPrestecs.MENU_GESTIO_PRESTECS_EXIT);
    }

    /**
     * Demana les dades necessàries per crear un nou préstec i el crea a través de l'adaptador.
     *
     * @param sc Scanner utilitzat per llegir les dades introduïdes per teclat.
     */
    private void afegirPrestec(Scanner sc){

        try {
            showList("Llista dels exemplars", adaptador.recuperaExemplars());
            System.out.println("Introdeix l'index de l'exemplar: ");
            int exemplar = sc.nextInt();

            showList("Llista del usuaris", adaptador.recuperaUsuaris());
            System.out.println("Introdueix l'index de l'usuari: ");
            int usuari = sc.nextInt();

            System.out.println("És un préstec llarg? (s/n): ");
            boolean esLlarg = textToBoolean(sc.next());  sc.nextLine();

            this.adaptador.afegirPrestec(exemplar, usuari, esLlarg);
            System.out.println("Préstec afegit");
        }
        catch (BiblioException e) {
            System.err.println("Error afegint préstec: " + e.getMessage());
        }
    }

    /**
     * Demana la posició d'un préstec i el retorna a través de l'adaptador.
     *
     * @param sc Scanner utilitzat per llegir les dades introduïdes per teclat.
     */
    private void cancelarPrestec(Scanner sc){
        try {
            showList("Llista dels préstec", adaptador.recuperaPrestecs());
            System.out.println("Introdeix l'index del préstec: ");
            int prestec = sc.nextInt();

            this.adaptador.retornarPrestec(prestec);
            System.out.println("Préstec retornat");
        }
        catch (BiblioException e) {
            System.err.println("Error retornant préstec: " + e.getMessage());
        }
    }

     /**
     * Mostra una llista d'objectes
      *
     * @param title Títol a posar com a capçalera
     * @param lines Llista d'objectes per mostrar
     */
    private void showList(String title, List<String> lines) {
        System.out.println("============================================");
        System.out.println(title);
        System.out.println("============================================");
        int i = 0;
        for(String l : lines) {
            System.out.println("\t[" + (i++) + "] " + l);
        }
        System.out.println("============================================");
    }


    /**
     * Demana el camí d'un fitxer
     *
     * @param sc Objecte per a la lectura de dades de teclat
     * @param mustExist Exigeix que el fitxer existeixi (True) o no (False)
     * @return Ruta al fitxer entrada per l'usuari o null si s'ha cancelat
     */
    private String getFilePath(Scanner sc, boolean mustExist) {
        String filePath = null;

        // Mostrar el missatge demanant la entrada
        System.out.println("Entra ruta completa fitxer (o ENTER per ometre):");

            // Llegim la ruta del fitxer
            filePath = sc.nextLine();

            // Si la ruta està buida retornem un null
            if(filePath.isEmpty()) {
                return null;
            }

        return filePath;
    }

    /**
     * Retorna el valor booleà corresponent al text. Llença excepció si el text no és vàlid.
     *
     * @param text El text a convertir.
     * @return Valor booleà corresponent al text.
     * @throws BiblioException Si el text no és vàlid.
     */
    private boolean textToBoolean (String text) throws BiblioException {
        if (text.equals("s") || text.equals("S") || text.equals("y") || text.equals("Y") ) {
            return true;
        }

        if (text.equals("n") || text.equals("N")) {
            return false;
        }

        throw new BiblioException("Has d'introduir un valor vàlid: s/n");
    }

}
