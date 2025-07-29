package sv.com.webster.orders.domain.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sv.com.webster.orders.shared.OrderDetailData;

@RequiredArgsConstructor
@Getter
public class OrderDetail implements OrderDetailData {
  private final UUID id;
  private final String productId;
  private final Integer quantity;
}
