package sv.com.webster.orders.infrastructure.persistence;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.com.webster.orders.infrastructure.model.OrderEntity;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
  Optional<OrderEntity> findByClientId(String clientId);
}
