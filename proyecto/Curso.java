public class Curso {

    public String Clave;
    public String Nombre;
    public String Docente;
    public int CupoMax;
    public int Inscritos;

    public Curso(String clave, String nombre, String docente, int cupoMax) {
        Clave = clave;
        Nombre = nombre;
        Docente = docente;
        CupoMax = cupoMax;
        Inscritos = 0;
    }
}