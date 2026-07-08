public class ListaEnlazada {
    Nodo cabeza;

    public void agregarNodoInicio(String datoNodo){
        Nodo nuevo = new Nodo(datoNodo);
        nuevo.siguienteNodo = cabeza;
        cabeza = nuevo;
    }
    public void recorrido(){
        if (cabeza == null){
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        while (actual != null){
            System.out.println(actual.Dato);
            actual = actual.siguienteNodo;
        }
    }
    public void agregarFinal(String datoNodo){
        Nodo nuevo = new Nodo(datoNodo);
        if (cabeza == null){
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while(actual.siguienteNodo != null){
            actual = actual.siguienteNodo;
        }
        actual.siguienteNodo = nuevo;
    }
    public boolean eliminarNodo(String datoEliminar){
        if (cabeza == null){
            return false;
        }
        Nodo actual = cabeza;
        while (actual.siguienteNodo != null){
            if(actual.siguienteNodo.Dato.equals(datoEliminar)){
                actual.siguienteNodo = actual.siguienteNodo.siguienteNodo;
                return true;
            }
            actual = actual.siguienteNodo;
        }
        return false;
    }

    public void buscarNodo(String datoBuscar){
        Nodo actual = cabeza;
        int posicion = 0;
        boolean encontrado = false;

        while (actual != null){
            if (actual.Dato.equals(datoBuscar)){
                System.out.println("Nodo encontrado en la posición " + posicion + ": " + actual.Dato);
                encontrado = true;
                break;
            }
            actual = actual.siguienteNodo;
            posicion++;
        }

        if (!encontrado){
            System.out.println("Nodo no encontrado: " + datoBuscar);
        }
    }

    public void actualizarNodo(String datoBuscar, String nuevoDato){
        Nodo actual = cabeza;

        while (actual != null){
            if (actual.Dato.equals(datoBuscar)){
                actual.Dato = nuevoDato;
                System.out.println("Nodo actualizado: " + datoBuscar + " -> " + nuevoDato);
                return;
            }
            actual = actual.siguienteNodo;
        }

        System.out.println("No se encontró el nodo para actualizar: " + datoBuscar);
    }
}