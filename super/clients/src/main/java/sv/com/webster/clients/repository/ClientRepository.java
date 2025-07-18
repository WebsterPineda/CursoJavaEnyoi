package sv.com.webster.clients.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sv.com.webster.clients.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
  Client findByEmail(String email);
}
