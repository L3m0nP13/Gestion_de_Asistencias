package gestionasistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorUsuario {

    public ResultadoAutenticacion autenticarUsuario(String correo, String contrasena) {

        String sql = "SELECT id_usuario, nombre, correo, contrasena, rol "
                + "FROM Usuario WHERE correo = ? AND contrasena = ?";

        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.conectar()) {

            if (conexion == null) {
                return ResultadoAutenticacion.error(
                        "No fue posible conectar con la base de datos."
                );
            }

            try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {

                sentencia.setString(1, correo);
                sentencia.setString(2, contrasena);

                try (ResultSet resultado = sentencia.executeQuery()) {

                    if (resultado.next()) {
                        Usuario usuario = new Usuario(
                                resultado.getInt("id_usuario"),
                                resultado.getString("nombre"),
                                resultado.getString("correo"),
                                resultado.getString("contrasena"),
                                resultado.getString("rol")
                        );

                        return ResultadoAutenticacion.exito(usuario);
                    }
                }
            }

            return ResultadoAutenticacion.error("Correo o contraseña incorrectos.");

        } catch (SQLException e) {

            System.out.println("Error al autenticar usuario");
            e.printStackTrace();

            return ResultadoAutenticacion.error(
                    "No se pudo validar el usuario. Verifique la conexión."
            );
        }
    }

    
    
    public boolean existeCorreo(String correo) {

    String sql = "SELECT id_usuario FROM Usuario WHERE correo = ?";

    Conexion conexionBD = new Conexion();

    try (
        Connection conexion = conexionBD.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)
    ) {

        sentencia.setString(1, correo);

        try (ResultSet resultado = sentencia.executeQuery()) {

            return resultado.next();
        }

    } catch (SQLException e) {

        System.out.println("Error al verificar correo");
        e.printStackTrace();

        return false;
    }
}
    
    public boolean crearUsuario(Usuario usuario) {

        if (existeCorreo(usuario.getCorreo())) {
        return false;
        }

        String sql = "INSERT INTO Usuario "
                + "(nombre, correo, contrasena, rol) "
                + "VALUES (?, ?, ?, ?)";

        Conexion conexionBD = new Conexion();

        try (
            Connection conexion = conexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getCorreo());
            sentencia.setString(3, usuario.getContrasena());
            sentencia.setString(4, usuario.getRol());

            int resultado = sentencia.executeUpdate();

            return resultado > 0;

        } catch (SQLException e) {

            System.out.println("Error al crear usuario");
            e.printStackTrace();

            return false;
        }
    }


    public Usuario buscarUsuario(int idUsuario) {

        String sql = "SELECT id_usuario, nombre, correo, contrasena, rol "
                + "FROM Usuario "
                + "WHERE id_usuario = ?";

        Conexion conexionBD = new Conexion();

        try (
            Connection conexion = conexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setInt(1, idUsuario);

            try (ResultSet resultado = sentencia.executeQuery()) {

                if (resultado.next()) {

                    return new Usuario(
                            resultado.getInt("id_usuario"),
                            resultado.getString("nombre"),
                            resultado.getString("correo"),
                            resultado.getString("contrasena"),
                            resultado.getString("rol")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar usuario");
            e.printStackTrace();
        }

        return null;
    }


    public boolean modificarUsuario(Usuario usuario) {

        String sql = "UPDATE Usuario "
                + "SET nombre = ?, "
                + "correo = ?, "
                + "contrasena = ?, "
                + "rol = ? "
                + "WHERE id_usuario = ?";

        Conexion conexionBD = new Conexion();

        try (
            Connection conexion = conexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getCorreo());
            sentencia.setString(3, usuario.getContrasena());
            sentencia.setString(4, usuario.getRol());
            sentencia.setInt(5, usuario.getId());

            int resultado = sentencia.executeUpdate();

            return resultado > 0;

        } catch (SQLException e) {

            System.out.println("Error al modificar usuario");
            e.printStackTrace();

            return false;
        }
    }


    public boolean eliminarUsuario(int idUsuario) {

        String sql = "DELETE FROM Usuario "
                + "WHERE id_usuario = ?";

        Conexion conexionBD = new Conexion();

        try (
            Connection conexion = conexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setInt(1, idUsuario);

            int resultado = sentencia.executeUpdate();

            return resultado > 0;

        } catch (SQLException e) {

            System.out.println("Error al eliminar usuario");
            e.printStackTrace();

            return false;
        }
    }


    public ArrayList<Usuario> listarUsuarios() {

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        String sql = "SELECT id_usuario, nombre, correo, contrasena, rol "
                + "FROM Usuario "
                + "ORDER BY id_usuario";

        Conexion conexionBD = new Conexion();

        try (
            Connection conexion = conexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                Usuario usuario = new Usuario(
                        resultado.getInt("id_usuario"),
                        resultado.getString("nombre"),
                        resultado.getString("correo"),
                        resultado.getString("contrasena"),
                        resultado.getString("rol")
                );

                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar usuarios");
            e.printStackTrace();
        }

        return listaUsuarios;
    }
}
