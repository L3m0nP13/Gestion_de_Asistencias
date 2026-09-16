
package gestionasistencia;

import java.time.LocalDate;
import java.util.List;

public class ControladorAsistencia {
    //BORRAR DSP PARA CUANDO USEMOS BASE DE DATOS
    protected List<Asistencia> lista_asistencia;
    
    //PARA EL SINGLETON
    public static ControladorAsistencia instancia;
    
    private ControladorAsistencia(){
    }
    
        public static ControladorAsistencia getInstancia(){
        if(instancia==null)
        {
            instancia = new ControladorAsistencia();
        }
        return instancia;
    }

    
   
    public void registrarEntrada(Usuario u){
        Asistencia asistencia = new Asistencia(u);
        asistencia.registrarEntrada();
        lista_asistencia.add(asistencia); //CAMBIAR ESO A INSERT PARA LA BBDD
    }
    
    public void registrarSalida(Usuario u){
        Asistencia asistencia = new Asistencia(u);
        asistencia.registrarSalida();
        lista_asistencia.add(asistencia); //CAMBIAR ESO A INSERT PARA LA BBDD
    }
}