package gestionasistencia;
import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia {
   
    private Usuario usuario;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    
    public Asistencia(Usuario usuario){
        this.usuario = usuario;
    }
  
    //METODOS INDEPENDIENTES
    public void registrarEntrada() {
        //hace el cambio dentro de un objeto asistencia creado
        horaEntrada = LocalTime.now(); 
    }

    public void registrarSalida() {
        //hace el cambio dentro de un objeto asistencia creado
        horaSalida = LocalTime.now();
    }

    public boolean entradaAtrasada() {
        LocalTime limite = LocalTime.of(9, 30);
        return horaEntrada != null && horaEntrada.isAfter(limite);
    }

    public boolean salidaAnticipada() {
        LocalTime limite = LocalTime.of(17, 30);
        return horaSalida != null && horaSalida.isBefore(limite);
    }
    
 
}
