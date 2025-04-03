public class Contacto {
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

