import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;


public class Palindromo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();

        System.out.print("Ingresa una palabra: ");
        String palabra = sc.nextLine();

        for (int i = 0; i < palabra.length(); i++) {
            pila.push(palabra.charAt(i));
        }

       String reverso="";

       while(!pila.isEmpty()){ 
        reverso += pila.pop();
       }
        
          System.out.println("Original: " + palabra);
         System.out.println("Reverso: " + reverso);

        if(palabra.equals(reverso)){ 
            System.out.println("Las palabras son un palindromo.");
        }
        else{
            System.out.println("Las palabras no son un palindromo.");
        }
    }
}
