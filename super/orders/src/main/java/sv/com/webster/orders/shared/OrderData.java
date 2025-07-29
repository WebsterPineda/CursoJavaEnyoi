package sv.com.webster.orders.shared;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface OrderData {
  UUID getId();

  String getClientId();

  LocalDateTime getOrderDate();

  List<OrderDetailData> getDetails();
}
