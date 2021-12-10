
package lpnu.service.impl;

        import lpnu.dto.UserDTO;
        import lpnu.entity.User;
        import lpnu.exception.ServiceException;
        import lpnu.mapper.UserToUserDTOMapper;
        import lpnu.repository.UserRepository;
        import lpnu.service.UserService;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserToUserDTOMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(final UserToUserDTOMapper userMapper, final UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(final Long id) {
        return userMapper.toDTO(userRepository.getUserById(id));
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        return userMapper.toDTO(userRepository.updateUser(userMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO saveUser(final UserDTO userDTO) {
        if (userDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        final User user = userMapper.toEntity(userDTO);
        if (userRepository.getAllUsers().stream().anyMatch(userMapper.toEntity(userDTO)::equals)) {
            throw new ServiceException(400, "user is already saved");
        }

        userRepository.saveUser(user);
        return userMapper.toDTO(user);
    }
}