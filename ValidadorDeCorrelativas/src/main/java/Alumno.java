import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private List<Materia> materiasAprobadas;

    public Alumno(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public Alumno() {
        this.materiasAprobadas =  new ArrayList<>();
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void agregarMateriasAprobadas(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas,materias);
    }

    public boolean puedeCursar(Materia unaMateria) {
        return this.materiasAprobadas.containsAll(unaMateria.getCorrelativas());
    }
}
