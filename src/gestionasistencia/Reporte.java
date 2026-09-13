
package gestionasistencia;

import java.util.List;

public class Reporte {
    private String info_reporte;
    private List<Asistencia> asistencias; //MUESTRA LA LISTA DE ASISTENCIA Y 

    public Reporte(String info_reporte, List<Asistencia> asistencias)
    {
        this.info_reporte = info_reporte;
        this.asistencias = asistencias; //AQUI ESTA LA INFO DE ASISTENCIAS;
    }

    public void generarReporte() {
        System.out.println("Reporte: " + info_reporte);
        
        //SE MUESTRAN TODOS LOS 
        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia);
        }
    }
}