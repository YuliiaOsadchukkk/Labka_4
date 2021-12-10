
package lpnu.dto;

        import lpnu.entity.Ingridient;

        import java.util.Objects;

public class PizzaDTO {
    private Long id;
    private Ingridient ingridient;
    private double pizzaTotalPrice;


    private PizzaDTO(){

    }

    public PizzaDTO(final Long id, final Ingridient ingridient, final double pizzaTotalPrice) {
        this.id = id;
        this.ingridient = ingridient;
        this.pizzaTotalPrice = pizzaTotalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Ingridient getIngridient() {
        return ingridient;
    }

    public void setIngridient(Ingridient ingridient) {
        this.ingridient = ingridient;
    }

    public double getPizzaTotalPrice() {
        return pizzaTotalPrice;
    }

    public void setPizzaTotalPrice(double pizzaTotalPrice) {
        this.pizzaTotalPrice = pizzaTotalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaDTO that = (PizzaDTO) o;
        return Objects.equals(ingridient, that.ingridient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingridient);
    }
}