
package lpnu.entity;

        import lpnu.Price.PriceDef;
        import lpnu.dto.IngridientDTO;
        import lpnu.exception.ServiceException;

        import javax.validation.constraints.NotBlank;
        import java.util.Objects;
        import java.util.stream.DoubleStream;


public class Ingridient {
    private Long id;

    @NotBlank
    private String ingridient;

    @NotBlank
    private double price;

    public Ingridient(){

    }

    public Ingridient(final Long id, final double price, final String ingridient) {
        this.id = id;
        this.price = price;
        this.ingridient = ingridient;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngridient() {
        return ingridient;
    }

    public void setIngridient(String ingridient) {
        this.ingridient = ingridient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingridient i = (Ingridient) o;
        return Objects.equals(ingridient, i.ingridient) && price == this.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingridient, price);
    }


}