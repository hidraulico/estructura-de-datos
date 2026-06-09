import java.util.Scanner;
import java.util.ArrayList;

public class SumaArreglo{
    public static void main(String[] args){
    int[] arreglo = {1,2,3,4,5};
    int suma=0;
    int NumElementos=arreglo.length;
    for(int i=0; i<NumElementos; i++){
        suma +=arreglo[i];
    }
System.out.println(suma);

float promedio = suma/NumElementos;
System.out.println(promedio);
}
}