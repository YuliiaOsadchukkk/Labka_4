
package lpnu.controller;

        import lpnu.dto.UserDTO;
        import lpnu.service.UserService;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable final Long id) {

   // final User user1 = new User

        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> saveUser(@Validated @RequestBody final UserDTO userDTO) {
        return  ResponseEntity.ok().body(userService.saveUser(userDTO));
    }

    @PutMapping("/users")
    public ResponseEntity<UserDTO> updateUser(@Validated @RequestBody final UserDTO userDTO) {
        return  ResponseEntity.ok().body(userService.updateUser(userDTO));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUserById(@PathVariable final Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}