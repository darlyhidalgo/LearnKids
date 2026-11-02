package dao;

import conexion.ConexionBD;
import modelo.RecursoEducativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecursoDAO {

    // CREATE: Registrar un recurso educativo
    public boolean insertar(RecursoEducativo recurso) {

        String sql = "INSERT INTO recursos_educativos "
                + "(titulo, descripcion, tipo, categoria, edad_recomendada, archivo) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, recurso.getTitulo());
            consulta.setString(2, recurso.getDescripcion());
            consulta.setString(3, recurso.getTipo());
            consulta.setString(4, recurso.getCategoria());
            consulta.setString(5, recurso.getEdadRecomendada());
            consulta.setString(6, recurso.getArchivo());

            int filas = consulta.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar el recurso: " + e.getMessage());
            return false;
        }
    }

    // READ: Consultar todos los recursos educativos
    public List<RecursoEducativo> listar() {

        List<RecursoEducativo> recursos = new ArrayList<>();

        String sql = "SELECT * FROM recursos_educativos";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {

            while (resultado.next()) {

                RecursoEducativo recurso = new RecursoEducativo();

                recurso.setIdRecurso(resultado.getInt("id_recurso"));
                recurso.setTitulo(resultado.getString("titulo"));
                recurso.setDescripcion(resultado.getString("descripcion"));
                recurso.setTipo(resultado.getString("tipo"));
                recurso.setCategoria(resultado.getString("categoria"));
                recurso.setEdadRecomendada(resultado.getString("edad_recomendada"));
                recurso.setArchivo(resultado.getString("archivo"));

                recursos.add(recurso);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los recursos: " + e.getMessage());
        }

        return recursos;
    }

    // UPDATE: Actualizar un recurso educativo
    public boolean actualizar(RecursoEducativo recurso) {

        String sql = "UPDATE recursos_educativos SET "
                + "titulo = ?, descripcion = ?, tipo = ?, "
                + "categoria = ?, edad_recomendada = ?, archivo = ? "
                + "WHERE id_recurso = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, recurso.getTitulo());
            consulta.setString(2, recurso.getDescripcion());
            consulta.setString(3, recurso.getTipo());
            consulta.setString(4, recurso.getCategoria());
            consulta.setString(5, recurso.getEdadRecomendada());
            consulta.setString(6, recurso.getArchivo());
            consulta.setInt(7, recurso.getIdRecurso());

            int filas = consulta.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el recurso: " + e.getMessage());
            return false;
        }
    }

    // DELETE: Eliminar un recurso educativo
    public boolean eliminar(int idRecurso) {

        String sql = "DELETE FROM recursos_educativos WHERE id_recurso = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setInt(1, idRecurso);

            int filas = consulta.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el recurso: " + e.getMessage());
            return false;
        }
    }
}