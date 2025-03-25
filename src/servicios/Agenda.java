package servicios;

import modelo.Contacto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public Agenda(int capacidad) {
        this.capacidadMaxima = capacidad;
        this.contactos = new ArrayList<>();
    }

    public Agenda() {
        this(10); // Tamaño por defecto 10
    }

    // Metodo para añadir un contacto
    public void anadirContacto(Contacto c){
        if (agendaLlena()){
            System.out.println("La agenda está llena. No es posible añadir otro contacto");
        } else if (contactos.contains(c)){
            System.out.println("El nombre del contacto que intenta registrar ya existe en la agenda.");
        } else {
            contactos.add(c);
            System.out.println("Contacto añadido con éxito ♥");
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



}
