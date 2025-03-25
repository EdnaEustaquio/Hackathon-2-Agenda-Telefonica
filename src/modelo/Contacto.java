package modelo;

import java.util.Objects;

public class Contacto {
    //Atributos//
    private String nombre;
    private String apellido;
    private String telefono;


    //Constructor//
    public Contacto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Contacto(String nombre,String apellido, String telefono) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono = telefono;
    }
    //Getter y Setter//
     public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getNombreCompleto() {
        return nombre+" "+apellido;
    }

    public String getTelefono() {
        return telefono;
    }
public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //Metodos//

    @Override //Es necesario sobre escribir este metodo para que funcione System.out.println(contacto)
    public String toString(){
        return "Nombre: "+nombre+" "+apellido+", Teléfono: "+telefono;
    }
    @Override //Es necesario sobreescribir este metodo para que funcione contactos.remove(c) y se elimine el contacto
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        String nombreCompleto=getNombreCompleto();
        return nombreCompleto.equalsIgnoreCase(contacto.getNombreCompleto()); // Compara solo el nombre
    }
}
