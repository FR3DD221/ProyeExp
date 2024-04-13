/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc202_1c2024_j_g4;
import javax.swing.JOptionPane;

public class Modificar_Citas {

    public static void modificarCita() {

        String nombrePaciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
        String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico:");
        String diaCita = JOptionPane.showInputDialog("Ingrese el día de la cita a cancelar:");

        cancelarCitaAgendada(nombrePaciente, nombreMedico, diaCita, Registro_Medicos.getMedicosMedicinaGeneral());
        cancelarCitaAgendada(nombrePaciente, nombreMedico, diaCita, Registro_Medicos.getMedicosCirugiaAmbulatoria());
        cancelarCitaAgendada(nombrePaciente, nombreMedico, diaCita, Registro_Medicos.getMedicosCirugiaEspecializada());

        JOptionPane.showMessageDialog(null, "La cita ha sido cancelada exitosamente.");
    }

    private static void cancelarCitaAgendada(String nombrePaciente, String nombreMedico, String diaCita, Medico[] medicos) {
        for (Medico medico : medicos) {
            if (medico != null && medico.getNombre().equals(nombreMedico)) {
                Cita[] agenda = medico.getAgenda();
                String diaSemana = obtenerDiaSemana(diaCita);
                int indiceDia = obtenerIndiceDia(diaSemana);

                if (agenda[indiceDia] != null && agenda[indiceDia].getNombrePaciente().equals(nombrePaciente)) {
                    agenda[indiceDia] = null;
                    break;
                }
            }
        }
    }

    private static String obtenerDiaSemana(String diaCita) {
        return diaCita;
    }

    private static int obtenerIndiceDia(String diaSemana) {
        switch (diaSemana.toLowerCase()) {
            case "lunes":
                return 0;
            case "martes":
                return 1;
            case "miércoles":
                return 2;
            case "jueves":
                return 3;
            case "viernes":
                return 4;
            case "sábado":
                return 5;
            case "domingo":
                return 6;
            default:
                return -1;
        }
    }
}


