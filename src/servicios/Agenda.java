package servicios;

import modelo.Contacto;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima=10;

    //Constructores//
    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    //Métodos//

    // Metodo para saber si existe un contacto
    public boolean existeContacto(Contacto contacto) {
        String nombreCompleto=contacto.getNombreCompleto().toLowerCase();
        for (Contacto c: contactos){
            if (c.getNombreCompleto().toLowerCase().equals(nombreCompleto)){
                return true;
            }
        }
        return false;

    }

    // Metodo para añadir un contacto
    public void anadirContacto(Contacto c){
        if (agendaLlena()){
            System.out.println("La agenda está llena. No es posible añadir otro contacto");
        } else if (existeContacto(c)){
            System.out.println("El nombre del contacto que intenta registrar ya existe en la agenda.");
        } else {
            contactos.add(c);
            System.out.println("Contacto añadido con éxito ♥");
        }
    }


    // Metodo para listar todos los contactos
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }
    
    // Metodo para buscar contacto
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

    // Metodo para eliminar contacto
    public void eliminarContacto(Contacto c) {
        if (existeContacto(c)){
            contactos.remove(c);
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("No se encontró el contacto.");
        }
    }

    // Metodo para verificar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    // Metodo para ver cuántos espacios libres quedan
    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }

    // Metodo para modificar un telefono
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado correctamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

}
