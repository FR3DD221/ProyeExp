

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
    private static  int indiceCitas = 0;

    
    
    public static void main(String[] args) {
        
        while (true) {
            String opcion = JOptionPane.showInputDialog("MENU PRINCIPAL\n"
                    + "1. Registro de médicos.\n"
                    + "2. Agendar cita \n"
                    + "3. Eliminar cita \n"
                    + "4. Mostrar agenda\n"
                    + "5. Salir \n"
                    + "Ingrese el número de la opción deseada: ");

            switch (opcion) {
                case "1":
                    //Registro_Medicos.nuevo_Registro_Medicos();
                    if(indiceMed == 5){
                        JOptionPane.showMessageDialog(null, "Ya se almaceno la cantidad de 5 medicos.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    Boolean flagD = true;
                    String esp = "";
                    do{
                        String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico\n");
                        if(nombreMedico.isBlank()|| nombreMedico.isEmpty()){
                            JOptionPane.showMessageDialog(null, "No se permite agregar un medico sin nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                        }else{
                            esp = nombreMedico;
                            flagD = false;
                        }
                    }while(flagD);
                    String esp2 = "";
                    Boolean flag = true;
                    do{
                        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del doctor\n");
                        especialidad = especialidad.toUpperCase();
                        if(especialidad.equals("MEDICINA GENERAL")||especialidad.equals("CIRUGIA AMBULATORIA")||especialidad.equals("CIRUGIA ESPECIALIZADA")){
                            flag = false;
                            esp2 = especialidad;
                        }else{
                            JOptionPane.showMessageDialog(null, "La especialdad no es valida.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }while(flag);
                    int esp3= 0;
                    Boolean flagH = true;
                    do{
                        String horaAlmuerzo = JOptionPane.showInputDialog("Ingrese la hora de almuerzo FORMATO 24H\n");
                        try {
                            int hora = Integer.parseInt(horaAlmuerzo);
                            if(hora>=8 && hora<=18){
                                esp3 = hora;
                                flagH = false;
                            }else{
                                JOptionPane.showMessageDialog(null, "La hora debe estar dentro del rango 8 am - 18 pm.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "La hora debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }while(flagH);
                    medicos[indiceMed] = new Medico(esp,esp2, esp3);
                    Agenda temp = medicos[indiceMed].getHorario();
                    temp.añadirHoraAlm(esp3);
                    medicos[indiceMed].setHorario(temp);
                    indiceMed+=1;
                    break;
                    
                    
                case "2":
                    
                    if(indiceMed > 0){
                        String esp4 = "";
                        Boolean case2 = true;
                        do{
                            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente\n");
                            if(nombreCliente.isBlank()|| nombreCliente.isEmpty()){
                                JOptionPane.showMessageDialog(null, "No se permite agregar un cliente sin nombre.", "Error", JOptionPane.ERROR_MESSAGE);

                            }else{
                                case2 = false;
                                esp4 = nombreCliente;
                            }
                        }while(case2);

                        Boolean case2_1 = true;
                        String esp5 = "";
                        do{
                            String telefono = JOptionPane.showInputDialog("Ingrese el telefono del cliente SIN GUIONES\n");
                            if(telefono.isBlank()|| telefono.isEmpty()|| telefono.length() < 8){
                                JOptionPane.showMessageDialog(null, "Telefono INVALIDO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                case2_1 = false;
                                esp5 = telefono;
                            }
                        }while(case2_1);

                        int esp6= 0;
                        Boolean flagMes = true;
                        do{
                            String mes = JOptionPane.showInputDialog("Ingrese el mes de la cita\n");
                            try {
                                int mes1 = Integer.parseInt(mes);
                                if(mes1>=1 && mes1<=12){
                                    esp6 = mes1;
                                    flagMes = false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "El mes debe ser valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                }


                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El mes debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }




                        }while(flagMes);

                        int esp7= 0;
                        Boolean flagDia = true;
                        do{
                            String dia = JOptionPane.showInputDialog("Ingrese el dia de la cita\n");
                            try {
                                int dia1 = Integer.parseInt(dia);
                                if(dia1>=1 && dia1<=30){
                                    esp7 = dia1;
                                    flagDia = false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "El dia debe ser valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El Dia debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(flagDia);       

                        int esp8= 0;
                        Boolean flagHora = true;
                        do{
                             String hora = JOptionPane.showInputDialog("Ingrese el hora de la cita\n");
                            try {
                                int hora1 = Integer.parseInt(hora);
                                if(hora1>=8 && hora1<=18){
                                    esp8 = hora1;
                                    flagHora = false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "La hora debe estar dentro del rango 8 am - 18 pm.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "La hora debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(flagHora); 


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
                        Medico dato = buscarMedicoDis(esp4.toUpperCase(),esp5,esp1,esp6,esp7,esp8);
                        if(dato== null){

                            JOptionPane.showMessageDialog(null, "Error, no hay medicos disponibles a esa hora y dia.", "ERROR", JOptionPane.INFORMATION_MESSAGE);

                        }else{
                            int horaDinero = 0;
                            if(esp1.equals("MEDICINA GENERAL")){
                                horaDinero = 1;
                            }else if(esp1.equals("CIRUGIA AMBULATORIA")){
                                horaDinero = 2;
                            }else if(esp1.equals("CIRUGIA ESPECIALIZADA")){
                                horaDinero = 3;
                            }
                            JOptionPane.showMessageDialog(null, "El valor de la cita sera de: "+ dato.getHorario().calcularCosto1(esp6, esp7, horaDinero), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Se agendo correctamente la cita.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                    
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe registrar un medico primero.", "Error", JOptionPane.ERROR_MESSAGE);

                        
                    }
                    
                    
                    
                    break;
                    
                    
                    
                case "3":
                    if(indiceMed > 0){
                        Boolean case3 = true;
                        String case3_NombreCliente = "";
                        do{
                            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente con cita a eliminar\n");
                            if(nombreCliente.isBlank()||nombreCliente.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                case3_NombreCliente = nombreCliente.toUpperCase();
                                case3 = false;
                            }
                        }while(case3);


                        String[] opciones = new String[indiceMed];
                        for(int i = 0; i <= indiceMed-1; i++){   
                            opciones[i] = medicos[i].getNombre();
                        }
                        String doctorSelected = (String) JOptionPane.showInputDialog(
                                                        null, 
                                                        "Seleccione el Doctor que lo iba a atender:",
                                                        "",
                                                        JOptionPane.QUESTION_MESSAGE, 
                                                        null, 
                                                        opciones, 
                                                        opciones[0]);


                        int case3_mes= 0;
                        Boolean flag3_mes = true;
                        do{
                            String mes = JOptionPane.showInputDialog("Ingrese el mes de la cita\n");
                            try {
                                int mes1 = Integer.parseInt(mes);
                                if(mes1>=1 && mes1<=12){
                                    case3_mes = mes1;
                                    flag3_mes = false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Debe ser un mes valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El mes debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(flag3_mes); 




                        int case3_dia= 0;
                        Boolean flag3_dia = true;
                        do{
                            String dia = JOptionPane.showInputDialog("Ingrese el dia de la cita\n");
                            try {
                                int dia1 = Integer.parseInt(dia);
                                if(dia1>=1 && dia1<=30){
                                    case3_dia = dia1;
                                    flag3_dia = false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Debe ser un dia valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El Dia debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(flag3_dia); 

                        LocalDate diaCita = LocalDate.of(2024, case3_mes, case3_dia);
                        System.out.println(diaCita);
                        Boolean flagCita = true;
                        for(int i =0; i< indiceCitas; i++){

                            if(agendas[i].getNombrePaciente().equals(case3_NombreCliente)){
                                if( agendas[i].getMedicoAsig().getNombre().equals(doctorSelected)){
                                    if(agendas[i].getFecha().equals(diaCita)){

                                        agendas[i].getMedicoAsig().getHorario().eliminarCita(case3_NombreCliente, doctorSelected, diaCita);
                                        agendas[i] = null;
                                        JOptionPane.showMessageDialog(null, "Se elimino la cita CORRECTAMENTE.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                                        flagCita = true;
                                        break;


                                    }else{
                                        i++;
                                    }

                                }else{
                                    i++;
                                }

                            }else{
                                i++;
                            }
                            flagCita = false;

                        }
                        if(flag = false){
                            JOptionPane.showMessageDialog(null, "Ese cliente no tiene citas asignadas.", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No hay medicos registrados aún.", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                    
                    break;
                    
                    
                case "4":
                    
                    if(indiceMed > 0){
                        String[] opciones4 = new String[indiceMed];
                        for(int i = 0; i <= indiceMed-1; i++){   
                            opciones4[i] = medicos[i].getNombre();
                        }
                        String doctorSelected4 = (String) JOptionPane.showInputDialog(
                                                        null, 
                                                        "Seleccione el Doctor que lo iba a atender:",
                                                        "",
                                                        JOptionPane.QUESTION_MESSAGE, 
                                                        null, 
                                                        opciones4, 
                                                        opciones4[0]);



                        int case4_mes= 0;
                        Boolean flag4_mes = true;
                        do{
                            String mes = JOptionPane.showInputDialog("Ingrese el mes a revisar\n");
                            try {
                                int mes1 = Integer.parseInt(mes);
                                if(mes1>=1 && mes1<=12){
                                    case4_mes = mes1;
                                    flag4_mes = false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Debe ser un mes valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El mes debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(flag4_mes); 


                        int case4_dia= 0;
                        Boolean flag4_dia = true;
                        do{
                            String dia = JOptionPane.showInputDialog("Ingrese el dia de la cita\n");
                            try {
                                int dia1 = Integer.parseInt(dia);
                                if(dia1>=1 && dia1<=30){
                                    case4_dia = dia1;
                                    flag4_dia = false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Debe ser un dia valido.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El Dia debe ser un valor numerico ENTERO.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(flag4_dia); 


                        String info = "";
                        for(int i = 0; i <= indiceMed-1; i++){   

                            if(doctorSelected4.equals(medicos[i].getNombre())){

                                info = medicos[i].getHorario().imprimiDatos(case4_mes-1, case4_dia-1);
                                JOptionPane.showMessageDialog(null, "La agenda del doctor: "+ medicos[i].getNombre()+ " es : " + "\n"+ info, "Aviso", JOptionPane.INFORMATION_MESSAGE);
                                int horaDinero = 0;
                                if(medicos[i].getEspecialidad().equals("MEDICINA GENERAL")){
                                    horaDinero = 1;
                                }else if(medicos[i].getEspecialidad().equals("CIRUGIA AMBULATORIA")){
                                    horaDinero = 2;
                                }else if(medicos[i].getEspecialidad().equals("CIRUGIA ESPECIALIZADA")){
                                    horaDinero = 3;
                                }
                                JOptionPane.showMessageDialog(null, "El monto a recaudar ese dia sera de: "+ medicos[i].getHorario().calcularCosto(case4_mes, case4_dia, horaDinero), "Aviso", JOptionPane.INFORMATION_MESSAGE);


                            }
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe registrar un medico primero", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                    }
                    
                   
                    
                    
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
                int puede = medicos[i].getHorario().verificarEspacio(dia, mes, hora, horasEsp);
                
                if (puede != 0) {
                    Cita temp = new Cita(nombreCliente, numeroTelefono, hora, 0, 0, medicos[i], LocalDate.of(2024, mes, dia));
                    if (medicos[i].getHorario().agregarCita(temp) == 2) {
                        medicos[i].getHorario().agregarCita(temp);
                        agendas[indiceCitas] = temp;
                        indiceCitas++;
                        return medicos[i];
                        
                    }
                }
            }
        }
        return null;
    }
    

}
