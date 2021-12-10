
package lpnu.service.impl;

        import lpnu.dto.PizzaDTO;
        import lpnu.entity.Pizza;
        import lpnu.exception.ServiceException;
        import lpnu.mapper.PizzaToPizzaDTOMapper;
        import lpnu.repository.PizzaRepository;
        import lpnu.service.PizzaService;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaToPizzaDTOMapper pizzaMapper;

    public PizzaServiceImpl(final PizzaRepository pizzaRepository, final PizzaToPizzaDTOMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    @Override
    public List<PizzaDTO> getAllPizzas() {
        return pizzaRepository.getAllPizzas().stream()
                .map(pizzaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PizzaDTO getPizzaById(final Long id) {
        return pizzaMapper.toDTO(pizzaRepository.getPizzaById(id));
    }

    @Override
    public void deletePizzaById(final Long id) {
        pizzaRepository.deletePizzaById(id);
    }

    @Override
    public PizzaDTO updatePizza(final PizzaDTO pizzaDTO) {
        if (pizzaDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Pizza pizza = pizzaMapper.toEntity(pizzaDTO);
        return pizzaMapper.toDTO(pizzaRepository.updatePizza(pizza));
    }

    @Override
    public PizzaDTO savePizza(final PizzaDTO pizzaDTO) {
        if (pizzaDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (pizzaRepository.getAllPizzas().stream().anyMatch(pizzaMapper.toEntity(pizzaDTO)::equals)) {
            throw new ServiceException(400, "pizza is already saved");
        }

        final Pizza pizza = pizzaMapper.toEntity(pizzaDTO);

        pizzaRepository.savePizza(pizza);
        return pizzaMapper.toDTO(pizza);
    }
}