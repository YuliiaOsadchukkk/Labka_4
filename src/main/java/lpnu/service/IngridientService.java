

package lpnu.service;

        import lpnu.dto.IngridientDTO;

        import java.util.List;

public interface IngridientService {
    IngridientDTO saveIngridient(final IngridientDTO ingridientDTO);
    List<IngridientDTO> getAllIngridients();
    IngridientDTO getIngridientById(final Long id);
    IngridientDTO updateIngridient(final IngridientDTO ingridientDTO);
    void deleteIngridientById(final Long id);
}