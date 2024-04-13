package com.mycompany.sc202_1c2024_j_g4;

import java.time.LocalDate;

public class Medico {

    private String nombre;
    private String especialidad;
    private String horaAlmuerzo;

    public Medico(String nombre, String especialidad, String horaAlmuerzo) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horaAlmuerzo = horaAlmuerzo;
    }

    // Getters y setters
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

    public String getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(String horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }

    public boolean duranteAlmuerzo(String horaCita) {
        // Implementa la lógica para verificar si la hora de la cita coincide con el almuerzo del médico
        return horaCita.equals(horaAlmuerzo);
    }

    public boolean estaDisponible(LocalDate fechaCita) {
        // Implementa la lógica para verificar si el médico está disponible en la fecha de la cita
        // Puedes usar esta lógica para verificar la disponibilidad del médico en la fecha dada
        return true; // Por ahora devuelve siempre true
    }
}
