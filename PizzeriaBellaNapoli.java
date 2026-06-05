import java.util.Scanner;

public class PizzeriaBellaNapoli {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tipoPizza;
        char ingrediente;
        String nombrePizza = "";
        String ingredienteExtra = "";

        System.out.println("=== Pizzería Bella Napoli ===");
        System.out.println("Tipos de pizza:");
        System.out.println("1. Vegetariana");
        System.out.println("2. No vegetariana");
        System.out.print("Elige una opción: ");
        tipoPizza = sc.nextInt();

        if (tipoPizza == 1) {

            nombrePizza = "Vegetariana";

            System.out.println("\nIngredientes vegetarianos:");
            System.out.println("a. Pimiento");
            System.out.println("b. Tofu");
            System.out.print("Elige un ingrediente: ");
            ingrediente = sc.next().charAt(0);

            switch (ingrediente) {
                case 'a':
                    ingredienteExtra = "Pimiento";
                    break;

                case 'b':
                    ingredienteExtra = "Tofu";
                    break;

                default:
                    ingredienteExtra = "Ingrediente no válido";
            }

        } else if (tipoPizza == 2) {

            nombrePizza = "No vegetariana";

            System.out.println("\nIngredientes no vegetarianos:");
            System.out.println("a. Peperoni");
            System.out.println("b. Jamón");
            System.out.println("c. Salmón");
            System.out.print("Elige un ingrediente: ");
            ingrediente = sc.next().charAt(0);

            switch (ingrediente) {
                case 'a':
                    ingredienteExtra = "Peperoni";
                    break;

                case 'b':
                    ingredienteExtra = "Jamón";
                    break;

                case 'c':
                    ingredienteExtra = "Salmón";
                    break;

                default:
                    ingredienteExtra = "Ingrediente no válido";
            }

        } else {
            System.out.println("Tipo de pizza no válido.");
            return;
        }

        System.out.println("\n=== Resumen de la pizza ===");
        System.out.println("Tipo de pizza: " + nombrePizza);
        System.out.println("Ingredientes: Mozzarella, Tomate y " + ingredienteExtra);

        sc.close();
    }
}