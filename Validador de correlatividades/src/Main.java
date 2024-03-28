import java.util.ArrayList;
import java.util.List;

class Materia {
    private String nombre;
    public Materia(String nombre) {
        this.nombre = nombre;
        correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
}

class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        for (Materia materia : materias) {
            for (Materia correlativa : materia.getCorrelativas()) {
                if (!alumno.aprobada(correlativa)) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Juan");

        Materia estructurasDatos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmasProgramacion = new Materia("Paradigmas de Programación");
        Materia disenoSistemas = new Materia("Diseño de Sistemas");

        paradigmasProgramacion.agregarCorrelativa(estructurasDatos);
        disenoSistemas.agregarCorrelativa(paradigmasProgramacion);

        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(disenoSistemas);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        if (inscripcion.aprobada()) {
            System.out.println("Inscripción aprobada.");
        } else {
            System.out.println("Inscripción rechazada.");
        }
    }
}