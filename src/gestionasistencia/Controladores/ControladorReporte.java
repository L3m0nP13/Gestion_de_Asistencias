package gestionasistencia.Controladores;

import gestionasistencia.Modelos.Asistencia;
import gestionasistencia.Modelos.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorReporte {

    private String ultimoError;

    public ArrayList<Asistencia> listarAtrasos(LocalDate fecha) {
        ArrayList<Asistencia> atrasos = new ArrayList<>();

        for (Asistencia asistencia : listarAsistencias(fecha, "ENTRADA")) {
            if (asistencia.entradaAtrasada()) {
                atrasos.add(asistencia);
            }
        }

        return atrasos;
    }

    public ArrayList<Asistencia> listarSalidasAnticipadas(LocalDate fecha) {
        ArrayList<Asistencia> salidas = new ArrayList<>();

        for (Asistencia asistencia : listarAsistencias(fecha, "SALIDA")) {
            if (asistencia.salidaAnticipada()) {
                salidas.add(asistencia);
            }
        }

        return salidas;
    }

    public ArrayList<Usuario> listarInasistencias(LocalDate fecha) {
        ArrayList<Usuario> inasistencias = new ArrayList<>();
        ultimoError = null;

        if (fecha == null) {
            ultimoError = "Debe ingresar una fecha válida.";
            return inasistencias;
        }

        String sql = "SELECT u.id_usuario, u.nombre, u.correo, u.rol "
                + "FROM Usuario u "
                + "WHERE LOWER(u.rol) = 'empleado' "
                + "AND NOT EXISTS (SELECT 1 FROM Asistencia a "
                + "WHERE a.id_usuario = u.id_usuario "
                + "AND a.fecha = ? AND a.tipo = 'ENTRADA') "
                + "ORDER BY u.nombre";

        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.conectar()) {
            if (conexion == null) {
                ultimoError = "No fue posible conectar con la base de datos.";
                return inasistencias;
            }

            try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
                sentencia.setDate(1, Date.valueOf(fecha));

                try (ResultSet resultado = sentencia.executeQuery()) {
                    while (resultado.next()) {
                        inasistencias.add(leerUsuario(resultado));
                    }
                }
            }
        } catch (SQLException e) {
            ultimoError = "No se pudo consultar el reporte de inasistencias.";
        }

        return inasistencias;
    }

    public String getUltimoError() {
        return ultimoError;
    }

    private ArrayList<Asistencia> listarAsistencias(LocalDate fecha, String tipo) {
        ArrayList<Asistencia> asistencias = new ArrayList<>();
        ultimoError = null;

        if (fecha == null) {
            ultimoError = "Debe ingresar una fecha válida.";
            return asistencias;
        }

        String sql = "SELECT a.id_asistencia, a.fecha, a.hora, a.tipo, "
                + "u.id_usuario, u.nombre, u.correo, u.rol "
                + "FROM Asistencia a "
                + "INNER JOIN Usuario u ON a.id_usuario = u.id_usuario "
                + "WHERE a.fecha = ? AND a.tipo = ? "
                + "ORDER BY a.hora";

        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.conectar()) {
            if (conexion == null) {
                ultimoError = "No fue posible conectar con la base de datos.";
                return asistencias;
            }

            try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
                sentencia.setDate(1, Date.valueOf(fecha));
                sentencia.setString(2, tipo);

                try (ResultSet resultado = sentencia.executeQuery()) {
                    while (resultado.next()) {
                        asistencias.add(leerAsistencia(resultado));
                    }
                }
            }
        } catch (SQLException e) {
            ultimoError = "No se pudo consultar el reporte de asistencia.";
        }

        return asistencias;
    }

    private Asistencia leerAsistencia(ResultSet resultado) throws SQLException {
        Usuario usuario = leerUsuario(resultado);

        return new Asistencia(
                resultado.getInt("id_asistencia"),
                resultado.getDate("fecha").toLocalDate(),
                resultado.getTime("hora").toLocalTime(),
                resultado.getString("tipo"),
                usuario
        );
    }

    private Usuario leerUsuario(ResultSet resultado) throws SQLException {
        return new Usuario(
                resultado.getInt("id_usuario"),
                resultado.getString("nombre"),
                resultado.getString("correo"),
                "",
                resultado.getString("rol")
        );
    }
}
