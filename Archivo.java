import java.io.*;
import java.util.*;

public class GestorContactos {
    private List<Contacto> contactos = new ArrayList<>();
    private final String archivo = "contactos.txt";

    public void agregarContacto(String nombre, String telefono, String correo) {
        contactos.add(new Contacto(nombre, telefono, correo));
        System.out.println("Contacto agregado con éxito.");
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos disponibles.");
        } else {
            contactos.forEach(System.out::println);
        }
    }

    public void buscarContacto(String nombre) {
        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (c.nombre.equalsIgnoreCase(nombre)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Contacto no encontrado.");
    }

    public void eliminarContacto(String nombre) {
        Iterator<Contacto> it = contactos.iterator();
        while (it.hasNext()) {
            if (it.next().nombre.equalsIgnoreCase(nombre)) {
                it.remove();
                System.out.println("Contacto eliminado con éxito.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public void guardarContactos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Contacto c : contactos) {
                pw.println(c.nombre + "," + c.telefono + "," + c.correo);
            }
            System.out.println("Contactos guardados en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos.");
        }
    }

    public void cargarContactos() {
        contactos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    contactos.add(new Contacto(datos[0], datos[1], datos[2]));
                }
            }
            System.out.println("Contactos cargados desde el archivo.");
        } catch (IOException e) {
            System.out.println("No se encontró un archivo de contactos.");
        }
    }
}
