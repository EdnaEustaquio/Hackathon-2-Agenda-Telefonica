package interfaz;

import modelo.Contacto;
import servicios.Agenda;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int maxContactos=0;
        System.out.println("\nBIENVENIDO A SU AGENDA TELEFÓNICA DE CONFIANZA");
        System.out.println("\n¿Quiere modificar el número máximo de contactos? SI/NO: ");
        String respuesta=scanner.nextLine();

        do{
        if (respuesta.equalsIgnoreCase("SI")) {
            System.out.print("Ingrese el número máximo de contactos en la agenda: ");
            maxContactos = scanner.nextInt();
            scanner.nextLine();
            break;
        } else if (respuesta.equalsIgnoreCase("no")){
            maxContactos=10;
            break;
        } else{
            System.out.println("Ingrese una respuesta valida si/no");
        }} while(respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("no"));

        System.out.println("Presiona ENTER para continuar...");
        scanner.nextLine();


        Agenda agenda = new Agenda(maxContactos);
        int opcion=0;
        String nombre="";
        String apellido="";
        String telefono="";

        do {
            System.out.println("\nBIENVENIDO A SU AGENDA TELEFÓNICA DE CONFIANZA");
            System.out.println("Por favor introduce el número de la función que desea.");
            System.out.println("\nMenú de Agenda Telefónica");
            System.out.println("Por favor introduce el número de la función que desea.");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Ver lista de contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Ver si la agenda está llena");
            System.out.println("6. Espacio disponible");
            System.out.println("7. Cambiar telefono");
            System.out.println("8. Modificar el número máximo de contactos");
            System.out.println("9. Salir de la Agenda");

            System.out.print("¿Cuál opción deseas?: ");
          
            // Manejo de Exception: verificar si la entrada es un número
            if(scanner.hasNextInt()){
              opcion = scanner.nextInt();
            } else {
              System.out.println("Error: Intentalo nuevamente. Introduce un número válido");
              System.out.println("Presiona ENTER para continuar...");
              scanner.nextLine();
              continue;
            }
            
            scanner.nextLine(); // Limpiar buffer


            switch (opcion) {
                case 1: //Añadir contacto
                    // Validar nombre
                    System.out.println("\nAÑADIR CONTACTO");
                    do{
                      System.out.print("Ingrese el nombre: ");
                      nombre = scanner.nextLine();
                      if (nombre.isEmpty()){
                          System.out.println("El campo nombre no puede estar vacío. Intente nuevamente");
                      }
                    } while (nombre.isEmpty());
                
                    // Validar apellido
                    do{
                      System.out.print("Ingrese el apellido: ");
                      apellido = scanner.nextLine();
                      if (apellido.isEmpty()){
                          System.out.println("El campo apellido no puede estar vacío. Intente nuevamente");
                      }
                    } while (apellido.isEmpty());
                
                    // Validar telefono
                    do{
                      System.out.print("Ingrese teléfono: ");
                      telefono = scanner.nextLine();
                      if (telefono.isEmpty()){
                          System.out.println("El número de teléfono no puede estar vacío. Intente nuevamente.");
                      }
                    } while (telefono.isEmpty());
                    
                    Contacto c = new Contacto(nombre, apellido, telefono);
                    agenda.anadirContacto(c);
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione ENTER
                    break;
                case 2: //Buscar contacto
                    System.out.println("\nBUSCAR CONTACTO");
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellido = scanner.nextLine();
                    System.out.println(agenda.existeContacto(new Contacto(nombre, apellido)) ? "El contacto existe." : "El contacto no existe.");
                    agenda.buscarContacto(nombre,apellido); //
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 3: //Enlistar contactos
                    System.out.println("\nLISTA DE CONTACTOS");
                    agenda.listarContactos();
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 4: //Eliminar contacto
                    System.out.println("\nELIMINAR CONTACTO");
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido));
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 5: //Ver estado de la agenda
                    System.out.println("\nESTADO DE LA AGENDA");
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "Aún hay espacio en la agenda.");
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 6: //Ver espacios disponibles
                    System.out.println("\nESPACIOS EN AGENDA");
                    System.out.println("Aún cuenta con " + agenda.espaciosLibres() + " espacios disponibles.");
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 7: //Modificar Telefono
                    System.out.println("\n MODIFICAR TELEFONO");
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese nuevo teléfono: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    System.out.println("Presiona ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 8: //Adioss
                    System.out.println("Nos vemos pronto!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor digite dentro de los números mostrados");
            }
        } while (opcion !=9);

        scanner.close();
    }
}
