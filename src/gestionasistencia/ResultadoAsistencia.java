package gestionasistencia;

public class ResultadoAsistencia {

    private final boolean exitoso;
    private final String mensaje;
    private final Asistencia asistencia;

    private ResultadoAsistencia(boolean exitoso, String mensaje,
            Asistencia asistencia) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
        this.asistencia = asistencia;
    }

    public static ResultadoAsistencia exito(Asistencia asistencia) {
        return new ResultadoAsistencia(true, null, asistencia);
    }

    public static ResultadoAsistencia error(String mensaje) {
        return new ResultadoAsistencia(false, mensaje, null);
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }
}
