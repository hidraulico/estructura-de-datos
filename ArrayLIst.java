import java.util.ArrayList;

public class ArrayList {
    public static void main(String[] args) {

        ArrayList<Double> calificaciones = new ArrayList<>();
        ArrayList<Integer> asistencias = new ArrayList<>();
        ArrayList<Boolean> concursos = new ArrayList<>();

        calificaciones.add(95.5);
        calificaciones.add(88.0);
        calificaciones.add(72.5);
        calificaciones.add(91.0);
        calificaciones.add(65.0);
        calificaciones.add(98.5);
        calificaciones.add(84.0);
        calificaciones.add(77.5);
        calificaciones.add(93.0);
        calificaciones.add(69.5);

        asistencias.add(95);
        asistencias.add(85);
        asistencias.add(70);
        asistencias.add(82);
        asistencias.add(90);
        asistencias.add(100);
        asistencias.add(78);
        asistencias.add(88);
        asistencias.add(92);
        asistencias.add(65);

        concursos.add(false);
        concursos.add(true);
        concursos.add(false);
        concursos.add(false);
        concursos.add(true);
        concursos.add(false);
        concursos.add(false);
        concursos.add(true);
        concursos.add(false);
        concursos.add(false);

        for(int i=0; i<concursos.size(); i++){

            double Calificacion = calificaciones.get(i);
            int Asistencia = asistencias.get(i);
            boolean Concurso = concursos.get(i);

            boolean beca  = (Calificacion>=90 && Asistencia >=80) || (Concurso == true);

            if(beca){
                System.out.println("El alumno " + (i+1) + " tiene beca.");
            }
            else{  
                System.out.println("El alumno " + (i+1) + " no tiene beca.");
            }
        }
    }
}