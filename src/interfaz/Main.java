package interfaz;

import modelo.Contacto;
import servicios.Agenda;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String nombre;
        String apellido = "";
        String telefono = "";
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion = 0;

        do {
            System.out.println("\nMenú de Agenda Telefónica");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Ver si la agenda está llena");
            System.out.println("6. Ver espacios libres");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            // Manejo de Exception: verificar si la entrada es un número
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Error: Intentalo nuévamente. Debes ingresar un número válido");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Validar nombre
                    do{
                        System.out.print("Introduce el nombre: ");
                        nombre = scanner.nextLine();
                        if (nombre.isEmpty()){
                            System.out.println("El campo nombre no puede estar vacío. Intenta nuevamente");
                        }
                    } while (nombre.isEmpty());

                    // Validar apellido
                    do {
                        System.out.print("Introduce el apellido: ");
                        apellido = scanner.nextLine();
                        if (apellido.isEmpty()){
                            System.out.println("El campo apellido no puede estar vacío. Intenta nuevamente");
                        }
                    } while (apellido.isEmpty());

                    // Validar teléfono
                    do{
                        System.out.print("Introduce el número de teléfono: ");
                        telefono = scanner.nextLine();
                        if (telefono.isEmpty()){
                            System.out.println("El número de teléfono no puede estar vacío. Intenta nuevamente.");
                        }
                    } while(telefono.isEmpty());

                    Contacto c = new Contacto(nombre, apellido, telefono);
                    agenda.anadirContacto(c);
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione ENTER
                    break;
                case 2:
                    System.out.print("Introduce el nombre a buscar: ");
                    nombre = scanner.nextLine();
                    agenda.buscaContacto(nombre);
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione ENTER
                    break;
                case 3:
                    agenda.listarContactos();
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione ENTER
                    break;
                case 4:
                    System.out.print("Introduce el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido, telefono));
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione ENTER
                    break;
                case 5:
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "Aún hay espacio en la agenda.");
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione ENTER
                    break;
                case 6:
                    System.out.println("Aún cuenta con " + agenda.espaciosLibres() + " espacios disponibles.");
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione ENTER
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        while (opcion != 7);

        scanner.close();
    }
}


