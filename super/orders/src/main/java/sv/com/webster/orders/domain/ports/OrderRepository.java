package sv.com.webster.orders.domain.ports;

import java.util.Optional;
import java.util.UUID;
import sv.com.webster.orders.domain.model.Order;

public interface OrderRepository {
  Order save(Order order);
  Optional<Order> findById(UUID id);
  Optional<Order> findByClientId(String clientId);
}
