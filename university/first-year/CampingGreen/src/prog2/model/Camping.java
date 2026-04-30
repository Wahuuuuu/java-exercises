package prog2.model;

import prog2.vista.ExcepcioCamping;
import prog2.vista.ExcepcioReserva;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping, Serializable {
    protected String nom;
    protected LlistaAccessos llistaAccessos;
    protected LlistaAllotjaments llistaAllotjaments;
    protected LlistaTasquesManteniment llistaTasquesManteniment;


    // Constructor
    public Camping(String nom_) {
        this.nom = nom_;
        this.llistaAccessos = new LlistaAccessos();
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
    }


    // getters and setters
    // -------------------------
    public LlistaAccessos getAccessos() { return this.llistaAccessos; }
    public void setAccessos(LlistaAccessos accessos_) { this.llistaAccessos = accessos_; }

    public LlistaAllotjaments getAllotjaments() { return this.llistaAllotjaments; }
    public void setAllotjaments(LlistaAllotjaments allotjaments_) { this.llistaAllotjaments = allotjaments_; }

    public LlistaTasquesManteniment getTasques() { return this.llistaTasquesManteniment; }
    public void setTasques(LlistaTasquesManteniment tasques_) { this.llistaTasquesManteniment = tasques_; }

    /**
     * Retorna el nom del càmping.
     * @return String
     */
    public String getNomCamping() {
        return this.nom;
    }
    public void setNomCamping(String nom_) { this.nom = nom_; }


    // methods
    // -------------------------

    /**
     * Llista els allotjaments segons el seu estat.
     * @param estat Estat dels allotjaments a llistar. (Operatiu, No Operatiu, Tot)
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en els següents casos:
     *                                         - La llista està buida, no hi hagi ningú allotjament
     *                                         - l'estat passat com a paràmetre és invàlid
     *                                         - no hi hagi allotjaments en l'estat passat com a paràmetre
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return this.llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Llista els accessos segons l'estat indicat.
     * @param infoEstat Estat dels accessos a llistar. (Obert, Tancat)
     * @return String
     * @throws ExcepcioCamping quan: el String infoEstat no coincideix a Obert o Tancat i
     *                               no hi hagi accessos en l'estat passat com a parametre.
     */
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        boolean estat;
        if (infoEstat.equals("Obert")) estat = true;
        else if (infoEstat.equals("Tancat")) estat = false;
        else throw new ExcepcioCamping("No s'ha pogut llistar els accessos: l'infoEstat ha de ser Obert o Tancat");

        return this.llistaAccessos.llistarAccessos(estat);
    }

    /**
     * Llista les tasques registrades al càmping.
     * @return String
     * @throws ExcepcioCamping si la llista és buida
     */
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return this.llistaTasquesManteniment.llistarTasquesManteniment();
    }

    /**
     * Afegeix una nova tasca al registre del càmping.
     * @param num Número identificador de la tasca.
     * @param tipus Tipus de tasca (en format string)
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data Data en què s'ha registrat la tasca.
     * @param dies Número esperat de dies per completar la tasca
     * @throws ExcepcioCamping Aquest mètode llançar excepció quan: no es troba l'allotjament,
     *                                                              l'allotjament ja té una tasca o
     *                                                              el tipus de tasca que es vol afegir no existeix.
     */
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = this.llistaAllotjaments.getAllotjament(idAllotjament);

        this.llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        this.llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Completa una tasca de manteniment existent identificada pel seu número.
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping quan no existeix l'allotjament amb id num o quan l'allotjament no té tasca
     */
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = this.llistaTasquesManteniment.getTascaManteniment(num);

        this.llistaTasquesManteniment.completarTascaManteniment(tasca);
        this.llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     * @return El nombre d'accessos accessibles. (int)
     */
    public int calculaAccessosNoAccessibles() {
        return this.llistaAccessos.calculaAccessosNoAccessibles();
    }

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     * @return La quantitat de metres. (float)
     */
    public float calculaMetresTerra() {
        return this.llistaAccessos.calculaMetresTerra();
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping quan: no es troba el fitxer destí
     *                               es ocurreix IOException
     */
    public void save(String camiDesti) throws ExcepcioCamping {
        File fitxer = new File(camiDesti);

        try {
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(this);

            fout.close();
        } catch (FileNotFoundException e) {
            throw new ExcepcioCamping("No s'ha pogut guardar el camping: fitxer destí no trobat");
        } catch (IOException e) {
            throw new ExcepcioCamping("No s'ha pogut guardar el camping: IOException ocorregut al guardar camping a fitxer");
        }
    }

    /**
     * Carrega l'estat d'un càmping des d'un fitxer.
     * @param camiOrigen Ruta del fitxer d'origen.
     * @return Una instància de la classe Camping carregada des del fitxer.
     * @throws ExcepcioCamping quan: no es troba el fitxer o
     *                               es ocurreix IOException i ClassNotFoundException
     */
    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        File fitxer = new File (camiOrigen);

        try {
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);

            return (Camping) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new ExcepcioCamping("No s'ha pogut carregar el camping: fitxer no trobat");
        } catch (IOException e) {
            throw new ExcepcioCamping("No s'ha pogut carregar el camping: IOException ocurregut");
        } catch (ClassNotFoundException e) {
            throw new ExcepcioCamping("No s'ha pogut carregar el camping: ClassNotFound ocurregut");
        }

    }


    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     */
    public void inicialitzaDadesCamping() {

        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);


    }


}
