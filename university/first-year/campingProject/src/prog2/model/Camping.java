package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements  InCamping {
    private String nom;
    private ArrayList<Client> llistaClients;
    private ArrayList<Allotjament> llistaAllotjaments;
    private LlistaReserves llistaReserves;


    // constructor
    public Camping(String nom) {
        this.nom = nom;
        this.llistaClients = new ArrayList<Client>();
        this.llistaAllotjaments = new ArrayList<Allotjament>();
        this.llistaReserves = new LlistaReserves();
    }


    /**
     * Retorna el nom del càmping.
     * @return el nom del càmping.
     */
    public String getNom() { return this.nom; }

    /**
     * Retorna la llista de reserves del camping.
     * @return
     */
    public LlistaReserves getLlistaReserves() { return this.llistaReserves; }

    /**
     * Retorna la llista d'allotjaments del camping.
     */
    public ArrayList<Allotjament> getLlistaAllotjaments() { return this.llistaAllotjaments; };

    /**
     * Retorna la llista de clients del camping.
     * @return
     */
    public ArrayList<Client> getLlistaClients() { return this.llistaClients; }

    /**
     * Retorna el número total d'allotjaments del càmping.
     * @return el número total d'allotjaments.
     */
    public int getNumAllotjaments() { return this.llistaAllotjaments.size(); }

    /**
     * Retorna el número total de reserves del càmping.
     * @return el número total de reserves.
     */
    public int getNumReserves() { return llistaReserves.getNumReserves(); }

    /**
     * Retorna el número total de clients del càmping.
     * @return el número total de clients.
     */
    public int getNumClients() { return llistaClients.size(); }


    /**
     * Crea un nou objecte de tipus Client i l'afegeix a la llista de clients.
     * @param nom_ el nom del nou client.
     * @param dni_ el DNI del nou client.
     */
    public void afegirClient(String nom_, String dni_) {
        llistaClients.add(new Client(nom_, dni_));
    }


    /**
     * Afegeix una nova parcel·la a la llista d'allotjaments.
     * @param nom_ el nom de la parcela.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param metres la mida de la parcela.
     * @param connexioElectrica true si disposa de connexió elèctrica, false altrament.
     */
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        llistaAllotjaments.add(new Parcela(nom_, idAllotjament_, metres, connexioElectrica));
    }


    /**
     * Afegeix un nou bungalow a la llista d'allotjaments.
     * @param nom_ el nom del bungalow.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param mida la mida del bungalow.
     * @param habitacions el nombre d'habitacions del bungalow.
     * @param placesPersones el nombre màxim de places per a persones.
     * @param placesParquing el nombre de places de pàrquing disponibles.
     * @param terrassa true si disposa de terrassa, false altrament.
     * @param tv true si disposa de televisió, false altrament.
     * @param aireFred true si disposa d'aire condicionat, false altrament.
     */
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        llistaAllotjaments.add(new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing,
                terrassa, tv, aireFred));
    }


    /**
     * Afegeix un bungalow premium a la llista d'allotjaments.
     * @param serveisExtra true si ofereix serveis extra.
     * @param codiWifi el codi de la xarxa Wi-Fi.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi) {
        llistaAllotjaments.add(new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing,
                terrassa, tv, aireFred, serveisExtra, codiWifi));
    }

    /**
     * Afegeix una casa glamping a la llista d'allotjaments.
     * @param material el material del que està fet.
     * @param casaMascota true si accepta mascotes.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        String material, boolean casaMascota) {
        llistaAllotjaments.add(new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota));
    }


    /**
     *  Afegeix una mobil-home a la llista d'allotjaments.
     * @param terrassaBarbacoa true si disposa de terrassa amb barbacoa.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                         boolean terrassaBarbacoa) {
        llistaAllotjaments.add(new MobilHome(nom_, idAllotjament_, mida, habitacions , placesPersones, terrassaBarbacoa));
    }


    /**
     * Afegeix una nova reserva al càmping. Per fer-ho fa el següent: cerca el soci que vol fer la reserva i el servei que es vol reservar amb la informació necessària rebuda com a paràmetres i invoca al mètode afegirReserva de la classe LlistaReserves que crearà la reserva, si es pot, i la afegirà a la llista de reserves.
     * @param id_ l'identificador de l'allotjament.
     * @param dni_ el DNI del client que fa la reserva.
     * @param dataEntrada la data d'entrada.
     * @param dataSortida la data de sortida.
     * @throws ExcepcioReserva si no es pot realitzar la reserva.
     */
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

        // cerca el soci que vol fer la reserva
        Client client = new Client();

        Iterator<Client> itClient = this.llistaClients.iterator();
        boolean encontratClient = false;
        while (itClient.hasNext() && !encontratClient) {
            Client c = itClient.next();
            if (c.getDni().equals(dni_)) {
                encontratClient = true;
                client = c;
            }
        }
        if (!encontratClient) throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");


        // cerca l'allotjament correspondent
        Allotjament allotjament = new Parcela("Default allotjament", " ", -1f, false);

        Iterator<Allotjament> itAllot = this.llistaAllotjaments.iterator();
        boolean encontratAllotjament = false;
        while(itAllot.hasNext() && !encontratAllotjament) {
            Allotjament a = itAllot.next();
            if (a.getId().equals(id_)) {
                encontratAllotjament = true;
                allotjament = a;
            }
        }
        if (!encontratAllotjament) throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix");


        // intentar d'afegir la reserva
        try {
            this.llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
        } catch (ExcepcioReserva e) {
            System.err.println(e.getMessage());
        }

    }


    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius.
     * @return el nombre de serveis operatius.
     */
    public int calculAllotjamentsOperatius() {
        int count = 0;
        Iterator<Allotjament> it = this.llistaAllotjaments.iterator();
        while (it.hasNext()) {
            if (it.next().correcteFuncionament()) {
                count++;
            }
        }

        return count;
    }


    /**
     * Cerca i retorna l'allotjament amb estada mínima de la temporada alta més curta.
     * @return l'allotjament amb estada mínima de la temporada baixa més curta.
     */
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) throws ExcepcioReserva {
        if (this.llistaAllotjaments.isEmpty()) throw new ExcepcioReserva("La llistaAllotjament es vacia");

        Allotjament allotjamentMesCurt = this.llistaAllotjaments.get(0);
        long estadaMesCurt = (temp == InAllotjament.Temp.ALTA)? allotjamentMesCurt.estadaMinimaAlta : allotjamentMesCurt.estadaMinimaBaixa;

        Iterator<Allotjament> it = this.llistaAllotjaments.iterator();
        while(it.hasNext()) {
            Allotjament nextAllotjament = it.next();
            long nextEstada = (temp == InAllotjament.Temp.ALTA)? nextAllotjament.estadaMinimaAlta : nextAllotjament.estadaMinimaBaixa;
            if (nextEstada < estadaMesCurt) {
                estadaMesCurt = nextEstada;
                allotjamentMesCurt = nextAllotjament;
            }
        }

        return allotjamentMesCurt;
    }


    public static InAllotjament.Temp getTemporada(LocalDate data) {
        // temporada ALTA: 21/3/XXXX - 20/9/XXXX
        int anyEntrada = data.getYear();
        boolean estarALTA = data.isAfter(LocalDate.of(anyEntrada, 3, 20))
                && data.isBefore(LocalDate.of(anyEntrada, 9,21));

        return (estarALTA)? InAllotjament.Temp.ALTA : InAllotjament.Temp.BAIXA;
    }
}
