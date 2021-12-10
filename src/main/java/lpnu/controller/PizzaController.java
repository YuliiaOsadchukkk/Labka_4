
package lpnu.controller;

        import lpnu.dto.PizzaDTO;
        import lpnu.service.PizzaService;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(final PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizzas")
    public ResponseEntity<List<PizzaDTO>> getAllPizzas() {
        return ResponseEntity.ok().body(pizzaService.getAllPizzas());
    }

    @GetMapping("/pizzas/{id}")
    public ResponseEntity<PizzaDTO> getPizzaById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(pizzaService.getPizzaById(id));
    }

    @PostMapping("/pizzas")
    public ResponseEntity<PizzaDTO> savePizza(@Validated @RequestBody final PizzaDTO pizzaDTO) {
        return ResponseEntity.ok().body(pizzaService.savePizza(pizzaDTO));
    }

    @PutMapping("/pizzas")
    public ResponseEntity<PizzaDTO> updatePizza(@Validated @RequestBody final PizzaDTO pizzaDTO) {
        return ResponseEntity.ok().body(pizzaService.updatePizza(pizzaDTO));
    }

    @DeleteMapping("/pizzas/{id}")
    public ResponseEntity deletePizzaById(@PathVariable final Long id) {
        pizzaService.deletePizzaById(id);
        return ResponseEntity.ok().build();
    }
}