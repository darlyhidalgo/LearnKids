package principal;

import conexion.ConexionBD;
import java.sql.Connection;

public class ProbarConexion {

    public static void main(String[] args) {

        Connection conexion = ConexionBD.conectar();

        if (conexion != null) {
            System.out.println("LearnKids está conectado correctamente.");

            try {
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión.");
            }
        } else {
            System.out.println("No se pudo conectar con LearnKids.");
        }
    }
}