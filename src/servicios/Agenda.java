package servicios;

import modelo.Contacto;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public Agenda() {
        this(10); // Tamaño por defecto 10
    }

    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    public boolean anadirContacto(Contacto c) {
        if (contactos.size() >= capacidadMaxima) {
            System.out.println("La agenda está llena, no se puede añadir más contactos.");
            return false;
        }
        if (contactos.contains(c)) {
            System.out.println("El contacto ya existe.");
            return false;
        }
        contactos.add(c);
        System.out.println("Contacto añadido con éxito.");
        return true;
    }

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    public void buscaContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public boolean eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado con éxito.");
            return true;
        } else {
            System.out.println("No se encontró el contacto.");
            return false;
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public int espacioLibre() {
        return capacidadMaxima - contactos.size();
    }
}
