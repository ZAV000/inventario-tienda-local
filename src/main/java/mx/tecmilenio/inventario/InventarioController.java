package mx.tecmilenio.inventario;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class InventarioController {

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final InventarioService inventarioService;
    private final ServicioCaducidad servicioCaducidad;

    public InventarioController(
            InventarioService inventarioService,
            ServicioCaducidad servicioCaducidad
    ) {
        this.inventarioService = inventarioService;
        this.servicioCaducidad = servicioCaducidad;
    }

    @GetMapping("/")
    public String mostrarInventario(Model model) {
        if (!model.containsAttribute("producto")) {
            model.addAttribute("producto", new Producto());
        }

        cargarDatos(model);
        return "index";
    }

    @PostMapping("/productos")
    public String registrarProducto(
            @Valid @ModelAttribute("producto") Producto producto,
            BindingResult resultado,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (resultado.hasErrors()) {
            cargarDatos(model);
            return "index";
        }

        inventarioService.agregar(producto);
        redirectAttributes.addFlashAttribute(
                "mensaje",
                "Producto registrado correctamente."
        );

        return "redirect:/";
    }

    @PostMapping("/productos/{id}/eliminar")
    public String eliminarProducto(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {
        inventarioService.eliminar(id);
        redirectAttributes.addFlashAttribute(
                "mensaje",
                "Producto eliminado del inventario."
        );

        return "redirect:/";
    }

    private void cargarDatos(Model model) {
        LocalDate hoy = LocalDate.now();

        List<ProductoVista> productos = inventarioService.listar()
                .stream()
                .map(producto -> new ProductoVista(
                        producto,
                        servicioCaducidad.calcularEstado(
                                hoy,
                                producto.getFechaCaducidad()
                        ),
                        servicioCaducidad.calcularDiasRestantes(
                                hoy,
                                producto.getFechaCaducidad()
                        ),
                        producto.getFechaCaducidad().format(FORMATO_FECHA)
                ))
                .toList();

        long caducados = productos.stream()
                .filter(item -> item.estado() == EstadoCaducidad.ROJO)
                .count();

        long proximos = productos.stream()
                .filter(item -> item.estado() == EstadoCaducidad.AMARILLO)
                .count();

        long vigentes = productos.stream()
                .filter(item -> item.estado() == EstadoCaducidad.VERDE)
                .count();

        model.addAttribute("fechaActual", hoy.format(FORMATO_FECHA));
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", inventarioService.contarProductos());
        model.addAttribute("totalUnidades", inventarioService.contarUnidades());
        model.addAttribute("caducados", caducados);
        model.addAttribute("proximos", proximos);
        model.addAttribute("vigentes", vigentes);
    }
}
