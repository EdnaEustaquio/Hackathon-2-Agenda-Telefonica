package modelo;

import java.util.Objects;

public class Contacto {

    //Atributos
    private String nombre;
    private String apellido;
    private String telefono;

    //Constructor
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Comparar contactos por nombre y apellido
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; //Caso 1: son exactamente el mismo objeto
        if (obj==null|| getClass() != obj.getClass()) return false; //Caso 2: Argumento no valido
        Contacto contacto = (Contacto) obj; //Lo definimos dentro de la funcion como clase Contacto
        return nombre.equalsIgnoreCase(contacto.nombre);
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + " " + apellido + ", Teléfono: " + telefono;
    }
}
