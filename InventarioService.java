package mx.tecmilenio.inventario;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InventarioService {

    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong secuencia = new AtomicLong();

    public InventarioService() {
        LocalDate hoy = LocalDate.now();

        agregar(new Producto(
                "Yogur natural",
                4,
                8,
                hoy.minusDays(1)
        ));

        agregar(new Producto(
                "Leche deslactosada",
                6,
                5,
                hoy.plusDays(4)
        ));

        agregar(new Producto(
                "Agua mineral",
                10,
                20,
                hoy.plusDays(30)
        ));
    }

    public synchronized Producto agregar(Producto producto) {
        Producto nuevo = new Producto(
                secuencia.incrementAndGet(),
                producto.getNombre().trim(),
                producto.getCantidadPiso(),
                producto.getCantidadBodega(),
                producto.getFechaCaducidad()
        );

        productos.add(nuevo);
        return nuevo;
    }

    public synchronized List<Producto> listar() {
        return productos.stream()
                .sorted(Comparator.comparing(Producto::getFechaCaducidad))
                .toList();
    }

    public synchronized void eliminar(Long id) {
        productos.removeIf(producto -> producto.getId().equals(id));
    }

    public synchronized int contarProductos() {
        return productos.size();
    }

    public synchronized int contarUnidades() {
        return productos.stream()
                .mapToInt(Producto::getCantidadTotal)
                .sum();
    }
}
