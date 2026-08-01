package mx.tecmilenio.inventario;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {
    private final String nombre;
    private final int cantidadPiso;
    private final int cantidadBodega;
    private final LocalDate fechaCaducidad;

    public Producto(String nombre, int cantidadPiso, int cantidadBodega, LocalDate fechaCaducidad) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre es obligatorio");
        this.fechaCaducidad = Objects.requireNonNull(fechaCaducidad, "La fecha de caducidad es obligatoria");

        if (cantidadPiso < 0 || cantidadBodega < 0) {
            throw new IllegalArgumentException("Las cantidades no pueden ser negativas");
        }

        this.cantidadPiso = cantidadPiso;
        this.cantidadBodega = cantidadBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadPiso() {
        return cantidadPiso;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getCantidadTotal() {
        return cantidadPiso + cantidadBodega;
    }
}
