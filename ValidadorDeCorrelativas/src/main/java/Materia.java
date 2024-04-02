import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {

    private List<Materia> correlativas;

    public Materia() {
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativas(Materia ... materias) {
        Collections.addAll(this.correlativas,materias);
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
}
