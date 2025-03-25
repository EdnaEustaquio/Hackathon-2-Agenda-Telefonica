package modelo;

import java.util.Objects;

public class Contacto {
    //Atributos//
    private String telefono;
    private String nombre;
    private String apellido;

    //Constructor//
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Metodos//
    @Override
    public String toString(){
        return "Nombre: "+nombre+" "+apellido+", Teléfono: "+telefono;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; //Caso 1: son exactamente el mismo objeto
        if (obj==null|| getClass() != obj.getClass()) return false; //Caso 2: Argumento no valido
        Contacto contacto = (Contacto) obj; //Lo definimos dentro de la funcion como clase Contacto
        return Objects.equals(nombre, contacto.nombre); //Los comparamos solo del nombre
    }
}
