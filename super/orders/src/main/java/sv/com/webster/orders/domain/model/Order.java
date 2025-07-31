package sv.com.webster.orders.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Order {
  private final UUID id;
  private final String clientId;
  private final LocalDateTime orderDate;
  private final List<OrderDetail> details;

  public Order(UUID id, String clientId) {
    this.id = id;
    this.clientId = clientId;
    this.orderDate = LocalDateTime.now();
    this.details = new ArrayList<>();
  }

  public Order(UUID id, String clientId, List<OrderDetail> details) {
    this.id = id;
    this.clientId = clientId;
    this.orderDate = LocalDateTime.now();
    this.details = details;
  }
}
