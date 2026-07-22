public class ListaDoble {
    private NodoDoble primero;
    private NodoDoble ultimo;

    public void agregarAlFinal(Curso curso) {
        NodoDoble nuevo = new NodoDoble(curso);
        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
            return;
        }

        ultimo.setSiguiente(nuevo);
        nuevo.setAnterior(ultimo);
        ultimo = nuevo;
    }

    public void mostrarInicioFin() {
        if (estaVacia()) {
            System.out.println("La lista doble está vacía.");
            return;
        }

        System.out.println("\n--- CURSOS DE INICIO A FIN ---");
        NodoDoble actual = primero;
        while (actual != null) {
            System.out.println(actual.getCurso());
            actual = actual.getSiguiente();
        }
    }

    public void mostrarFinInicio() {
        if (estaVacia()) {
            System.out.println("La lista doble está vacía.");
            return;
        }

        System.out.println("\n--- CURSOS DE FIN A INICIO ---");
        NodoDoble actual = ultimo;
        while (actual != null) {
            System.out.println(actual.getCurso());
            actual = actual.getAnterior();
        }
    }

    public boolean eliminar(String clave) {
        if (estaVacia()) {
            return false;
        }

        NodoDoble actual = primero;
        while (actual != null) {
            if (actual.getCurso().getClave().equalsIgnoreCase(clave)) {
                if (actual.getAnterior() == null && actual.getSiguiente() == null) {
                    primero = null;
                    ultimo = null;
                } else if (actual.getAnterior() == null) {
                    primero = actual.getSiguiente();
                    primero.setAnterior(null);
                } else if (actual.getSiguiente() == null) {
                    ultimo = actual.getAnterior();
                    ultimo.setSiguiente(null);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public NodoDoble getPrimero() {
        return primero;
    }
}
