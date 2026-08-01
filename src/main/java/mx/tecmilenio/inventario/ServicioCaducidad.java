package mx.tecmilenio.inventario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ServicioCaducidad {

    public EstadoCaducidad calcularEstado(LocalDate fechaActual, LocalDate fechaCaducidad) {
        Objects.requireNonNull(fechaActual, "La fecha actual es obligatoria");
        Objects.requireNonNull(fechaCaducidad, "La fecha de caducidad es obligatoria");

        long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaCaducidad);

        if (diasRestantes < 0) {
            return EstadoCaducidad.ROJO;
        }

        if (diasRestantes <= 7) {
            return EstadoCaducidad.AMARILLO;
        }

        return EstadoCaducidad.VERDE;
    }
}
