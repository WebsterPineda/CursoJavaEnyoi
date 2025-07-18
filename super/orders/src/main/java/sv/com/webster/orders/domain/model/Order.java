package sv.com.webster.orders.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sv.com.webster.orders.shared.OrderData;

@Getter
@RequiredArgsConstructor
public class Order implements OrderData {
  private final UUID id;
  private final String clientId;
  private final LocalDateTime orderDate;

  public Order(UUID id, String clientId) {
    this.id = id;
    this.clientId = clientId;
    this.orderDate = LocalDateTime.now();
  }
}
