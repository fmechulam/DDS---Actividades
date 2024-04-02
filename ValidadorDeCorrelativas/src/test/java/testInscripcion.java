import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testInscripcion {
    Alumno facu;
    Materia algoritmos;
    Materia paradigmas;
    Materia analisisDeSistemas;
    Materia disenio;
    Inscripcion nuevaInscripcion;;

    @BeforeEach
    public void inicializar() {
        facu               = new Alumno();
        algoritmos         = new Materia();
        paradigmas         = new Materia();
        analisisDeSistemas = new Materia();
        disenio            = new Materia();
        nuevaInscripcion   = new Inscripcion();

        analisisDeSistemas.agregarCorrelativas(algoritmos);
        paradigmas.agregarCorrelativas(algoritmos);
        disenio.agregarCorrelativas(analisisDeSistemas,paradigmas);

        nuevaInscripcion.setAlumnoAInscribir(facu);
    }

    @Test
    @DisplayName("La inscripcion fue satisfactoria porque cumplio las correlativas!")
    public void inscripcionAceptadaTest() {
        facu.agregarMateriasAprobadas(algoritmos);

        nuevaInscripcion.inscribirse(paradigmas,analisisDeSistemas);

        Assertions.assertTrue(nuevaInscripcion.aprobada());
    }

    @Test
    @DisplayName("La inscripcion no fue satisfactoria porque no cumple las correlativas!")
    public void inscripcionNoAceptadaTest() {
        facu.agregarMateriasAprobadas(algoritmos,analisisDeSistemas);

        nuevaInscripcion.inscribirse(disenio);

        Assertions.assertFalse(nuevaInscripcion.aprobada());
    }
}