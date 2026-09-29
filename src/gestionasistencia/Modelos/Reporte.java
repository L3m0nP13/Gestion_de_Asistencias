package gestionasistencia.Modelos;

import java.time.LocalDate;
import java.util.List;

public class Reporte {

    private String info_reporte;
    private List<Asistencia> asistencias;
    private List<Usuario> usuarios;
    private LocalDate fechaReporte;

    public Reporte(String info_reporte, List<Asistencia> asistencias, List<Usuario> usuarios) {
        this(info_reporte, asistencias, usuarios, LocalDate.now());
    }

    public Reporte(String info_reporte, List<Asistencia> asistencias,
            List<Usuario> usuarios, LocalDate fechaReporte) {
        this.info_reporte = info_reporte;
        this.asistencias = asistencias;
        this.usuarios = usuarios;
        this.fechaReporte = fechaReporte;
    }

    public void reporteAtrasos() {
        System.out.println("=== REPORTE DE ATRASOS ===");

        for (Asistencia asistencia : asistencias) {
            if (fechaReporte.equals(asistencia.getFecha())
                    && asistencia.entradaAtrasada()) {
                System.out.println(
                    "Usuario: " + asistencia.getUsuario().getNombre()
                    + " | Fecha: " + asistencia.getFecha()
                    + " | Hora: " + asistencia.getHora()
                );
            }
        }
    }

    public void reporteSalidasAnticipadas() {
        System.out.println("=== REPORTE DE SALIDAS ANTICIPADAS ===");

        for (Asistencia asistencia : asistencias) {
            if (fechaReporte.equals(asistencia.getFecha())
                    && asistencia.salidaAnticipada()) {
                System.out.println(
                    "Usuario: " + asistencia.getUsuario().getNombre()
                    + " | Fecha: " + asistencia.getFecha()
                    + " | Hora: " + asistencia.getHora()
                );
            }
        }
    }

    public void reporteInasistencias() {
        System.out.println("=== REPORTE DE INASISTENCIAS ===");

        for (Usuario usuario : usuarios) {

            boolean asistio = false;

            for (Asistencia asistencia : asistencias) {
                if (fechaReporte.equals(asistencia.getFecha())
                        && "ENTRADA".equals(asistencia.getTipo())
                        && asistencia.getUsuario().getId() == usuario.getId()) {
                    asistio = true;
                    break;
                }
            }

            if (!asistio) {
                System.out.println("Usuario: " + usuario.getNombre()
                        + " | Fecha: " + fechaReporte + " | No asistió");
            }
        }
    }

    public void generarReporte() {
        System.out.println("Reporte: " + info_reporte);

        for (Asistencia asistencia : asistencias) {
            if (fechaReporte.equals(asistencia.getFecha())) {
                System.out.println(asistencia.getUsuario().getNombre()
                        + " | " + asistencia.getFecha()
                        + " | " + asistencia.getHora()
                        + " | " + asistencia.getTipo());
            }
        }
    }
}
