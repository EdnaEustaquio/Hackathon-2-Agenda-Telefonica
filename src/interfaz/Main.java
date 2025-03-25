package interfaz;

import modelo.Contacto;
import servicios.Agenda;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        servicios.Agenda agenda = new servicios.Agenda(10); // Se puede modificar el tamaño

        while (true) {
            System.out.println("\nMenú");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Ver si la agenda está llena");
            System.out.println("6. Espacio disponible");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String apellido=scanner.nextLine();
                    System.out.print("Introduce el teléfono: ");
                    String telefono = scanner.nextLine();
                    agenda.anadirContacto(new Contacto(nombre, apellido, telefono));
                    break;
                case 2:
                    System.out.print("Introduce el primer nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    apellido = scanner.nextLine();
                    agenda.buscarContacto(nombre,apellido);
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    System.out.print("Introduce el primer nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Introduce el apellido del contacto a eliminar: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto (nombre, apellido));
                    break;
                case 5:
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "Aún hay espacio.");
                    break;
                case 6:
                    System.out.println("Espacios disponibles: " + agenda.espacioLibre());
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}


