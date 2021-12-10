

package lpnu.service.impl;

        import lpnu.dto.IngridientDTO;
        import lpnu.entity.Ingridient;
        import lpnu.exception.ServiceException;
        import lpnu.mapper.IngridientToIngridientDTOMapper;
        import lpnu.repository.IngridientRepository;
        import lpnu.service.IngridientService;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class IngridientServiceImpl implements IngridientService {
    private final IngridientToIngridientDTOMapper ingridientMapper;
    private final IngridientRepository ingridientRepository;

    public IngridientServiceImpl(final IngridientToIngridientDTOMapper ingridientMapper, final IngridientRepository ingridientRepository) {
        this.ingridientMapper = ingridientMapper;
        this.ingridientRepository = ingridientRepository;
    }

    @Override
    public List<IngridientDTO> getAllIngridients() {
        return ingridientRepository.getAllIngridients().stream()
                .map(ingridientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IngridientDTO getIngridientById(final Long id) {
        return ingridientMapper.toDTO(ingridientRepository.getIngridientById(id));
    }

    @Override
    public void deleteIngridientById(final Long id) {
        ingridientRepository.deleteIngridientById(id);
    }

    @Override
    public IngridientDTO updateIngridient(final IngridientDTO ingridientDTO) {
        if (ingridientDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Ingridient ingridient = ingridientMapper.toEntity(ingridientDTO);
        return ingridientMapper.toDTO(ingridientRepository.updateIngridient(ingridient));
    }

    @Override
    public IngridientDTO saveIngridient(final IngridientDTO ingridientDTO) {
        if (ingridientDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (ingridientRepository.getAllIngridients().stream().anyMatch(ingridientMapper.toEntity(ingridientDTO)::equals)) {
            throw new ServiceException(400, "ingridient is already saved");
        }

        final Ingridient ingridient = ingridientMapper.toEntity(ingridientDTO);

        ingridientRepository.saveIngridient(ingridient);
        return ingridientMapper.toDTO(ingridient);
    }
}