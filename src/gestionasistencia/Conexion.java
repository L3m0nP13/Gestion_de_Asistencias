package gestionasistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//SE USARÁ EN AVANCE 2
public class Conexion {
    public static void main(String[] args) {
        String url = ""; //SQL URL
        String usuario = "";
        String contraseña = "";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println(":D conexión exitosa.");
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexión:");
            e.printStackTrace();
        }
    }
}