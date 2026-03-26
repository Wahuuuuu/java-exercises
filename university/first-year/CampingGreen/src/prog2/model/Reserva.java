package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva implements InReserva {
    private Client client;
    private Allotjament allotjament;
    private LocalDate dataEntrada, dataSortida;


    // Constructor
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
        if (dataSortida.isBefore(dataEntrada)) throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
    }


    // getters and setters
    // --------------------------
    public Allotjament getAllotjament_() { return this.allotjament; }

    public Client getClient() { return this.client; }

    public LocalDate getDataEntrada() { return this.dataEntrada; }

    public LocalDate getDataSortida() { return this.dataSortida; }

    public void setAllotjament_(Allotjament allotjament_) { this.allotjament = allotjament_; }

    public void setClient(Client client_) { this.client = client_; }

    public void setDataEntrada(LocalDate dataEntrada_) { this.dataEntrada = dataEntrada_; }

    public void setDataSortida(LocalDate dataSortida_) { this.dataSortida = dataSortida_; }


    // other methods
    // --------------------------
    public long calcularDiesEstada() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSortida);
    }


    /**
     * Este método returns la temporada de la dataEntrada.
     * @return InAllotjament.Temp
     */
    public InAllotjament.Temp calcularTemporada() {
        // temporada ALTA: 21/3/XXXX - 20/9/XXXX
        int anyEntrada = this.dataEntrada.getYear();
        boolean estarALTA = this.dataEntrada.isAfter(LocalDate.of(anyEntrada, 3, 20))
                         && this.dataEntrada.isBefore(LocalDate.of(anyEntrada, 9,21));

        return (estarALTA)? InAllotjament.Temp.ALTA : InAllotjament.Temp.BAIXA;
    }
}
