import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Curso> cursos = new ArrayList<>();
        Stack<String> historial = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n1. Agregar curso");
            System.out.println("2. Mostrar cursos");
            System.out.println("3. Buscar curso");
            System.out.println("4. Inscribir estudiante");
            System.out.println("5. Dar de baja estudiante");
            System.out.println("6. Eliminar curso");
            System.out.println("7. Mostrar historial");
            System.out.println("8. Mostrar cursos disponibles");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarCurso(cursos, historial, sc);
                    break;
                case 2:
                    mostrarCursos(cursos);
                    break;
                case 3:
                    buscarCurso(cursos, sc);
                    break;
                case 4:
                    System.out.println("Ingrese clave del curso: ");
                    inscribirEstudiante(cursos, historial, sc.nextLine());
                    break;
                case 5:
                    System.out.println("Ingrese clave del curso: ");
                    bajaEstudiante(cursos, historial, sc.nextLine());
                    break;
                case 6:
                    System.out.println("Ingrese clave del curso: ");
                    eliminarCurso(cursos, historial, sc.nextLine());
                    break;
                case 7:
                    mostrarHistorial(historial);
                    break;
                case 8:
                    mostrarCursosDisponibles(cursos);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);
    }

    public static void agregarCurso(ArrayList<Curso> cursos, Stack<String> historial, Scanner sc) {
        System.out.println("Ingrese clave del curso: ");
        String clave = sc.nextLine();
        System.out.println("Ingrese nombre del curso: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese docente: ");
        String docente = sc.nextLine();
        System.out.println("Ingrese cupo máximo: ");
        int cupoMax = sc.nextInt();

        Curso nuevoCurso = new Curso(clave, nombre, docente, cupoMax);
        cursos.add(nuevoCurso);
        historial.push("Curso agregado: " + clave);
        System.out.println("Curso agregado exitosamente.");
    }

    public static void mostrarCursos(ArrayList<Curso> cursos) {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            System.out.println("\n--- CURSOS DISPONIBLES ---");
            for (Curso c : cursos) {
                System.out.println(
                        c.Clave + " | " + c.Nombre + " | " + c.Docente + " | " + c.Inscritos + "/" + c.CupoMax);
            }
            System.out.println();
        }
    }

    public static Curso buscarCurso(ArrayList<Curso> cursos, Scanner sc) {
        System.out.println("Ingrese la clave del curso a buscar: ");
        String clave = sc.nextLine();

        for (Curso c : cursos) {
            if (c.Clave.equals(clave)) {
                System.out.println("Curso encontrado: " + c.Nombre);
                return c;
            }
        }
        System.out.println("Curso no encontrado.");
        return null;
    }

    public static Curso buscarCurso(ArrayList<Curso> cursos, String clave) {
        for (Curso c : cursos) {
            if (c.Clave.equals(clave)) {
                return c;
            }
        }
        return null;
    }

    public static void inscribirEstudiante(ArrayList<Curso> cursos, Stack<String> historial, String clave) {
        Curso c = buscarCurso(cursos, clave);

        if (c != null && c.Inscritos < c.CupoMax) {
            c.Inscritos++;
            historial.push("Estudiante inscrito en: " + clave);
            System.out.println("Estudiante inscrito exitosamente.");
        } else if (c == null) {
            System.out.println("El curso no existe.");
        } else {
            System.out.println("No hay cupo disponible.");
        }
    }

    public static void bajaEstudiante(ArrayList<Curso> cursos, Stack<String> historial, String clave) {
        Curso c = buscarCurso(cursos, clave);

        if (c != null && c.Inscritos > 0) {
            c.Inscritos--;
            historial.push("Estudiante dado de baja de: " + clave);
            System.out.println("Estudiante dado de baja exitosamente.");
        } else if (c == null) {
            System.out.println("El curso no existe.");
        } else {
            System.out.println("No hay estudiantes inscritos en este curso.");
        }
    }

    public static void eliminarCurso(ArrayList<Curso> cursos, Stack<String> historial, String clave) {
        Curso c = buscarCurso(cursos, clave);

        if (c != null) {
            cursos.remove(c);
            historial.push("Curso eliminado: " + clave);
            System.out.println("Curso eliminado exitosamente.");
        } else {
            System.out.println("El curso no existe.");
        }
    }

    public static void mostrarHistorial(Stack<String> historial) {
        if (historial.isEmpty()) {
            System.out.println("No hay historial.");
        } else {
            System.out.println("\n--- HISTORIAL ---");
            Stack<String> temp = new Stack<>();
            while (!historial.isEmpty()) {
                String registro = historial.pop();
                System.out.println(registro);
                temp.push(registro);
            }
            while (!temp.isEmpty()) {
                historial.push(temp.pop());
            }
            System.out.println();
        }
    }

    public static void mostrarCursosDisponibles(ArrayList<Curso> cursos) {

        boolean encontrados = false;

        for (Curso c : cursos) {
            if (c.Inscritos < c.CupoMax) {
                System.out.println(c.Clave + " | " +
                        c.Nombre + " | " +
                        c.Inscritos + "/" + c.CupoMax);

                encontrados = true;
            }
        }

        if (!encontrados) {
            System.out.println("No hay cursos con cupo disponible.");
        }
    }

}