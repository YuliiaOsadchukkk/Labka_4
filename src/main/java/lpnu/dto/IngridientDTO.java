
package lpnu.dto;

        import javax.validation.constraints.NotBlank;
        import java.util.Objects;

public class IngridientDTO {
    private Long id;

    @NotBlank
    private String ingridient;

    @NotBlank
    private double price;

    public IngridientDTO(){

    }

    public IngridientDTO(final Long id, final double price, final String ingridient) {
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
        IngridientDTO i = (IngridientDTO) o;
        return Objects.equals(ingridient, i.ingridient) && price == this.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingridient, price);
    }
}