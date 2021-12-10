package lpnu.mapper;

import lpnu.dto.UserDTO;
import lpnu.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOMapper {
    public User toEntity(final UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getEmail(),
                userDTO.getOrderDTOList());
    }
    public UserDTO toDTO(final User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getOrderDTOList());
    }
}