package mx.tecmilenio.inventario;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
public class ServicioCaducidad {

    public EstadoCaducidad calcularEstado(LocalDate fechaActual, LocalDate fechaCaducidad) {
        long diasRestantes = calcularDiasRestantes(fechaActual, fechaCaducidad);

        if (diasRestantes < 0) {
            return EstadoCaducidad.ROJO;
        }

        if (diasRestantes <= 7) {
            return EstadoCaducidad.AMARILLO;
        }

        return EstadoCaducidad.VERDE;
    }

    public long calcularDiasRestantes(LocalDate fechaActual, LocalDate fechaCaducidad) {
        Objects.requireNonNull(fechaActual, "La fecha actual es obligatoria.");
        Objects.requireNonNull(fechaCaducidad, "La fecha de caducidad es obligatoria.");

        return ChronoUnit.DAYS.between(fechaActual, fechaCaducidad);
    }
}
