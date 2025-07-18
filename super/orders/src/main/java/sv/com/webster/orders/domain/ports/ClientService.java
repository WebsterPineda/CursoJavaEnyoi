package sv.com.webster.orders.domain.ports;

import java.util.Optional;
import sv.com.webster.orders.domain.model.Client;

public interface ClientService {
  Optional<Client> findByEmail(String email);
}
