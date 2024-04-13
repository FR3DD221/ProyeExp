package com.mycompany.sc202_1c2024_j_g4;

import javax.swing.JOptionPane;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Agendar_Citas {

    private static final int MAX_CITAS = 100;
    private static Cita[] citas = new Cita[MAX_CITAS];
    private static int contadorCitas = 0;

    public static void agregarNuevaCita() {
        int anoCita = ingresarAno();
        int mesCita = ingresarMes();
        int diaCita = ingresarDia();

        LocalDate fechaCita = LocalDate.of(anoCita, mesCita, diaCita);

        Medico medicoDisponible = seleccionarMedicoDisponible(fechaCita);

        String nombrePaciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
        String telefonoPaciente = JOptionPane.showInputDialog("Ingrese el teléfono del paciente:");

        String[] servicios = {"Medicina General", "Cirugía Ambulatoria", "Cirugía Especializada"};
        String servicioSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el servicio a utilizar:",
                "Servicio", JOptionPane.QUESTION_MESSAGE, null, servicios, servicios[0]);

        if (medicoDisponible == null) {
            JOptionPane.showMessageDialog(null, "No hay médicos disponibles para la fecha seleccionada.");
        } else {
            String horaCita = JOptionPane.showInputDialog("Ingrese la hora de la cita (formato HH:mm)");

            if (medicoDisponible.duranteAlmuerzo(horaCita)) {
                JOptionPane.showMessageDialog(null, "No se puede agregar la cita porque coincide con el horario de almuerzo del médico.");
                return;
            }

            Cita nuevaCita = new Cita(nombrePaciente, telefonoPaciente, horaCita, medicoDisponible, fechaCita);

            citas[contadorCitas++] = nuevaCita;

            double precioHora = calcularPrecioHora(servicioSeleccionado);
            double costoTotal = precioHora * nuevaCita.getDuracion();

            JOptionPane.showMessageDialog(null, "Información de la cita:\n"
                    + "Nombre del paciente: " + nombrePaciente + "\n"
                    + "Teléfono del paciente: " + telefonoPaciente + "\n"
                    + "Fecha y hora de la cita: " + nuevaCita.getFechaHora() + "\n"
                    + "Servicio: " + servicioSeleccionado + "\n"
                    + "Médico asignado: " + medicoDisponible.getNombre() + "\n"
                    + "Duración del servicio: " + nuevaCita.getDuracion() + " hora(s)\n"
                    + "Costo total de la cita: " + costoTotal + " colones");
        }
    }

    private static int ingresarAno() {
        int ano;
        do {
            String anoString = JOptionPane.showInputDialog("Ingrese el año de la cita:");
            ano = Integer.parseInt(anoString);
        } while (ano < LocalDate.now().getYear());
        return ano;
    }

    private static int ingresarMes() {
        int mes;
        do {
            String mesString = JOptionPane.showInputDialog("Ingrese el mes de la cita (1 - 12):");
            mes = Integer.parseInt(mesString);
        } while (mes < 1 || mes > 12);
        return mes;
    }

    private static int ingresarDia() {
        int dia;
        do {
            String diaString = JOptionPane.showInputDialog("Ingrese el día de la cita (1 - 30):");
            dia = Integer.parseInt(diaString);
        } while (dia < 1 || dia > 30);
        return dia;
    }

    private static Medico seleccionarMedicoDisponible(LocalDate fechaCita) {
        String[] especialidades = {"Medicina General", "Cirugía Ambulatoria", "Cirugía Especializada"};
        String especialidadSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la especialidad del médico:",
                "Especialidad", JOptionPane.QUESTION_MESSAGE, null, especialidades, especialidades[0]);

        Medico[][] medicos = Registro_Medicos.getMedicos();
        int[] contadorMedicos = Registro_Medicos.getContadorMedicos();
        int indiceEspecialidad = -1;

        switch (especialidadSeleccionada) {
            case "Medicina General":
                indiceEspecialidad = 0;
                break;
            case "Cirugía Ambulatoria":
                indiceEspecialidad = 1;
                break;
            case "Cirugía Especializada":
                indiceEspecialidad = 2;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Especialidad inválida");
        }

        if (indiceEspecialidad != -1) {
            for (Medico medico : medicos[indiceEspecialidad]) {
                if (medico != null && medico.estaDisponible(fechaCita)) {
                    return medico;
                }
            }
        }

        return null;
    }

    private static double calcularPrecioHora(String servicio) {
        switch (servicio) {
            case "Medicina General":
                return 25000; // Precio por hora para Medicina General
            case "Cirugía Ambulatoria":
                return 30000; // Precio por hora para Cirugía Ambulatoria
            case "Cirugía Especializada":
                return 35000; // Precio por hora para Cirugía Especializada
            default:
                return 0;
        }
    }

    public static Cita[] getCitas() {
        return citas;
    }
}
