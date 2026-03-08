package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class LlistaReserves implements  InLlistaReserves {
    private ArrayList<Reserva> llista;


    // Constructor
    public LlistaReserves() {
        this.llista = new ArrayList<Reserva>();
    }


    // getters and setters
    public ArrayList<Reserva> getLlista() { return this.llista; }
    public void setLlista(ArrayList<Reserva> llista_) { this.llista = llista_; }


    // other methods
    // ------------------------------
    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida)
            throws ExcepcioReserva {
        // Comprova que l'estada que es demani sigui més llarga o igual que l'estada mínima.
        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        InAllotjament.Temp temporada = reserva.calcularTemporada();

        if (reserva.calcularDiesEstada() < allotjament.getEstadaMinima(temporada)) {
            throw new ExcepcioReserva(
                    "L’allotjament amb identificador " + allotjament.getId()
                    + " no està disponible en la data demanada " + dataEntrada
                    + " pel client " + client.getNom() + " amb DNI: " + client.getDni()
            );
        }

        // Comprova que l'allotjament estigui disponible pels dies indicats.
        if (!allotjament.correcteFuncionament()) {
            throw new ExcepcioReserva(
                    "Les dates sol·licitades pel client " + client.getNom()
                    + " amb DNI: " + client.getDni()
                    + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId()
            );
        }

        // Tot comprovat, afegir-la a la llista
        llista.add(reserva);
    }


    @Override
    public int getNumReserves() { return this.llista.size(); }
}
