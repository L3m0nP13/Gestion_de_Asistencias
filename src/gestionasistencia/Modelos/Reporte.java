package gestionasistencia.Modelos;

import java.util.List;

public class Reporte {

    private String info_reporte;
    private List<Asistencia> asistencias;
    private List<Usuario> usuarios;

    public Reporte(String info_reporte, List<Asistencia> asistencias, List<Usuario> usuarios) {
        this.info_reporte = info_reporte;
        this.asistencias = asistencias;
        this.usuarios = usuarios;
    }

    public void reporteAtrasos() {
        System.out.println("=== REPORTE DE ATRASOS ===");

        for (Asistencia asistencia : asistencias) {
            if (asistencia.entradaAtrasada()) {
                System.out.println(
                    "Usuario: " + asistencia.getUsuario()
                    + " | Fecha: " + asistencia.getFecha()
                    + " | Hora: " + asistencia.getHora()
                );
            }
        }
    }

    public void reporteSalidasAnticipadas() {
        System.out.println("=== REPORTE DE SALIDAS ANTICIPADAS ===");

        for (Asistencia asistencia : asistencias) {
            if (asistencia.salidaAnticipada()) {
                System.out.println(
                    "Usuario: " + asistencia.getUsuario()
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
                if (asistencia.getUsuario() == usuario) {
                    asistio = true;
                    break;
                }
            }

            if (!asistio) {
                System.out.println("Usuario: " + usuario + " | No asistió");
            }
        }
    }

    public void generarReporte() {
        System.out.println("Reporte: " + info_reporte);

        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia);
        }
    }
}