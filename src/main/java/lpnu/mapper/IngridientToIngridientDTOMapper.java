
package lpnu.mapper;

        import lpnu.dto.IngridientDTO;
        import lpnu.entity.Ingridient;
        import org.springframework.stereotype.Component;

@Component
public class IngridientToIngridientDTOMapper {
    public Ingridient toEntity(final IngridientDTO ingridientDTO) {
        return new Ingridient(
                ingridientDTO.getId(),
                ingridientDTO.getPrice(),
                ingridientDTO.getIngridient());
    }

    public IngridientDTO toDTO(final Ingridient ingridient) {
        return new IngridientDTO(
                ingridient.getId(),
                ingridient.getPrice(),
                ingridient.getIngridient());
    }
}