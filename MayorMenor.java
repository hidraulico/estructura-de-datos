import java.util.Scanner;
import java.util.ArrayList;

public class MayorMenor{
    public static void main(String[] args){
    int[] arreglo = {1,2,3,4,5};
    int NumElementos=arreglo.length;
    int numero=3;
    int Mayor=0;
    int Menor=0;
    for(int i=0; i<NumElementos; i++){
        if (numero>arreglo[i]){
            Mayor++;
        }
        else if (numero<arreglo[i]){
            Menor++;
        }
    }
System.out.println("Mayores: " + Mayor);
System.out.println("Menores: " + Menor);

}
}