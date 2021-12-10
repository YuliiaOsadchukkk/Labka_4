
package lpnu.mapper;

        import lpnu.dto.PizzaDTO;
        import lpnu.entity.Pizza;
        import org.springframework.stereotype.Component;

@Component
public class PizzaToPizzaDTOMapper {
    public Pizza toEntity(final PizzaDTO pizzaDTO){
        return new Pizza(
                pizzaDTO.getId(),
                pizzaDTO.getIngridient(),
                pizzaDTO.getPizzaTotalPrice()
        );
    }
    public PizzaDTO toDTO(final Pizza pizza){
        return new PizzaDTO(
                pizza.getId(),
                pizza.getIngridient(),
                pizza.getPizzaTotalPrice()
        );
    }
}