package servicios;

import modelo.Contacto;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    //Constructores//
    public Agenda() {
        this(10); // Tamaño por defecto 10
    }

    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    //Métodos//
    public void anadirContacto(Contacto c) {

        if (contactos.size() >= capacidadMaxima) {
            System.out.println("La agenda está llena, no se puede añadir más contactos.");
        }
         else {
            if (existeContacto(c)) {
                System.out.println("El contacto ya existe.");
            } else {
                contactos.add(c);
                System.out.println("Contacto añadido con éxito.");
            }
        }
    }

    public boolean existeContacto(Contacto contacto) {
        String nombreCompleto=contacto.getNombreCompleto().toLowerCase();
        for (Contacto c: contactos){
            if (c.getNombreCompleto().toLowerCase().equals(nombreCompleto)){
                return true;
            }
        }
        return false;
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

    public void buscarContacto(String nombre, String apellido) {
        Contacto contacto=new Contacto(nombre, apellido);
            if (existeContacto(contacto)) {
               for (Contacto c:contactos){
                   if (c.getNombreCompleto().equalsIgnoreCase(contacto.getNombreCompleto())){
                       System.out.println("Teléfono: "+c.getTelefono());
                   }
               }
            } else{
                System.out.println("Contacto no encontrado");
        }
    }

    public void eliminarContacto(Contacto c) {
        if (existeContacto(c)){
            contactos.remove(c);
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("No se encontró el contacto.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public int espacioLibre() {
        return capacidadMaxima - contactos.size();
    }
}
