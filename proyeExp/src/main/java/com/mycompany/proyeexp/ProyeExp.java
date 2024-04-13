

package com.mycompany.proyeexp;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author fredd
 */
public class ProyeExp {

    private static final int MAX_HORAS_DISP = 10;
    private static Medico[] medicos = new Medico[5];
    private static Cita[] agendas = new Cita[365];
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
//                    String[] opcionesMed = {"Medicina General", "Cirugia Ambulatoria", "Cirugia especializada"};
//                    int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una Especialidad:", "Selección", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesMed, opcionesMed[0]);
                    String esp = "";
                    Boolean flag = true;
                    do{
                        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del doctor\n");
                        especialidad = especialidad.toUpperCase();
                        if(especialidad.equals("MEDICINA GENERAL")||especialidad.equals("CIRUGIA AMBULATORIA")||especialidad.equals("CIRUGIA ESPECIALIZADA")){
                            
                            flag = false;
                            esp = especialidad;
                        
                        }else{
                            JOptionPane.showMessageDialog(null, "La especialdad no es valida.", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                          

                    }while(flag);
                    
                    String horaAlmuerzo = JOptionPane.showInputDialog("Ingrese la hora de almuerzo\n");
                    
                    medicos[indiceMed] = new Medico(nombreMedico,esp, Integer.parseInt(horaAlmuerzo));
                    Agenda temp = medicos[indiceMed].getHorario();
                    temp.añadirHoraAlm(Integer.parseInt(horaAlmuerzo));
                    medicos[indiceMed].setHorario(temp);
                    //medicos[indiceMed].getHorario().imprimir();
                    indiceMed+=1;
                    

                    break;
                case "2":
                    //Agendar_Citas.agregarNuevaCita();
                    
//                    String[] opciones = new String[indiceMed];
                    
//                    for(int i = 0; i <= indiceMed-1; i++){   
//                        opciones[i] = medicos[i].getNombre();
//                        
//                    }
//                    
//                    
//                    String opcionSeleccionada = (String) JOptionPane.showInputDialog(
//                                                    null, 
//                                                    "Seleccione un Doctor:",
//                                                    "",
//                                                    JOptionPane.QUESTION_MESSAGE, 
//                                                    null, 
//                                                    opciones, 
//                                                    opciones[0]);
                    
                    String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente\n");
                    String telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente\n");
                    String mes = JOptionPane.showInputDialog("Ingrese el mes de la cita\n");
                    String dia = JOptionPane.showInputDialog("Ingrese el dia de la cita\n");
                    String hora = JOptionPane.showInputDialog("Ingrese el hora de la cita\n");
                    
                    String esp1= "";
                    Boolean flag1 = true;
                    do{
                        String especialidad = JOptionPane.showInputDialog("Ingrese el servicio que desea\n");
                        especialidad = especialidad.toUpperCase();
                        if(especialidad.equals("MEDICINA GENERAL")||especialidad.equals("CIRUGIA AMBULATORIA")||especialidad.equals("CIRUGIA ESPECIALIZADA")){
                            
                            flag1 = false;
                            esp1 = especialidad;
                        
                        }else{
                            JOptionPane.showMessageDialog(null, "La especialdad no es valida.", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                          

                    }while(flag1);
                    
                    Medico dato = buscarMedicoDis(nombreCliente,telefono,esp1,Integer.parseInt(mes),Integer.parseInt(dia),Integer.parseInt(hora));
                    if(dato== null){
                       
                        JOptionPane.showMessageDialog(null, "Error, no hay medicos disponibles a esa hora y dia.", "ERROR", JOptionPane.WARNING_MESSAGE);


                    }else{
                        JOptionPane.showMessageDialog(null, "Se agendo correctamente la cita.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    
                    

                    
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
    
    public static Medico buscarMedicoDis(String nombreCliente, String numeroTelefono, String especialidad, int mes, int dia, int hora) {
        for (int i = 0; i < indiceMed; i++) {
            if (medicos[i].getEspecialidad().equals(especialidad)) {
                int horasEsp = medicos[i].getHorario().buscarEsp(medicos[i]);
                medicos[i].getHorario().imprimir();
                int puede = medicos[i].getHorario().verificarEspacio(dia, mes, hora, horasEsp);
                System.out.println(puede);

                if (puede != 0) {
                    Cita temp = new Cita(nombreCliente, numeroTelefono, hora, 0, 0, medicos[i], LocalDate.of(2024, mes, dia));
                    if (medicos[i].getHorario().agregarCita(temp) == 2) {
                        medicos[i].getHorario().agregarCita(temp);
                        System.out.println(medicos[i].getNombre());
                        return medicos[i];
                    }
                }
            }
        }
        return null;
    }


}
