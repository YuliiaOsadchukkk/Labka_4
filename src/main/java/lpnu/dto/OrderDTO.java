
package lpnu.dto;

        import lpnu.entity.Pizza;

        import java.util.Objects;

public class OrderDTO {
    private Long id;
    private Pizza pizza;

    private OrderDTO(){

    }

    public OrderDTO(final Long id, final Pizza pizza) {
        this.id = id;
        this.pizza = pizza;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO that = (OrderDTO) o;
        return Objects.equals(pizza, that.pizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizza);
    }
}