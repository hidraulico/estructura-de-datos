import java.util.Scanner;

public class Password {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String PasswordCorrecta = "Tortillas";
        String PasswordIngresada = "";

        do {

            System.out.print("Ingresa la contraseña: ");
            PasswordIngresada = sc.nextLine();

            if (!PasswordIngresada.equals(PasswordCorrecta)) {
                System.out.println("Contraseña incorrecta. Intenta de nuevo.\n");
            }

        } while (!PasswordIngresada.equals(PasswordCorrecta));

        System.out.println("Contraseña correcta.");
    }
}