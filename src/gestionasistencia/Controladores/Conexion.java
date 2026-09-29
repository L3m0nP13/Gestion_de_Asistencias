package gestionasistencia.Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String usuario = "root";
    private final String clave = "";
    private final String bbdd = "SistemaAsistencia";
    private final String url = "jdbc:mariadb://127.0.0.1:3306/" + bbdd;

    public Connection conectar() {

        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }

        return conexion;
    }
}
