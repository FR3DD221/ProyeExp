

package com.mycompany.proyeexp;

import javax.swing.JOptionPane;

/**
 *
 * @author fredd
 */
public class ProyeExp {;
    private static final int MAX_MEDICOS = 5;
    private static Medico[] medicos = new Medico[MAX_MEDICOS];

    public static void main(String[] args) {

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
                    //Registro_Medicos.nuevo_Registro_Medicos();
                    break;
                case "2":
                    //Agendar_Citas.agregarNuevaCita();
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
