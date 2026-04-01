package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.Scanner;

import static prog2.model.InCamping.load;

public class VistaCamping {
    private Camping camping;
    private enum OpcionsMenu {
        LLISTAR_LA_INFORMACIO_DE_TOTS_ELS_ALLOTAMENTS,
        LLISTAR_LA_INFORMACIO_DELS_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_LA_INFORMACIO_DELS_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_LA_INFORMACIO_DELS_ACCESOS_OBERTS,
        LLISTAR_LA_INFORMACIO_DELS_ACCESOS_TANCATS,
        LLISTAR_LA_INFORMACIO_DELS_TASQUES_DE_MANTENIMENTS_ACTIVES,
        AFEGIR_UNA_TASCA_DE_MANTENIMENT,
        COMPLETAR_UNA_TASCA_DE_MANTENIMENT,
        MOSTRAR_EL_NOMBRE_TOTAL_ACCESOS_NO_ACCESSIBLES,
        MOSTRAR_EL_NOMBRE_TOTAL_DE_METRES_DELS_ACCESOS_DE_TERRA,
        GUARDAR_CAMPING,
        RECUPERAR_CAMPING,
        SORTIR_DE_LA_APLICACIO
    };
    private static final String[] DESCRIPCIONS = {};


    /**
     * Constructor per defecte, li ha de passar el nom del camping
     * @param nom
     */
    public VistaCamping(String nom) {
        this.camping = new Camping(nom);
        this.camping.inicialitzaDadesCamping();
    }

    /**
     * Començar la modificacio del camping, fins que es decideix a sortir
     */
    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);
        Menu<OpcionsMenu> menu = new Menu<OpcionsMenu>("Menú", OpcionsMenu.values());
        menu.setDescripcions(DESCRIPCIONS);

        boolean sortir = false;
        do {
            menu.mostrarMenu();
            OpcionsMenu opcio = menu.getOpcio(sc);

            switch (opcio) {
                case LLISTAR_LA_INFORMACIO_DE_TOTS_ELS_ALLOTAMENTS:
                    this.camping.llistarAllotjaments("Tot");
                    break;
                case LLISTAR_LA_INFORMACIO_DELS_ALLOTJAMENTS_OPERATIUS:
                    this.camping.llistarAllotjaments("Operatiu");
                    break;
                case LLISTAR_LA_INFORMACIO_DELS_ALLOTJAMENTS_NO_OPERATIUS:
                    this.camping.llistarAllotjaments("No Operatiu");
                    break;
                case LLISTAR_LA_INFORMACIO_DELS_ACCESOS_OBERTS:
                    this.camping.llistarAccessos("Obert");
                    break;
                case LLISTAR_LA_INFORMACIO_DELS_ACCESOS_TANCATS:
                    this.camping.llistarAccessos("Tancat");
                    break;
                case LLISTAR_LA_INFORMACIO_DELS_TASQUES_DE_MANTENIMENTS_ACTIVES:
                    this.camping.llistarTasquesManteniment();
                    break;
                case AFEGIR_UNA_TASCA_DE_MANTENIMENT:
                    this.afegirTascaManteniment(sc);
                    break;
                case COMPLETAR_UNA_TASCA_DE_MANTENIMENT:
                    this.completarTascaManteniment(sc);
                    break;
                case MOSTRAR_EL_NOMBRE_TOTAL_ACCESOS_NO_ACCESSIBLES:
                    System.out.println("Hi han " + this.camping.calculaAccessosNoAccessibles() + " accessos no accessibles");
                    break;
                case MOSTRAR_EL_NOMBRE_TOTAL_DE_METRES_DELS_ACCESOS_DE_TERRA:
                    System.out.println("Hi han " + camping.calculaAccessosNoAccessibles() + " metros dels accesos de terra");
                    break;
                case GUARDAR_CAMPING:
                    this.guardarCamping(sc);
                    break;
                case RECUPERAR_CAMPING:
                    this.recuperarCamping(sc);
                    break;
                case SORTIR_DE_LA_APLICACIO:
                    sortir = true;
                    break;
            }
        } while (!sortir);

        sc.close();
    }


    /**
     * Demana les informacions a l'usuali i afegeix una nova tasca al camping
     * @param sc
     * @throws ExcepcioCamping quan el tipus del valor introduït és invàlid,
     *                         o quan la tasca ja existeix en la llista de tasques,
     *                         o quan la tasca és invàlid
     */
    private void afegirTascaManteniment(Scanner sc) throws ExcepcioCamping{
        int num, dies;
        String tipus, idAllotjament, data;

        System.out.print("Introdueix els següents dades: num, tipus, idAllotjament, data, dies: ");
        try {
            num = sc.nextInt();
            tipus = sc.next();
            idAllotjament = sc.next();
            data = sc.next();
            dies = sc.nextInt();
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("algú dels tipus dels valors és invàlid: ha de ser int, String, String, String, int, respectivament");
        }

        this.camping.afegirTascaManteniment(num, tipus, idAllotjament, data, dies);
        System.out.println("S'ha afegit la tasca amb successió");
    }


    /**
     * Demana la informació d'una tasca a l'usuari, completa una tasca de manteniment i actualitza l'estat dels accesos.
     * @param sc
     * @throws ExcepcioCamping
     */
    private void completarTascaManteniment(Scanner sc) throws ExcepcioCamping {
            int id;

            System.out.print("Introdueix l'id de la tasca: ");
            try {
                id = sc.nextInt();
            } catch (IllegalArgumentException e) {
                throw new ExcepcioCamping("Tipus del valor és invàlid: l'id ha de ser un nombre enter");
            }

            this.camping.completarTascaManteniment(id);
            System.out.println("S'ha completat la tasca i actualitzat l'estat dels accessos amb succeció");
    }


    /**
     * Demana el camí destí del fitxer a l'usuari, i guarda dades del camping al fitxer corresponent
     * @param sc
     * @throws ExcepcioCamping
     */
    public void guardarCamping(Scanner sc) throws ExcepcioCamping {
        System.out.println("Introdueix el camí al fitxer que vols guardar el camping: ");
        String camiDesti = sc.next();

        this.camping.save(camiDesti);
        System.out.println("S'ha guardat dades del camping al fitxer " + camiDesti + " amb successió");
    }


    /**
     * Demana el camí origen del fitxer a l'usuri, i recuperar dades del camping en el fitxer al camping actual.
     * @param sc
     * @throws ExcepcioCamping
     */
    public void recuperarCamping(Scanner sc) throws ExcepcioCamping {
        System.out.println("Introdueix el camí al fitxer que conté dades d'un camping: ");
        String camiOrigen = sc.next();

        this.camping = camping.load(camiOrigen);
        System.out.println("S'ha recuperat dades del camping des del fitxer " + camiOrigen + " amb successió");
    }
}




