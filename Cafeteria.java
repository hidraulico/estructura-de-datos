import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class Cafeteria {

    static Queue<String> esperando = new LinkedList<>();
    static Stack<String> cancelado = new Stack<>();
    static Scanner sc = new Scanner(System.in);

    public static void Menu() {
        int opcion;

        do {
            System.out.println("\nElige una opción:");
            System.out.println("1: Llegar cliente");
            System.out.println("2: Atender cliente");
            System.out.println("3: Cancelar pedido");
            System.out.println("4: Mostrar cola");
            System.out.println("5: Mostrar cancelaciones");
            System.out.println("6: Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    nuevoCliente();
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    cancelarPedido();
                    break;
                case 4:
                    mostrarPedidos();
                    break;
                case 5:
                    mostrarCancelados();
                    break;
            }

        } while (opcion != 6);
    }

    public static void nuevoCliente() {
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        esperando.add(nombre);
    }

    public static void atenderCliente() {
        if (esperando.isEmpty()) {
            System.out.println("No hay nadie esperando!");
        } else {
            System.out.println("Atendiendo a: " + esperando.peek());
            esperando.poll();
        }
    }

    public static void cancelarPedido() {
        if (esperando.isEmpty()) {
            System.out.println("No hay pedidos para cancelar.");
        } else {
            String cancelar = esperando.poll();
            cancelado.push(cancelar);
            System.out.println("Pedido cancelado exitosamente.");
        }
    }

    public static void mostrarPedidos() {
        System.out.println("Pedidos esperando: " + esperando);
    }

    public static void mostrarCancelados() {
        System.out.println("Pedidos cancelados: " + cancelado);
    }

    public static void main(String[] args) {
        Menu();
    }
}