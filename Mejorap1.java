import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorContactos gestor = new GestorContactos();
        gestor.cargarContactos();
        int opcion;

        do {
            System.out.println("\n--- Gestor de Contactos ---");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Mostrar Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Guardar Contactos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    gestor.agregarContacto(nombre, telefono, correo);
                    break;
                case 2:
                    gestor.mostrarContactos();
                    break;
                case 3:
                    System.out.print("Ingrese nombre: ");
                    gestor.buscarContacto(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Ingrese nombre: ");
                    gestor.eliminarContacto(scanner.nextLine());
                    break;
                case 5:
                    gestor.guardarContactos();
                    break;
                case 0:
                    gestor.guardarContactos();
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

