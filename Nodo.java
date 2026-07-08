public class Nodo {
    String Dato;
    Nodo siguienteNodo;

    public Nodo(String dato){
        Dato = dato;
        siguienteNodo = null;
    }

    @Override
    public String toString(){
        return Dato;
    }
}