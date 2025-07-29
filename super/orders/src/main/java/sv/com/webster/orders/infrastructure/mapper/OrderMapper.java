package sv.com.webster.orders.infrastructure.mapper;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sv.com.webster.orders.domain.model.Order;
import sv.com.webster.orders.domain.model.OrderDetail;
import sv.com.webster.orders.infrastructure.model.OrderDetailEntity;
import sv.com.webster.orders.infrastructure.model.OrderEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

  public static Order toDomain(OrderEntity orderEntity) {
    List<OrderDetail> details = OrderDetailMapper.toDomainList(orderEntity.getDetails());
    return new Order(orderEntity.getId(), orderEntity.getClientId(), details);
  }

  public static OrderEntity toEntity(Order order) {
    OrderEntity orderEntity = new OrderEntity(order.getId(), order.getClientId(), order.getOrderDate());

    List<OrderDetailEntity> details = OrderDetailMapper.toEntities(order.getDetails(), orderEntity);
    orderEntity.setDetails(details);
    return orderEntity;
  }
}
