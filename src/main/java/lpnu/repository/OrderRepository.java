package lpnu.repository;


        import lpnu.entity.Order;
        import lpnu.exception.ServiceException;
        import org.springframework.stereotype.Repository;

        import java.util.ArrayList;
        import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();
    private long id = 1;

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public void deleteOrderById(final Long id) {
        for (final Order order : orders) {
            if (order.getId().equals(id)) {
                orders.remove(order);
                break;
            }
        }
    }

    public Order updateOrder(final Order order) {
        final Order savedOrder = getOrderById(order.getId());

        savedOrder.setPizza(order.getPizza());
     //   savedOrder.setPrice(order.getPrice());

        return savedOrder;
    }

    public void savedOrder(final Order order) {
        order.setId(id);
        ++id;
        orders.add(order);
    }

    public Order getOrderById(final Long id) {
        return orders.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "order with id " + id + " not found"));
    }
}