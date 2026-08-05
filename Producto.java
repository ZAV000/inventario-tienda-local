package mx.tecmilenio.inventario;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Producto {

    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio.")
    private String nombre;

    @Min(value = 0, message = "La cantidad en piso no puede ser negativa.")
    private int cantidadPiso;

    @Min(value = 0, message = "La cantidad en bodega no puede ser negativa.")
    private int cantidadBodega;

    @NotNull(message = "La fecha de caducidad es obligatoria.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaCaducidad;

    public Producto() {
    }

    public Producto(String nombre, int cantidadPiso, int cantidadBodega, LocalDate fechaCaducidad) {
        this(null, nombre, cantidadPiso, cantidadBodega, fechaCaducidad);
    }

    public Producto(Long id, String nombre, int cantidadPiso, int cantidadBodega,
                    LocalDate fechaCaducidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadPiso = cantidadPiso;
        this.cantidadBodega = cantidadBodega;
        this.fechaCaducidad = fechaCaducidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPiso() {
        return cantidadPiso;
    }

    public void setCantidadPiso(int cantidadPiso) {
        this.cantidadPiso = cantidadPiso;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCantidadTotal() {
        return cantidadPiso + cantidadBodega;
    }
}
