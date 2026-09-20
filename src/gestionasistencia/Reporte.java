
package gestionasistencia;

import java.util.List;

public class Reporte {
    private String info_reporte;
    private List<Asistencia> asistencias;

    public Reporte(String info_reporte, List<Asistencia> asistencias)
    {
        this.info_reporte = info_reporte;
        this.asistencias = asistencias;
    }

    public void generarReporte() {
        System.out.println("Reporte: " + info_reporte);
        
        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia);
        }
    }
}
