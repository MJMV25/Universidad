package org.example.aplication;

import org.example.domain.Universidad;
import org.example.interfaces.UniversidadService;
import org.example.interfaces.UniversidadServiceImpl;
import org.example.repository.UniversidadRepository;
import org.example.repository.UniversidadRepositoryImpl;

import java.util.InputMismatchException;
import java.util.List;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UniversidadRepository repository = new UniversidadRepositoryImpl();
        UniversidadService service = new UniversidadServiceImpl(repository);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Universidad");
            System.out.println("2. Listar Universidades");
            System.out.println("3. Actualizar Universidad");
            System.out.println("4. Eliminar Universidad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    while (true) {
                        try {
                            System.out.print("Ingrese ID de la Universidad: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea

                            // Verificar si la universidad ya existe
                            if (service.obtenerUniversidad(id) != null) {
                                System.out.println("Error: Ya existe una universidad con ese ID.");
                                break;
                            }

                            System.out.print("Ingrese nombre de la Universidad: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese dirección de la Universidad: ");
                            String direccion = scanner.nextLine();

                            service.agregarUniversidad(new Universidad(id, nombre, direccion));
                            System.out.println("Universidad agregada con éxito.");
                            break; // Salir del bucle si se agrega correctamente

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Debe ingresar un número válido para el ID.");
                            scanner.nextLine(); // Limpiar el buffer
                        }
                    }
                    break;


                case 2:
                    List<Universidad> universidades = service.obtenerTodasLasUniversidades();
                    System.out.println("Lista de Universidades:");
                    universidades.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Ingrese ID de la Universidad a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir nueva línea
                    System.out.print("Ingrese nuevo nombre de la Universidad: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese nueva dirección de la Universidad: ");
                    String nuevaDireccion = scanner.nextLine();

                    service.actualizarUniversidad(new Universidad(idActualizar, nuevoNombre, nuevaDireccion));
                    System.out.println("Universidad actualizada con éxito.");
                    break;

                case 4:
                    System.out.print("Ingrese ID de la Universidad a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    service.eliminarUniversidad(idEliminar);
                    System.out.println("Universidad eliminada con éxito.");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}


