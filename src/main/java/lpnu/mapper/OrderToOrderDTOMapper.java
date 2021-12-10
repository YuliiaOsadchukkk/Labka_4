package lpnu.mapper;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderDTOMapper {
    public Order toEntity(final OrderDTO orderDTO){
        return new Order(
                orderDTO.getId(),
                orderDTO.getPizza()
               );
    }
    public OrderDTO toDTO(final Order order){
        return new OrderDTO(
                order.getId(),
                order.getPizza()
                );
    }
}