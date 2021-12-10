

package lpnu.service.impl;

        import lpnu.dto.OrderDTO;
        import lpnu.entity.Order;
        import lpnu.exception.ServiceException;
        import lpnu.mapper.OrderToOrderDTOMapper;
        import lpnu.repository.OrderRepository;
        import lpnu.service.OrderService;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderToOrderDTOMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(final OrderToOrderDTOMapper orderMapper, final OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(final Long id) {
        return orderMapper.toDTO(orderRepository.getOrderById(id));
    }

    @Override
    public void deleteOrderById(final Long id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public OrderDTO updateOrder(final OrderDTO orderDTO) {
        if (orderDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Order order = orderMapper.toEntity(orderDTO);
        return orderMapper.toDTO(orderRepository.updateOrder(order));
    }

    @Override
    public OrderDTO saveOrder(final OrderDTO orderDTO) {
        if (orderDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (orderRepository.getAllOrders().stream().anyMatch(orderMapper.toEntity(orderDTO)::equals)) {
            throw new ServiceException(400, "order is already saved");
        }

        final Order order = orderMapper.toEntity(orderDTO);

        orderRepository.savedOrder(order);
        return orderMapper.toDTO(order);
    }
}