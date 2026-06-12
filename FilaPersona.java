import java.util.Queue;
import java.util.LinkedList;

public class FilaPersona{
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();
        cola.add("Paco");
        cola.add("Luis");
        cola.add("Alex");
        cola.add("Oscar");
        cola.add("Maria");

        System.out.println("Cola actual: " + cola);

        System.out.println("Persona hasta en frente:" + cola.peek());

        for(int i=0;i<2;i++){
            cola.poll();

        }

        System.out.println("Cola restante: " + cola);
    }
}