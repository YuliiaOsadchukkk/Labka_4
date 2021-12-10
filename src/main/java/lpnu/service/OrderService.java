package lpnu.service;

        import lpnu.dto.OrderDTO;

        import java.util.List;

public interface OrderService {
    OrderDTO saveOrder(final OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(final Long id);
    OrderDTO updateOrder(final OrderDTO orderDTO);
    void deleteOrderById(final Long id);
}