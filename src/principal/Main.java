package principal;
import dao.RecursoDAO;
import modelo.RecursoEducativo;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        RecursoDAO dao = new RecursoDAO();
        int opcion = 0;

        do {
            System.out.println("\n================================");
            System.out.println("       SISTEMA LEARNKIDS");
            System.out.println(" Gestión de recursos educativos");
            System.out.println("================================");
            System.out.println("1. Registrar recurso");
            System.out.println("2. Consultar recursos");
            System.out.println("3. Actualizar recurso");
            System.out.println("4. Eliminar recurso");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {

                    case 1:
                        RecursoEducativo nuevo = new RecursoEducativo();

                        System.out.print("Título: ");
                        nuevo.setTitulo(entrada.nextLine());

                        System.out.print("Descripción: ");
                        nuevo.setDescripcion(entrada.nextLine());

                        System.out.print("Tipo: ");
                        nuevo.setTipo(entrada.nextLine());

                        System.out.print("Categoría: ");
                        nuevo.setCategoria(entrada.nextLine());

                        System.out.print("Edad recomendada: ");
                        nuevo.setEdadRecomendada(entrada.nextLine());

                        System.out.print("Archivo: ");
                        nuevo.setArchivo(entrada.nextLine());

                        dao.insertar(nuevo);
                        break;

                    case 2:
                        List<RecursoEducativo> recursos = dao.listar();

                        System.out.println("\n--- RECURSOS EDUCATIVOS ---");

                        if (recursos.isEmpty()) {
                            System.out.println("No hay recursos registrados.");
                        } else {
                            for (RecursoEducativo r : recursos) {
                                System.out.println(
                                    "ID: " + r.getIdRecurso()
                                    + " | Título: " + r.getTitulo()
                                    + " | Categoría: " + r.getCategoria()
                                );
                            }
                        }
                        break;

                    case 3:
                        RecursoEducativo actualizado =
                            new RecursoEducativo();

                        System.out.print("ID del recurso: ");
                        actualizado.setIdRecurso(
                            Integer.parseInt(entrada.nextLine())
                        );

                        System.out.print("Nuevo título: ");
                        actualizado.setTitulo(entrada.nextLine());

                        System.out.print("Nueva descripción: ");
                        actualizado.setDescripcion(entrada.nextLine());

                        System.out.print("Nuevo tipo: ");
                        actualizado.setTipo(entrada.nextLine());

                        System.out.print("Nueva categoría: ");
                        actualizado.setCategoria(entrada.nextLine());

                        System.out.print("Nueva edad recomendada: ");
                        actualizado.setEdadRecomendada(entrada.nextLine());

                        System.out.print("Nuevo archivo: ");
                        actualizado.setArchivo(entrada.nextLine());

                        dao.actualizar(actualizado);
                        break;

                    case 4:
                        System.out.print("ID del recurso a eliminar: ");
                        int id = Integer.parseInt(entrada.nextLine());

                        dao.eliminar(id);
                        break;

                    case 5:
                        System.out.println("Gracias por utilizar LearnKids.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }

        } while (opcion != 5);

        entrada.close();
    }
}