// import java.util.List;

// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.http.ResponseEntity;





// @RestController
// @RequestMapping("/api/users")
// @Tag(name = "Users", description = "User management APIs")
// @RequiredArgsConstructor
// public class UserController {

//     private final UserService userService;

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody User user) {
//         return ResponseEntity.ok(userService.registerUser(user));
//     }

//     @GetMapping("/all")
//     public ResponseEntity<List<User>> getAll() {
//         return ResponseEntity.ok(userService.getAllUsers());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<User> getById(@PathVariable Long id) {
//         return ResponseEntity.ok(userService.getUser(id));
//     }
// }
