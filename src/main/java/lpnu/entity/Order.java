package lpnu.entity;

        import java.util.Objects;

public class Order {
    private Long id;
    private Pizza pizza;
 //   private int totalprice;

    public Order(){

    }

    public Order(final Long id, final Pizza pizza) {
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

    public void setPizza(final Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return Objects.equals(pizza, that.pizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizza);
    }
}