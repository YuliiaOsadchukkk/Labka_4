
package lpnu.service;

import lpnu.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(final UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(final Long id);
    UserDTO updateUser(final UserDTO userDTO);
    void deleteUserById(final Long id);
}