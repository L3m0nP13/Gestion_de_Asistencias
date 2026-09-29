package gestionasistencia.Modelos;

public class ResultadoAutenticacion {

    private final boolean exitoso;
    private final String mensaje;
    private final Usuario usuario;

    private ResultadoAutenticacion(boolean exitoso, String mensaje,
            Usuario usuario) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public static ResultadoAutenticacion exito(Usuario usuario) {
        return new ResultadoAutenticacion(true, null, usuario);
    }

    public static ResultadoAutenticacion error(String mensaje) {
        return new ResultadoAutenticacion(false, mensaje, null);
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
