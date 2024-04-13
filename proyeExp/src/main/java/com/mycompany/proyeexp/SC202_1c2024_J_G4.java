/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sc202_1c2024_j_g4;

import javax.swing.JOptionPane;

/**
 *
 * @author pcv
 */
public class SC202_1c2024_J_G4 {

    private static final int NUMERO_MESES = 12;
    private static final int NUMERO_DIAS = 30;
    private static Cita[][][] agenda = new Cita[NUMERO_MESES][NUMERO_DIAS][];
    private static final int MAX_MEDICOS = 3;
    private static final int MAX_HORAS_MEDICO = 10;
    private static Medico[][] medicos = new Medico[MAX_MEDICOS][NUMERO_MESES * NUMERO_DIAS * MAX_HORAS_MEDICO];

    public static void main(String[] args) {

        // Inicialización del sistema
        for (int mes = 0; mes < NUMERO_MESES; mes++) {
            for (int dia = 0; dia < NUMERO_DIAS; dia++) {
                agenda[mes][dia] = new Cita[MAX_HORAS_MEDICO];
            }
        }

        boolean continuarProg = true;

        while (continuarProg) {
            String opcion = JOptionPane.showInputDialog("MENU PRINCIPAL\n"
                    + "1. Registro de médicos.\n"
                    + "2. Agendar cita \n"
                    + "3. Modificar cita \n"
                    + "4. Mostrar agenda\n"
                    + "5. Salir \n"
                    + "6. TEMPORAL: Imprimir Dias y horas disponibles"
                    + "Ingrese el número de la opción deseada: ");

            switch (opcion) {
                case "1":
                    Registro_Medicos.nuevo_Registro_Medicos();
                    break;
                case "2":
                    Agendar_Citas.agregarNuevaCita();
                    break;
                case "3":
                    /*buscar y eliminar citas --> dejar espacio vació*/
                    break;
                case "4":
                    /*mostrar info diaria de citas de cada médico y ganancias diarias*/
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    continuarProg = false;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número del 1 al 5.");
            }

        }
    }
}
