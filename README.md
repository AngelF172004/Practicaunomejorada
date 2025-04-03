Métodos
Paradigmas de programación

Jorge Eduardo Vázquez Villagrán                     
Moran Hernández Ángel Fernando                                                 
Daniel Enrique Cortes Santos

ESCUELA SUPERIOR DE COMPUTO
¿De qué trata la práctica?
Consiste en cambiar el código de las 3 practicas anteriores para adaptarlas al uso de los métodos de Java (Tipo Static).
Los métodos son un conjunto de instrucciones que se pueden ejecutar mediante su nombre. Los métodos pueden aceptar datos o parámetros, mismos que usan para devolver un valor.
Ya que realizan tareas específicas con nombres propios, cambian la estructura de los códigos, se explicarán los cambios realizados más adelante.
Un método tipo Static es aquel que pertenece a una clase y no a un objeto, por lo cual solo existe una instancia del método independientemente de cuántos objetos de la clase se creen.

¿Cómo se implementó?
Primera práctica:
Se creo una clase que muestra un menú interactivo. Agrega, muestra, busca, elimina y guarda contactos. Carga desde un archivo y los guarda antes de salir.
Se creo una clase contacto con nombre, teléfono y correo, que se sobrescribe.
La clase de GestorContactos tiene una lista de contactos, una función AgregarContacto. MostrarContacto. BuscarContacto (Por nombre). EliminarContacto (Por nombre). GuardarContacto. Y CargarContacto.
Segunda práctica:
Se movieron las funciones de gestión hacia una clase llamada Métodos.
RegistrarEstudiante: Maneja la entrada de datos y creación de estudiantes.
MostrarEstudiantes: Muestra la lista de estudiantes registrados.
BuscarEstudiante: Permite buscar un estudiante por matrícula.
EliminarEstudiante: Elimina estudiantes del arreglo y actualiza la información.
Main ahora delega la lógica a los métodos.
Scanner ahora funciona como parámetro.
Tercera práctica:
Se movieron los métodos aleatorio y pistas a una clase llamada Métodos.
Ya que los métodos están en otra clase, se llaman con Métodos.aleatorio() y Métodos.pistas().
Ahora JuegoAdivinanza solo se encarga de la lógica, mientras que Métodos tiene las funciones auxiliares.

Instrucciones para ejecutar el programa:
Para ejecutar el programa en Visual Studio Code es importante tener la extensión de Java (Java Extension Pack).
Una vez hecho, tienes que abrir el archivo que tiene el código fuente.
Y con la instrucción para ejecutar (Ctrl + Shift + B) se abrirá una terminar donde funciona el programa.

Problemas encontrados:
Ningún problema encontrado.

Solución a los problemas:
Ninguna solución necesitada.

Enlace al GitHub:
https://github.com/AngelF172004/Practicaunomejorada

https://github.com/AngelF172004/gestodeestudantesmejora

https://github.com/AngelF172004/juegoAdivinanzamejorado


Enlace al Microsoft Planner:
A



Codigo anterior:
import java.io.*;
import java.util.*;

