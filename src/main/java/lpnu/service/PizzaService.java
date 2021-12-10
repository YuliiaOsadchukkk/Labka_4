
package lpnu.service;

        import lpnu.dto.PizzaDTO;

        import java.util.List;

public interface PizzaService {
    PizzaDTO savePizza(final PizzaDTO pizzaDTO);
    List<PizzaDTO> getAllPizzas();
    PizzaDTO getPizzaById(final Long id);
    PizzaDTO updatePizza(final PizzaDTO pizzaDTO);
    void deletePizzaById(final Long id);
}