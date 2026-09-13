
package gestionasistencia;

import java.util.ArrayList;
import java.util.List;

public class ControladorAsistencia {
    private List<Usuario> usuarios;
    private List<Asistencia> asistencias;
    
  public class SistemaAsistencia {

    private List<Usuario> usuarios;
    private List<Asistencia> asistencias;

    public SistemaAsistencia() {
        usuarios = new ArrayList<>();
        asistencias = new ArrayList<>();
    }

    public void crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public void modificarUsuario(Usuario usuario) {
        // Implementación de modificación
    }

    public void registrarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }
    
     
    
    }
}
