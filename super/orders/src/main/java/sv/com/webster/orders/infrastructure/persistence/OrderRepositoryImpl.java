package sv.com.webster.orders.infrastructure.persistence;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sv.com.webster.orders.domain.model.Order;
import sv.com.webster.orders.domain.ports.OrderRepository;
import sv.com.webster.orders.infrastructure.mapper.OrderMapper;
import sv.com.webster.orders.infrastructure.model.OrderEntity;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
  private final OrderJpaRepository orderJpaRepository;

  @Override
  public Order save(Order order) {
    OrderEntity entity = OrderMapper.toEntity(order);
    OrderEntity saved = orderJpaRepository.save(entity);

    return OrderMapper.toDomain(saved);
  }

  @Override
  public Optional<Order> findById(UUID id) {
    return orderJpaRepository.findById(id).map(OrderMapper::toDomain);
  }

  @Override
  public Optional<Order> findByClientId(String clientId) {
    return orderJpaRepository.findByClientId(clientId).map(OrderMapper::toDomain);
  }
}