public class GestorContactosApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> contactos = new ArrayList<>();
        String archivo = "contactos.txt";

        // Cargar contactos desde el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    contactos.add(datos);
                }
            }
            System.out.println("Contactos cargados desde el archivo.");
        } catch (IOException e) {
            System.out.println("No se encontró un archivo de contactos.");
        }

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
                    contactos.add(new String[]{nombre, telefono, correo});
                    System.out.println("Contacto agregado con éxito.");
                    break;
                case 2:
                    if (contactos.isEmpty()) {
                        System.out.println("No hay contactos disponibles.");
                    } else {
                        for (String[] c : contactos) {
                            System.out.println("Nombre: " + c[0] + " | Teléfono: " + c[1] + " | Correo: " + c[2]);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese nombre: ");
                    String nombreBuscar = scanner.nextLine();
                    boolean encontrado = false;
                    for (String[] c : contactos) {
                        if (c[0].equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Nombre: " + c[0] + " | Teléfono: " + c[1] + " | Correo: " + c[2]);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("Contacto no encontrado.");
                    break;
                case 4:
                    System.out.print("Ingrese nombre: ");
                    String nombreEliminar = scanner.nextLine();
                    Iterator<String[]> it = contactos.iterator();
                    boolean eliminado = false;
                    while (it.hasNext()) {
                        if (it.next()[0].equalsIgnoreCase(nombreEliminar)) {
                            it.remove();
                            eliminado = true;
                            System.out.println("Contacto eliminado con éxito.");
                            break;
                        }
                    }
                    if (!eliminado) System.out.println("Contacto no encontrado.");
                    break;
                case 5:
                    try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                        for (String[] c : contactos) {
                            pw.println(c[0] + "," + c[1] + "," + c[2]);
                        }
                        System.out.println("Contactos guardados en archivo.");
                    } catch (IOException e) {
                        System.out.println("Error al guardar los contactos.");
                    }
                    break;
                case 0:
                    try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                        for (String[] c : contactos) {
                            pw.println(c[0] + "," + c[1] + "," + c[2]);
                        }
                        System.out.println("Contactos guardados antes de salir.");
                    } catch (IOException e) {
                        System.out.println("Error al guardar los contactos.");
                    }
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

Codigo mejorado:
import java.io.*;
import java.util.*;

public class GestorContactosApp {
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


class Contacto {
    String nombre, telefono, correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String toString() {
        return "Nombre: " + nombre + " | Teléfono: " + telefono + " | Correo: " + correo;
    }
}

class GestorContactos {
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
Capturas del funcionamiento:
![image](https://github.com/user-attachments/assets/db291835-bf49-42c6-bd17-2ebbab47f6a5)
![image](https://github.com/user-attachments/assets/0fe26cd0-2559-4ba8-9665-e4d93aff4bcd)
![image](https://github.com/user-attachments/assets/accec60e-9017-49ce-af71-f90b156fe918)
![image](https://github.com/user-attachments/assets/2d249924-2fad-49e2-841c-313b4d4585c9)
![image](https://github.com/user-attachments/assets/ac0637ee-9d10-4d76-95bd-73d8ead7dacb)  

Conclusion:
1️⃣ Principio de Responsabilidad Única (SRP - Single Responsibility Principle)
Cada clase tiene una sola responsabilidad, lo que facilita el mantenimiento y la extensión del código:

GestorContactosApp: Maneja la interacción con el usuario.

GestorContactos: Gestiona la lógica de los contactos (agregar, eliminar, buscar, guardar, cargar).

Contacto: Representa un contacto con sus atributos.

Si todo estuviera en el main, cualquier cambio en la gestión de contactos afectaría directamente al código de la interfaz con el usuario.

2️⃣ Código Más Legible y Ordenado
Separar la lógica en clases hace que el código sea más fácil de entender y seguir.
Ejemplo:

Si alguien quiere modificar cómo se almacenan los contactos, solo modifica GestorContactos, sin tocar main.

Si quiere cambiar cómo se muestran los contactos en consola, modifica solo main.

Si todo estuviera en main, habría muchas líneas de código mezcladas y sería más difícil encontrar dónde hacer los cambios.

3️⃣ Reutilización del Código
Si en el futuro quisieras usar la gestión de contactos en una interfaz gráfica (GUI) o en una aplicación web, podrías reutilizar la clase GestorContactos sin modificar el código.

En cambio, si todo estuviera en main, tendrías que reescribir toda la lógica en el nuevo entorno.

4️⃣ Facilidad para Probar el Código (Testing)
Cuando las clases están separadas, puedes probar la lógica de GestorContactos sin necesidad de ejecutar toda la aplicación.

Por ejemplo, podrías escribir pruebas unitarias (con JUnit) para GestorContactos sin preocuparte por la entrada del usuario.

Si todo estuviera en main, no podrías probar funciones fácilmente sin interactuar manualmente con la aplicación.

5️⃣ Escalabilidad y Mantenimiento
A medida que la aplicación crece: ✅ Con clases separadas, es fácil agregar nuevas funciones (por ejemplo, exportar contactos a Excel).
❌ Si todo estuviera en main, el código se volvería más complicado y difícil de modificar sin romper otras partes.




