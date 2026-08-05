package mx.tecmilenio.inventario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCaducidadTest {

    private final ServicioCaducidad servicio = new ServicioCaducidad();
    private final LocalDate fechaActual = LocalDate.of(2026, 8, 5);

    @Test
    void debeMarcarRojoCuandoElProductoYaCaduco() {
        EstadoCaducidad resultado = servicio.calcularEstado(
                fechaActual,
                LocalDate.of(2026, 8, 4)
        );

        assertEquals(EstadoCaducidad.ROJO, resultado);
    }

    @Test
    void debeMarcarAmarilloCuandoFaltanSieteDiasOMenos() {
        EstadoCaducidad resultado = servicio.calcularEstado(
                fechaActual,
                LocalDate.of(2026, 8, 10)
        );

        assertEquals(EstadoCaducidad.AMARILLO, resultado);
    }

    @Test
    void debeMarcarAmarilloCuandoFaltanExactamenteSieteDias() {
        EstadoCaducidad resultado = servicio.calcularEstado(
                fechaActual,
                LocalDate.of(2026, 8, 12)
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
