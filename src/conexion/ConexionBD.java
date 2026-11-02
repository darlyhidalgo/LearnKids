package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
        "jdbc:mysql://localhost:3306/learnkids_db?useSSL=false&serverTimezone=UTC";

    private static final String USUARIO = "root";

    // Si tu MySQL tiene contraseña, deberás configurarla aquí.
    private static final String CONTRASENA = "";

    public static Connection conectar() {

        try {
            Connection conexion = DriverManager.getConnection(
                URL, USUARIO, CONTRASENA
            );

            System.out.println("¡Conexión exitosa con LearnKids!");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error al conectar con la base de datos:");
            System.out.println(e.getMessage());

            return null;
        }
    }
}