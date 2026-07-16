public class Fibonacci {
    public static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long sumaFibonacci(long n) {
        if (n == 0) {
            return 0;
        }
        return fibonacci(n) + sumaFibonacci(n - 1);
    }

    public static void mostrarSerie(int n) {
        if (n < 0) {
            System.out.println("El número de términos no puede ser negativo.");
            return;
        }

        System.out.print("Serie de Fibonacci: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i));
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Suma de la serie: " + sumaFibonacci(n));
    }
}
