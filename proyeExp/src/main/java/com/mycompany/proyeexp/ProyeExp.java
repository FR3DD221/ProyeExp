

package com.mycompany.proyeexp;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author fredd
 */
public class ProyeExp {

    private static final int MAX_HORAS_DISP = 10;
    private static Medico[] medicos = new Medico[5];
    private static Cita[] agendas = new Cita[365];
    private static final int NUMERO_MESES = 12;
    private static final int NUMERO_DIAS = 30;
    private static Cita[][][] agenda = new Cita[NUMERO_MESES][NUMERO_DIAS][];
    private static final int MAX_MEDICOS = 5;
    private static final int MAX_HORAS_MEDICO = 10;
    private static  int indiceMed = 0;
    
    
    public static void main(String[] args) {
        
        while (true) {
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
                    if(indiceMed == 5){
        
                        JOptionPane.showMessageDialog(null, "Ya se almaceno la cantidad de 5 medicos.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico\n");
                    String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del medico\n");
                    String horaAlmuerzo = JOptionPane.showInputDialog("Ingrese la hora de almuerzo\n");
                    
       
                    medicos[indiceMed] = new Medico(nombreMedico,especialidad, horaAlmuerzo);
                    indiceMed+=1;
                    

                    break;
                case "2":
                    //Agendar_Citas.agregarNuevaCita();
                    
                    String[] opciones = new String[indiceMed];
                    
                    for(int i = 0; i <= indiceMed-1; i++){   
//                        System.out.println(medicos[i].getNombre());
                        opciones[i] = medicos[i].getNombre();
                        
                    }
                    
                    
                    String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                                                    null, 
                                                    "Seleccione un Doctor:",
                                                    "",
                                                    JOptionPane.QUESTION_MESSAGE, 
                                                    null, 
                                                    opciones, 
                                                    opciones[0]);
                    
//                    for(int i = 0; i <= indiceMed; i++){
//                        
//                        JOptionPane.showMessageDialog(null, "El Doctor es: " + medicos[i].getNombre()+","+ medicos[i].getEspecialidad() +","+ medicos[i].getEspecialidad());
//                        
//                    }
                    break;
                case "3":
                    /*buscar y eliminar citas --> dejar espacio vació*/
                    break;
                case "4":
                    /*mostrar info diaria de citas de cada médico y ganancias diarias*/
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número del 1 al 5.");
            }
        }
    }
    
    public static Cita[] getAgendas() {
        return agendas;
    }

}
