
package com.mycompany.proyeexp;

import static com.mycompany.proyeexp.ProyeExp.getAgendas;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author
 */
public class Agenda {
    
    private String[][][] horario = new String[12][30][10];
    private int[] arrayTemp = new int[11];
    
    public Agenda() {
        inicializarArray();
        inicializarHorario();
    }
    
    public int agregarCita(Cita nuevaCita) {
        LocalDate fechaTemp = nuevaCita.getFecha();
        LocalTime horaTemp = nuevaCita.getHoraCita();
        int mes = fechaTemp.getDayOfYear();
        int dia = fechaTemp.getDayOfMonth();
        int hora = horaTemp.getHour();
        
        int horaCita = buscarElemento(hora);
        int horasEsp = buscarEsp(nuevaCita.getMedicoAsig());
        
        if (horaCita + horasEsp > 16) {
            return 1;
        }
        
        if (verificarEspacio(dia, mes, hora, horasEsp) == 0) {
            return 0;
        }
        
        return 2;
        
    }
    
    public void inicializarHorario() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 30; i++) {
                for (int k = 0; j < 10; k++) {
                    this.horario[i][j][k] = "VACIO";
                }
            }
        }
    }
    
    public void inicializarArray() {
        int j = 0;
        for(int i = 8; i < 19; i++) {
            this.arrayTemp[j] = i;
            j++;
        }
    }
    
    public int eliminarCita(String nombreCliente, String nombreMed, LocalDate diaCita) {
        Cita nuevaCita = buscarCita(nombreCliente, nombreMed, diaCita);
        
        if(nuevaCita.equals(null)) {
            return 0;
        }
        
        LocalDate fechaTemp = nuevaCita.getFecha();
        LocalTime horaTemp = nuevaCita.getHoraCita();
        int mes = fechaTemp.getDayOfYear();
        int dia = fechaTemp.getDayOfMonth();
        int hora = horaTemp.getHour();
        
        int horaCita = buscarElemento(hora);
        int horasEsp = buscarEsp(nuevaCita.getMedicoAsig());
        desaparecerCita(mes, dia, horaCita, horasEsp);
        
        return 1;
    }
    
    public void desaparecerCita(int mes, int dia, int hora, int tiempo) {
        for(int i = hora; i < hora + tiempo; i++) {
            this.horario[mes][dia][i] = "VACIO";
        } 
    }
    
    public int verificarEspacio (int dia, int mes, int hora, int tiempo) {
        for(int i = hora; i < hora + tiempo; i++) {
            if (!(this.horario[mes][dia][i].equals("VACIO"))) {
                return 0;
            }
        }
        return 1;
    }
        
    public void insertarCita(String informacion, int mes, int dia, int hora, int tiempo) {
        for(int i = hora; i < hora + tiempo; i++) {
            this.horario[mes][dia][i] = informacion;
        } 
    }
    
    public int buscarElemento(int elemento) {
        for (int i = 0; i < this.arrayTemp.length; i++) {
            if (this.arrayTemp[i] == elemento) {
                return i; // Devuelve la posición del elemento encontrado
            }
        }
        return -1; // Si el elemento no se encuentra en el array, devuelve -1
    }
    
    public int buscarEsp(Medico med) {
        String esp = med.getEspecialidad();
        
        if (esp.equals("Medicina General")) {
            return 1;
        } else if (esp.equals("Cirugia Ambulatoria")) {
            return 2;
        } else if (esp.equals("Cirugia especializada")) {
            return 3;
        }
        
        return 0;
    }
    
    public Cita buscarCita(String nombreCliente, String nombreMed, LocalDate diaCita) {
        Cita[] agendas = getAgendas();
        
        for (int i = 0; i < 365; i++) {
            if(agendas[i] == null) {
                continue;
            }
            
            if(agendas[i].getNombrePaciente().equals(nombreCliente) && agendas[i].getMedicoAsig().getNombre().equals(nombreMed) && agendas[i].getFecha().equals(diaCita)) {
                return agendas[i];
            }
        }
        
        return null;
    }

    
}
