public class ListaSimple {
    private NodoSimple cabeza;

    public void agregar(Curso curso) {
        NodoSimple nuevo = new NodoSimple(curso);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        NodoSimple actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("\n--- CURSOS REGISTRADOS ---");
        NodoSimple actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getCurso());
            actual = actual.getSiguiente();
        }
    }

    public Curso buscar(String clave) {
        NodoSimple actual = cabeza;
        while (actual != null) {
            if (actual.getCurso().getClave().equalsIgnoreCase(clave)) {
                return actual.getCurso();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(String clave) {
        if (estaVacia()) {
            return false;
        }

        if (cabeza.getCurso().getClave().equalsIgnoreCase(clave)) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        NodoSimple actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getCurso().getClave().equalsIgnoreCase(clave)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public int contarRecursivo() {
        return contarRecursivo(cabeza);
    }

    private int contarRecursivo(NodoSimple nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarRecursivo(nodo.getSiguiente());
    }

    public Curso buscarRecursivo(String clave) {
        return buscarRecursivo(cabeza, clave);
    }

    private Curso buscarRecursivo(NodoSimple nodo, String clave) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getCurso().getClave().equalsIgnoreCase(clave)) {
            return nodo.getCurso();
        }
        return buscarRecursivo(nodo.getSiguiente(), clave);
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
