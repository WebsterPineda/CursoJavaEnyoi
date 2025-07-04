package sv.com.webster.gestionusuarios04.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.com.webster.gestionusuarios04.model.User;
import sv.com.webster.gestionusuarios04.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping
  public ResponseEntity<User> saveUser(@RequestBody User userRequest) {
    User usrResponse = userService.saveUser(userRequest);
    return new ResponseEntity<>(usrResponse, HttpStatus.CREATED);
  }
  
  @GetMapping
  public ResponseEntity<List<User>> getUsers () {
    List<User> userList = userService.getAllUsers();
    return new ResponseEntity<>(userList, HttpStatus.OK);
  }
}
