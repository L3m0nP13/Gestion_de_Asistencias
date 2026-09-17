package gestionasistencia;
import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia {

    private int id;
    private Usuario usuario;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipo;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    public Asistencia(Usuario usuario){
        this.usuario = usuario;
    }

    public Asistencia(int id, LocalDate fecha, LocalTime hora,
            String tipo, Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getTipo() {
        return tipo;
    }

    //METODOS INDEPENDIENTES
    public void registrarEntrada() {
        //hace el cambio dentro de un objeto asistencia creado
        fecha = LocalDate.now();
        horaEntrada = LocalTime.now();
        hora = horaEntrada;
        tipo = "ENTRADA";
    }

    public void registrarSalida() {
        //hace el cambio dentro de un objeto asistencia creado
        fecha = LocalDate.now();
        horaSalida = LocalTime.now();
        hora = horaSalida;
        tipo = "SALIDA";
    }

    public boolean entradaAtrasada() {
        LocalTime limite = LocalTime.of(9, 30);
        LocalTime entrada = horaEntrada;

        if (entrada == null && "ENTRADA".equals(tipo)) {
            entrada = hora;
        }

        return entrada != null && entrada.isAfter(limite);
    }

    public boolean salidaAnticipada() {
        LocalTime limite = LocalTime.of(17, 30);
        LocalTime salida = horaSalida;

        if (salida == null && "SALIDA".equals(tipo)) {
            salida = hora;
        }

        return salida != null && salida.isBefore(limite);
    }
    
 
}
