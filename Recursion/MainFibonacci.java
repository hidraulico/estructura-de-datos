import java.util.Scanner;

public class MainFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el numero de terminos de la serie de Fibonacci: ");
        int n = scanner.nextInt();
        scanner.close();
        Fibonacci.mostrarSerie(n);
    }
}
