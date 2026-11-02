package principal;

import dao.RecursoDAO;

public class ProbarCRUD {

    public static void main(String[] args) {

        RecursoDAO dao = new RecursoDAO();

        // Eliminar el recurso con ID 1
        System.out.println("=== ELIMINAR RECURSO ===");

        boolean eliminado = dao.eliminar(1);

        if (eliminado) {
            System.out.println("Recurso eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el recurso.");
        }

        // Consultar para verificar la eliminación
        System.out.println("\n=== CONSULTAR RECURSOS ===");

        if (dao.listar().isEmpty()) {
            System.out.println("No hay recursos registrados.");
        } else {
            dao.listar().forEach(recurso ->
                System.out.println(
                    "ID: " + recurso.getIdRecurso()
                    + " - Título: " + recurso.getTitulo()
                )
            );
        }
    }
}