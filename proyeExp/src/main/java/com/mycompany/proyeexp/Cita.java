
package com.mycompany.proyeexp;
import java.time.LocalDate;
import java.time.LocalTime;


public class Cita {
    private String nombrePaciente;
    private String telefonoPaciente;
    private LocalTime horaCita;
    private Medico MedicoAsig;
    private LocalDate fecha;
    
    public Cita (String nombrePaciente, String telefonoPaciente, int Hora, int Minutos, int Segundos, Medico MedicoTemp, LocalDate fechaCitap) {
        this.nombrePaciente = nombrePaciente;
        this.telefonoPaciente = telefonoPaciente;
        LocalTime horaCitaTemp = LocalTime.of(Hora, Minutos, Segundos);
        this.horaCita = horaCitaTemp;
        this.MedicoAsig = MedicoTemp;
        this.fecha = fechaCitap;
    }   
    
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    public Medico getMedicoAsig() {
        return MedicoAsig;
    }

    public void setMedicoAsig(Medico MedicoAsig) {
        this.MedicoAsig = MedicoAsig;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
