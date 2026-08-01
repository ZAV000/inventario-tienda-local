package mx.tecmilenio.inventario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCaducidadTest {

    private final ServicioCaducidad servicio = new ServicioCaducidad();
    private final LocalDate fechaActual = LocalDate.of(2026, 7, 31);

    @Test
    void debeMarcarRojoCuandoElProductoYaCaduco() {
        EstadoCaducidad resultado = servicio.calcularEstado(
                fechaActual,
                LocalDate.of(2026, 7, 30)
        );

        assertEquals(EstadoCaducidad.ROJO, resultado);
    }

    @Test
    void debeMarcarAmarilloCuandoFaltanSieteDiasOMenos() {
        EstadoCaducidad resultado = servicio.calcularEstado(
                fechaActual,
                LocalDate.of(2026, 8, 5)
        );

        assertEquals(EstadoCaducidad.AMARILLO, resultado);
    }

    @Test
    void debeMarcarVerdeCuandoFaltanMasDeSieteDias() {
        EstadoCaducidad resultado = servicio.calcularEstado(
                fechaActual,
                LocalDate.of(2026, 8, 20)
        );

        assertEquals(EstadoCaducidad.VERDE, resultado);
    }
}
