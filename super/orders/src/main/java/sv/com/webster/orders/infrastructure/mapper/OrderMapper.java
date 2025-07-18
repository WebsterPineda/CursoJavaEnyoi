package sv.com.webster.orders.infrastructure.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sv.com.webster.orders.domain.model.Order;
import sv.com.webster.orders.infrastructure.model.OrderEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

  public static Order toDomain(OrderEntity orderEntity) {
    return new Order(orderEntity.getId(), orderEntity.getClientId(), orderEntity.getOrderDate());
  }

  public static OrderEntity toEntity(Order order) {
    return new OrderEntity(order.getId(), order.getClientId(), order.getOrderDate());
  }
}
