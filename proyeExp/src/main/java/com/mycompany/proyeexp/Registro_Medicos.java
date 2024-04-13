
import com.mycompany.sc202_1c2024_j_g4.Medico;
import javax.swing.JOptionPane;

public class Registro_Medicos {

    private static final int MAX_MEDICOS = 2;
    private static Medico[][] medicos = {
        new Medico[MAX_MEDICOS], // Medicos de Medicina General
        new Medico[MAX_MEDICOS], // Medicos de Cirugía Ambulatoria
        new Medico[MAX_MEDICOS] // Medicos de Cirugía Especializada
    };
    private static int[] contadorMedicos = new int[3]; // Un contador para cada especialidad

    public static void nuevo_Registro_Medicos() {
       
        String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico:");
        String especialidad = seleccionarEspecialidad();
        String horaAlmuerzo = JOptionPane.showInputDialog("Ingrese la hora de almuerzo del médico:");

        Medico medico = new Medico(nombreMedico, especialidad, horaAlmuerzo);

        switch (especialidad) {
            case "Medicina General":
                agregarMedico(medico, 0);
                break;
            case "Cirugía Ambulatoria":
                agregarMedico(medico, 1);
                break;
            case "Cirugía Especializada":
                agregarMedico(medico, 2);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Especialidad inválida");
        }
    }

    private static void agregarMedico(Medico medico, int indiceEspecialidad) {
        if (contadorMedicos[indiceEspecialidad] < MAX_MEDICOS) {
            medicos[indiceEspecialidad][contadorMedicos[indiceEspecialidad]++] = medico;
            JOptionPane.showMessageDialog(null, "Médico registrado:\n" + medico.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más médicos de esta especialidad.");
        }
    }

    private static String seleccionarEspecialidad() {
        String[] especialidades = {"Medicina General", "Cirugía Ambulatoria", "Cirugía Especializada"};
        return (String) JOptionPane.showInputDialog(null, "Seleccione la especialidad del médico:",
                "Especialidad", JOptionPane.QUESTION_MESSAGE, null, especialidades, especialidades[0]);
    }

    public static Medico[][] getMedicos() {
        return medicos;
    }

    public static int[] getContadorMedicos() {
        return contadorMedicos;
    }
}
