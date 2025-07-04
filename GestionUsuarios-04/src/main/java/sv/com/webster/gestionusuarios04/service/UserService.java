package sv.com.webster.gestionusuarios04.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sv.com.webster.gestionusuarios04.model.User;
import sv.com.webster.gestionusuarios04.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public User saveUser(User user) {
    return repository.save(user);
  }

  public List<User> getAllUsers () {
    return repository.findAll();
  }
}
