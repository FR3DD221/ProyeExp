/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc202_1c2024_j_g4;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class Mostrar_Agenda {
    //Creamos método para mostrar la agenda
    // Creamos método para mostrar la agenda
    public static void mostrarAgenda() {
        // Solicitar información del médico e información de la cita
        String medico = JOptionPane.showInputDialog("Ingrese el nombre del médico");
        String diaReserva = JOptionPane.showInputDialog("Ingrese el día de la cita agendada");
        String nombrePaciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente que agendó la cita");
    }

    public Mostrar_Agenda() {
    } // constructor sin parámetros

    public Mostrar_Agenda(String medico, String diaReserva, String nombrePaciente) { // constructor con parámetros
    }
}