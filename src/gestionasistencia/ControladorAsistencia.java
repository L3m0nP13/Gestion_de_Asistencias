
package gestionasistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class ControladorAsistencia {
    private static final String ENTRADA = "ENTRADA";
    private static final String SALIDA = "SALIDA";

    public ResultadoAsistencia registrarEntrada(Usuario usuario) {
        return registrar(usuario, ENTRADA);
    }

    public ResultadoAsistencia registrarSalida(Usuario usuario) {
        return registrar(usuario, SALIDA);
    }

    public ResultadoAsistencia obtenerUltimoRegistro(Usuario usuario) {
        if (usuario == null) {
            return ResultadoAsistencia.error("No hay un usuario autenticado.");
        }

        String sql = "SELECT id_asistencia, fecha, hora, tipo "
                + "FROM Asistencia WHERE id_usuario = ? "
                + "ORDER BY fecha DESC, hora DESC, id_asistencia DESC LIMIT 1";

        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.conectar()) {
            if (conexion == null) {
                return ResultadoAsistencia.error("No fue posible conectar con la base de datos.");
            }

            try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
                sentencia.setInt(1, usuario.getId());

                try (ResultSet resultado = sentencia.executeQuery()) {
                    if (resultado.next()) {
                        return ResultadoAsistencia.exito(leerAsistencia(resultado, usuario));
                    }
                }
            }

            return ResultadoAsistencia.exito(null);

        } catch (SQLException e) {
            return ResultadoAsistencia.error("No se pudo consultar el último registro de asistencia.");
        }
    }

    private ResultadoAsistencia registrar(Usuario usuario, String tipo) {
        if (usuario == null) {
            return ResultadoAsistencia.error("No hay un usuario autenticado.");
        }

        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now().withNano(0);
        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.conectar()) {
            if (conexion == null) {
                return ResultadoAsistencia.error("No fue posible conectar con la base de datos.");
            }

            Asistencia ultimoRegistro = buscarUltimoRegistroDelDia(conexion, usuario, fecha);
            String errorValidacion = validarSecuencia(ultimoRegistro, tipo);

            if (errorValidacion != null) {
                return ResultadoAsistencia.error(errorValidacion);
            }

            String sql = "INSERT INTO Asistencia (fecha, hora, tipo, id_usuario) "
                    + "VALUES (?, ?, ?, ?)";

            try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
                sentencia.setDate(1, Date.valueOf(fecha));
                sentencia.setTime(2, Time.valueOf(hora));
                sentencia.setString(3, tipo);
                sentencia.setInt(4, usuario.getId());

                if (sentencia.executeUpdate() > 0) {
                    Asistencia asistencia = new Asistencia(0, fecha, hora, tipo, usuario);
                    return ResultadoAsistencia.exito(asistencia);
                }
            }

            return ResultadoAsistencia.error("No se pudo guardar el registro de asistencia.");

        } catch (SQLException e) {
            return ResultadoAsistencia.error("No se pudo guardar el registro de asistencia. Verifique la conexión y los datos.");
        }
    }

    private Asistencia buscarUltimoRegistroDelDia(Connection conexion,
            Usuario usuario, LocalDate fecha) throws SQLException {
        String sql = "SELECT id_asistencia, fecha, hora, tipo FROM Asistencia "
                + "WHERE id_usuario = ? AND fecha = ? "
                + "ORDER BY hora DESC, id_asistencia DESC LIMIT 1";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, usuario.getId());
            sentencia.setDate(2, Date.valueOf(fecha));

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return leerAsistencia(resultado, usuario);
                }
            }
        }

        return null;
    }

    private Asistencia leerAsistencia(ResultSet resultado, Usuario usuario)
            throws SQLException {
        return new Asistencia(
                resultado.getInt("id_asistencia"),
                resultado.getDate("fecha").toLocalDate(),
                resultado.getTime("hora").toLocalTime(),
                resultado.getString("tipo"),
                usuario
        );
    }

    private String validarSecuencia(Asistencia ultimoRegistro, String tipo) {
        if (ENTRADA.equals(tipo)) {
            if (ultimoRegistro != null && ENTRADA.equals(ultimoRegistro.getTipo())) {
                return "No puede registrar otra entrada sin registrar una salida primero.";
            }

            return null;
        }

        if (ultimoRegistro == null) {
            return "No puede registrar una salida sin una entrada previa hoy.";
        }

        if (SALIDA.equals(ultimoRegistro.getTipo())) {
            return "No puede registrar dos salidas consecutivas.";
        }

        return null;
    }
}
