public class EjerciciosFunciones {

    public static void main(String[] args) {        
        System.out.println("--- Ejercicio 1 ---");
        saludarAmigo();
        
        System.out.println("\n--- Ejercicio 2 ---");
        saludarPersona("Angel");
        
        System.out.println("\n--- Ejercicio 3 ---");
        int numeroFactorial = 8;
        System.out.println("El factorial de " + numeroFactorial + " es: " + calcularFactorial(numeroFactorial));
        
        System.out.println("\n--- Ejercicio 4 ---");
        double cantidadOriginal = 100.0;
        System.out.println("Total con 16% de IVA: " + calcularTotalFactura(cantidadOriginal, 16));
        System.out.println("Total sin especificar IVA (aplica 21%): " + calcularTotalFactura(cantidadOriginal));
        
        System.out.println("\n--- Ejercicio 5 ---");
        double radio = 3.5;
        double altura = 10.0;
        double areaCirculo = calcularAreaCirculo(radio);
        double volumenCilindro = calcularVolumenCilindro(radio, altura);
        
        System.out.println("El área del círculo con radio " + radio + " es: " + areaCirculo);
        System.out.println("El volumen del cilindro con altura " + altura + " es: " + volumenCilindro);
    }

    // EJERCICIO 1: Saludo simple
    public static void saludarAmigo() {
        System.out.println("¡Hola amigo!");
    }

    // EJERCICIO 2: Saludo personalizado
    public static void saludarPersona(String nombre) {
        System.out.println("¡Hola " + nombre + "!");
    }

    // EJERCICIO 3: Factorial de un número entero
    public static long calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser un entero positivo.");
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i; 
        }
        return factorial;
    }

    // EJERCICIO 4: Calcular factura con IVA
    public static double calcularTotalFactura(double cantidadSinIva, double porcentajeIva) {
        double totalIva = cantidadSinIva * (porcentajeIva / 100.0);
        return cantidadSinIva + totalIva;
    }
    public static double calcularTotalFactura(double cantidadSinIva) {
        return calcularTotalFactura(cantidadSinIva, 21.0);
    }

    // EJERCICIO 5: Área de círculo y volumen de cilindro
    
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
    public static double calcularVolumenCilindro(double radio, double altura) {
        double areaBase = calcularAreaCirculo(radio); 
        return areaBase * altura;
    }
}