package gestionasistencia;
import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia {
    private int id;
    private Usuario usuario;
    private LocalDate fecha;
    private LocalTime horaEntrada ;
    private LocalTime horaSalida;
    
    public Asistencia(int id, Usuario usuario, LocalDate fecha){
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
    }
  
    //METODOS INDEPENDIENTES
    public void registrarEntrada() {
        horaEntrada = LocalTime.now();
    }

    public void registrarSalida() {
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
