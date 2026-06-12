import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class ParesImpares {
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        Queue<Integer> colapar = new LinkedList<>();
        Queue<Integer> colaimpar = new LinkedList<>();
        Random random = new Random();

        for(int i=0;i<20;i++){
            int randomNumber = random.nextInt(100);
            cola.add(randomNumber);
        }
        
        System.out.println("Elementos en la cola:" + cola);

        for(int i=0;i<20;i++){
            int elemento = cola.poll();
            if(elemento%2==0){
                colapar.add(elemento);
            } else {
                colaimpar.add(elemento);
            }
    }

    System.out.println("Cola Par:" + colapar);
    System.out.println("Cola Impar:" + colaimpar);
    }
}