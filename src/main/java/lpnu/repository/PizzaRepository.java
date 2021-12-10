
package lpnu.repository;

        import lpnu.entity.Ingridient;
        import lpnu.entity.Pizza;
        import lpnu.exception.ServiceException;
        import org.springframework.stereotype.Repository;

        import java.util.ArrayList;
        import java.util.List;

@Repository
public class PizzaRepository {
    private final List<Pizza> pizzas = new ArrayList<>();
    private long id = 1;

    public List<Pizza> getAllPizzas() {
        return new ArrayList<>(pizzas);
    }

/*
    public Pizza addIngridient(final Ingridient ingrid, final Long id) {
        final Pizza pizza = getPizzaById(id);

        if (pizza.getIngridient().stream().anyMatch(ingrid::equals)) {
            throw new ServiceException(400, "there is already such ingridient");
        } else {
            pizza.getIngridient().add(pizza);
        }
        return pizza;
    }*/

    public void deletePizzaById(final Long id) {
        for (final Pizza pizza : pizzas) {
            if (pizza.getId().equals(id)) {
                pizzas.remove(pizza);
                break;
            }
        }
    }

    public Pizza updatePizza(final Pizza pizza) {
        final Pizza savedPizza = getPizzaById(pizza.getId());

        savedPizza.setIngridient(pizza.getIngridient());
        savedPizza.setPizzaTotalPrice(pizza.getPizzaTotalPrice());


        return savedPizza;
    }

    public void savePizza(final Pizza pizza) {
        pizza.setId(id);
        ++id;
        pizzas.add(pizza);
    }

    public Pizza getPizzaById(final Long id) {
        return pizzas.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "pizza with id " + id + " not found"));
    }


}