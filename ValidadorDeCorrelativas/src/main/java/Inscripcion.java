import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Inscripcion  {
    private List<Materia> materiasAInscribir;
    private Alumno alumnoAInscribir;

    public Inscripcion() {
        this.materiasAInscribir = new ArrayList<>();
    }

    public void setAlumnoAInscribir(Alumno alumnoAInscribir) {
        this.alumnoAInscribir = alumnoAInscribir;
    }

    public void inscribirse(Materia ... materias) {
        Collections.addAll(this.materiasAInscribir,materias);
    }

    public boolean aprobada() {
        return materiasAInscribir.stream().allMatch(unaMateria -> alumnoAInscribir.puedeCursar(unaMateria));
    }
}