package sv.com.webster.orders.infrastructure.mapper;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import sv.com.webster.orders.domain.model.OrderDetail;
import sv.com.webster.orders.infrastructure.model.OrderDetailEntity;
import sv.com.webster.orders.infrastructure.model.OrderEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDetailMapper {

  public static OrderDetail toDomain(OrderDetailEntity orderDetailEntity) {
    if (orderDetailEntity == null) {
      throw new IllegalArgumentException("orderDetailEntity is null");
    }

    return new OrderDetail(orderDetailEntity.getId(), orderDetailEntity.getProductId(), orderDetailEntity.getQuantity());
  }

  public static OrderDetailEntity toEntity(OrderDetail orderDetail, OrderEntity orderRef) {
    if (orderDetail == null) {
      throw new IllegalArgumentException("orderDetail is null");
    }

    return new OrderDetailEntity(orderDetail.getId(), orderDetail.getProductId(), orderDetail.getQuantity(), orderRef);
  }

  public static List<OrderDetailEntity> toEntities(List<OrderDetail> orderDetails, OrderEntity orderRef) {
    if (orderDetails == null) {
      throw new IllegalArgumentException("orderDetails is null");
    }

    if (orderRef == null) {
      throw new IllegalArgumentException("orderRef is null");
    }

    return orderDetails.stream().map(od -> toEntity(od, orderRef)).toList();
  }

  public static List<OrderDetail> toDomainList(List<OrderDetailEntity> orderDetails) {
    if (orderDetails == null) {
      throw new IllegalArgumentException("orderDetails is null");
    }

    return orderDetails.stream().map(OrderDetailMapper::toDomain).toList();
  }
}
