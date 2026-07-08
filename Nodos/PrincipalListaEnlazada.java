import java.util.Scanner;

public class PrincipalListaEnlazada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;
        do {
            System.out.println("\n=== MENU LISTA ENLAZADA ===");
            System.out.println("1. Agregar al inicio");
            System.out.println("2. Agregar al final");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Eliminar nodo");
            System.out.println("5. Buscar nodo");
            System.out.println("6. Actualizar nodo");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el dato para agregar al inicio: ");
                    String datoInicio = scanner.nextLine();
                    lista.agregarNodoInicio(datoInicio);
                    System.out.println("Dato agregado al inicio.");
                    break;
                case 2:
                    System.out.print("Ingresa el dato para agregar al final: ");
                    String datoFinal = scanner.nextLine();
                    lista.agregarFinal(datoFinal);
                    System.out.println("Dato agregado al final.");
                    break;
                case 3:
                    System.out.println("Contenido de la lista:");
                    lista.recorrido();
                    break;
                case 4:
                    System.out.print("Ingresa el dato a eliminar: ");
                    String datoEliminar = scanner.nextLine();
                    if (lista.eliminarNodo(datoEliminar)) {
                        System.out.println("Nodo eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró el nodo para eliminar.");
                    }
                    break;
                case 5:
                    System.out.print("Ingresa el dato a buscar: ");
                    String datoBuscar = scanner.nextLine();
                    lista.buscarNodo(datoBuscar);
                    break;
                case 6:
                    System.out.print("Ingresa el dato que deseas actualizar: ");
                    String datoActual = scanner.nextLine();
                    System.out.print("Ingresa el nuevo dato: ");
                    String nuevoDato = scanner.nextLine();
                    lista.actualizarNodo(datoActual, nuevoDato);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}