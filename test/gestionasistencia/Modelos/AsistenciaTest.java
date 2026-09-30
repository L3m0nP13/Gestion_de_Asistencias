package gestionasistencia.Modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class AsistenciaTest {

    private final Usuario usuario = new Usuario(7, "Ana", "ana@correo.cl", "", "Empleado");

    @Test
    public void entradaAntesDelLimiteNoEsAtraso() {
        Asistencia asistencia = crearAsistencia("ENTRADA", 9, 29);
        assertFalse(asistencia.entradaAtrasada());
    }

    @Test
    public void entradaEnElLimiteNoEsAtraso() {
        Asistencia asistencia = crearAsistencia("ENTRADA", 9, 30);
        assertFalse(asistencia.entradaAtrasada());
    }

    @Test
    public void entradaDespuesDelLimiteEsAtraso() {
        Asistencia asistencia = crearAsistencia("ENTRADA", 9, 31);
        assertTrue(asistencia.entradaAtrasada());
    }

    @Test
    public void salidaAntesDelLimiteEsAnticipada() {
        Asistencia asistencia = crearAsistencia("SALIDA", 17, 29);
        assertTrue(asistencia.salidaAnticipada());
    }

    @Test
    public void salidaEnElLimiteNoEsAnticipada() {
        Asistencia asistencia = crearAsistencia("SALIDA", 17, 30);
        assertFalse(asistencia.salidaAnticipada());
    }

    @Test
    public void salidaDespuesDelLimiteNoEsAnticipada() {
        Asistencia asistencia = crearAsistencia("SALIDA", 17, 31);
        assertFalse(asistencia.salidaAnticipada());
    }

    @Test
    public void unaSalidaNoSeEvaluaComoEntradaAtrasada() {
        Asistencia asistencia = crearAsistencia("SALIDA", 18, 0);
        assertFalse(asistencia.entradaAtrasada());
    }

    @Test
    public void unaEntradaNoSeEvaluaComoSalidaAnticipada() {
        Asistencia asistencia = crearAsistencia("ENTRADA", 8, 0);
        assertFalse(asistencia.salidaAnticipada());
    }

    @Test
    public void constructorMantieneLosDatosRecibidos() {
        LocalDate fecha = LocalDate.of(2026, 9, 29);
        LocalTime hora = LocalTime.of(10, 15);
        Asistencia asistencia = new Asistencia(15, fecha, hora, "ENTRADA", usuario);

        assertEquals(15, asistencia.getId());
        assertEquals(fecha, asistencia.getFecha());
        assertEquals(hora, asistencia.getHora());
        assertEquals("ENTRADA", asistencia.getTipo());
        assertSame(usuario, asistencia.getUsuario());
    }

    @Test
    public void registrarEntradaCompletaLosDatosActuales() {
        Asistencia asistencia = new Asistencia(usuario);
        asistencia.registrarEntrada();

        assertEquals(LocalDate.now(), asistencia.getFecha());
        assertNotNull(asistencia.getHora());
        assertEquals("ENTRADA", asistencia.getTipo());
    }

    @Test
    public void registrarSalidaCompletaLosDatosActuales() {
        Asistencia asistencia = new Asistencia(usuario);
        asistencia.registrarSalida();

        assertEquals(LocalDate.now(), asistencia.getFecha());
        assertNotNull(asistencia.getHora());
        assertEquals("SALIDA", asistencia.getTipo());
    }

    private Asistencia crearAsistencia(String tipo, int hora, int minuto) {
        return new Asistencia(
                1,
                LocalDate.of(2026, 9, 29),
                LocalTime.of(hora, minuto),
                tipo,
                usuario
        );
    }
}
