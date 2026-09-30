package gestionasistencia.Controladores;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorReporteIntegrationTest {

    @Test
    public void atrasosAceptaUnaFechaValida() {
        ControladorReporte controlador = new ControladorReporte();
        assertNotNull(controlador.listarAtrasos(LocalDate.now()));
        assertNull(controlador.getUltimoError());
    }

    @Test
    public void salidasAnticipadasAceptaUnaFechaValida() {
        ControladorReporte controlador = new ControladorReporte();
        assertNotNull(controlador.listarSalidasAnticipadas(LocalDate.now()));
        assertNull(controlador.getUltimoError());
    }

    @Test
    public void inasistenciasAceptaUnaFechaValida() {
        ControladorReporte controlador = new ControladorReporte();
        assertNotNull(controlador.listarInasistencias(LocalDate.now()));
        assertNull(controlador.getUltimoError());
    }

    @Test
    public void atrasosRechazaUnaFechaNula() {
        ControladorReporte controlador = new ControladorReporte();
        assertTrue(controlador.listarAtrasos(null).isEmpty());
        assertEquals("Debe ingresar una fecha válida.", controlador.getUltimoError());
    }

    @Test
    public void salidasAnticipadasRechazaUnaFechaNula() {
        ControladorReporte controlador = new ControladorReporte();
        assertTrue(controlador.listarSalidasAnticipadas(null).isEmpty());
        assertEquals("Debe ingresar una fecha válida.", controlador.getUltimoError());
    }

    @Test
    public void inasistenciasRechazaUnaFechaNula() {
        ControladorReporte controlador = new ControladorReporte();
        assertTrue(controlador.listarInasistencias(null).isEmpty());
        assertEquals("Debe ingresar una fecha válida.", controlador.getUltimoError());
    }
}
