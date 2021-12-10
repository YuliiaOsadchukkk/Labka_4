
package lpnu.repository;

        import lpnu.Price.PriceDef;
        import lpnu.entity.Ingridient;
        import lpnu.exception.ServiceException;
        import org.springframework.stereotype.Repository;

        import java.util.ArrayList;
        import java.util.List;

@Repository
public class IngridientRepository {
    private final List<Ingridient> ingridients = new ArrayList<>();
    private long id = 1;

    public List<Ingridient> getAllIngridients() {
        return new ArrayList<>(ingridients);
    }

    public void deleteIngridientById(final Long id) {
        for (final Ingridient ingridient : ingridients) {
            if (ingridient.getId().equals(id)) {
                ingridients.remove(ingridient);
                break;
            }
        }
    }

    public Ingridient updateIngridient(final Ingridient ingridient) {
        final Ingridient savedIngridient = getIngridientById(ingridient.getId());

        savedIngridient.setIngridient(ingridient.getIngridient());
        savedIngridient.setPrice(ingridient.getPrice());

        return savedIngridient;
    }

    public void saveIngridient(final Ingridient ingridient) {
        ingridient.setId(id);
        ++id;
        ingridients.add(ingridient);
    }

    public Ingridient getIngridientById(final Long id) {
        return ingridients.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "ingridient with id " + id + " not found"));
    }



    public Ingridient calculateAndUpdatePrice(final Ingridient ingridient){
        double price = -1;
        for(final PriceDef ingrid: PriceDef.values()){
            if(ingrid.getName().equals(ingridient.getIngridient())){
                price = ingrid.getPrice();
            }
        }

        if(price == -1){
            throw new ServiceException(400, "enum doesn't contain " + ingridient.getIngridient() + " ingridient");
        }

        ingridient.setPrice(price);
        return ingridient;
    }
}