import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final ListaSimple LISTA_SIMPLE = new ListaSimple();
    private static final ListaDoble LISTA_DOBLE = new ListaDoble();
    private static final Stack<String> HISTORIAL = new Stack<>();
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    mostrarCursos();
                    break;
                case 3:
                    buscarCursoPorClave();
                    break;
                case 4:
                    eliminarCurso();
                    break;
                case 5:
                    inscribirEstudiante();
                    break;
                case 6:
                    darDeBajaEstudiante();
                    break;
                case 7:
                    LISTA_DOBLE.mostrarInicioFin();
                    break;
                case 8:
                    LISTA_DOBLE.mostrarFinInicio();
                    break;
                case 9:
                    navegadorCursos();
                    break;
                case 10:
                    System.out.println("Total de cursos (recursividad): " + LISTA_SIMPLE.contarRecursivo());
                    break;
                case 11:
                    buscarCursoRecursivo();
                    break;
                case 12:
                    mostrarHistorial();
                    break;
                case 13:
                    System.out.println("Saliendo del Sistema de Gestión de Cursos UTC 2.0...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 13);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE GESTIÓN DE CURSOS UTC 2.0 =====");
        System.out.println("1. Agregar curso");
        System.out.println("2. Mostrar cursos");
        System.out.println("3. Buscar curso por clave");
        System.out.println("4. Eliminar curso");
        System.out.println("5. Inscribir estudiante a curso");
        System.out.println("6. Dar de baja estudiante de curso");
        System.out.println("7. Mostrar cursos de inicio a fin");
        System.out.println("8. Mostrar cursos de fin a inicio");
        System.out.println("9. Navegador de cursos");
        System.out.println("10. Contar cursos usando recursividad");
        System.out.println("11. Buscar curso usando recursividad");
        System.out.println("12. Mostrar historial de acciones");
        System.out.println("13. Salir");
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(SC.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor a cero.");
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return SC.nextLine().trim();
    }

    private static void agregarCurso() {
        String clave = leerTexto("Ingrese la clave del curso: ");
        if (clave.isEmpty()) {
            System.out.println("La clave no puede estar vacía.");
            return;
        }

        if (LISTA_SIMPLE.buscar(clave) != null) {
            System.out.println("La clave ya está registrada. No se puede duplicar.");
            return;
        }

        String nombre = leerTexto("Ingrese el nombre del curso: ");
        String docente = leerTexto("Ingrese el nombre del docente: ");
        int cupoMaximo = leerEnteroPositivo("Ingrese el cupo máximo: ");

        Curso curso = new Curso(clave, nombre, docente, cupoMaximo);
        LISTA_SIMPLE.agregar(curso);
        LISTA_DOBLE.agregarAlFinal(curso);
        HISTORIAL.push("Curso agregado: " + clave);
        System.out.println("Curso agregado exitosamente.");
    }

    private static void mostrarCursos() {
        LISTA_SIMPLE.mostrar();
    }

    private static void buscarCursoPorClave() {
        String clave = leerTexto("Ingrese la clave del curso a buscar: ");
        Curso curso = LISTA_SIMPLE.buscar(clave);
        if (curso != null) {
            System.out.println("Curso encontrado:");
            System.out.println(curso);
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    private static void eliminarCurso() {
        String clave = leerTexto("Ingrese la clave del curso a eliminar: ");
        if (LISTA_SIMPLE.eliminar(clave)) {
            LISTA_DOBLE.eliminar(clave);
            HISTORIAL.push("Curso eliminado: " + clave);
            System.out.println("Curso eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar porque el curso no existe.");
        }
    }

    private static void inscribirEstudiante() {
        String clave = leerTexto("Ingrese la clave del curso: ");
        Curso curso = LISTA_SIMPLE.buscar(clave);

        if (curso == null) {
            System.out.println("El curso no existe.");
            return;
        }

        if (curso.inscribirEstudiante()) {
            HISTORIAL.push("Estudiante inscrito en: " + clave);
            System.out.println("Estudiante inscrito exitosamente.");
        } else {
            System.out.println("No hay cupo disponible para este curso.");
        }
    }

    private static void darDeBajaEstudiante() {
        String clave = leerTexto("Ingrese la clave del curso: ");
        Curso curso = LISTA_SIMPLE.buscar(clave);

        if (curso == null) {
            System.out.println("El curso no existe.");
            return;
        }

        if (curso.darDeBajaEstudiante()) {
            HISTORIAL.push("Estudiante dado de baja en: " + clave);
            System.out.println("Estudiante dado de baja exitosamente.");
        } else {
            System.out.println("No hay estudiantes inscritos en este curso.");
        }
    }

    private static void navegadorCursos() {
        if (LISTA_DOBLE.estaVacia()) {
            System.out.println("No hay cursos registrados para navegar.");
            return;
        }

        NodoDoble actual = LISTA_DOBLE.getPrimero();
        int opcion = 0;

        do {
            System.out.println("\n===== NAVEGADOR DE CURSOS =====");
            System.out.println("Curso actual:");
            System.out.println(actual.getCurso());
            System.out.println("1. Siguiente curso");
            System.out.println("2. Curso anterior");
            System.out.println("3. Salir del navegador");
            opcion = leerEntero("Seleccione una opción: ");

            if (opcion == 1) {
                if (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                } else {
                    System.out.println("Ya estás en el último curso.");
                }
            } else if (opcion == 2) {
                if (actual.getAnterior() != null) {
                    actual = actual.getAnterior();
                } else {
                    System.out.println("Ya estás en el primer curso.");
                }
            } else if (opcion != 3) {
                System.out.println("Opción no válida.");
            }

        } while (opcion != 3);
    }

    private static void buscarCursoRecursivo() {
        String clave = leerTexto("Ingrese la clave del curso a buscar de forma recursiva: ");
        Curso curso = LISTA_SIMPLE.buscarRecursivo(clave);
        if (curso != null) {
            System.out.println("Curso encontrado:");
            System.out.println(curso);
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    private static void mostrarHistorial() {
        if (HISTORIAL.isEmpty()) {
            System.out.println("No hay historial de acciones.");
            return;
        }

        System.out.println("\n--- HISTORIAL DE ACCIONES ---");
        Stack<String> temporal = new Stack<>();
        while (!HISTORIAL.isEmpty()) {
            String registro = HISTORIAL.pop();
            System.out.println(registro);
            temporal.push(registro);
        }
        while (!temporal.isEmpty()) {
            HISTORIAL.push(temporal.pop());
        }
    }
}

class NodoSimple {
    private Curso curso;
    private NodoSimple siguiente;

    public NodoSimple(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }
}

class ListaSimple {
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

class NodoDoble {
    private Curso curso;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}

class ListaDoble {
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
