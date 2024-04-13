package com.mycompany.proyeexp;
import java.time.LocalDate;
import java.time.LocalTime;


public class Medico {

    private String nombre;
    private String especialidad;
    private LocalTime horaAlmuerzo;
    private Agenda horario;

    public Medico(String nombre, String especialidad, int Hora, int Minutos, int Segundos) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        LocalTime horaAlmuerzoTemp = LocalTime.of(Hora, Minutos, Segundos);
        this.horaAlmuerzo = horaAlmuerzoTemp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalTime getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(LocalTime horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }

    public Agenda getHorario() {
        return horario;
    }

    public void setHorario(Agenda horario) {
        this.horario = horario;
    }
    
}
