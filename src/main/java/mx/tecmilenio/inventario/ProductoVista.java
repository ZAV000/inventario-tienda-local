package mx.tecmilenio.inventario;

public record ProductoVista(
        Producto producto,
        EstadoCaducidad estado,
        long diasRestantes,
        String fechaCaducidadFormateada
) {
}
