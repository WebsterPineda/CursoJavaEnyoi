package sv.com.webster.orders.shared;

import java.util.UUID;

public interface OrderDetailData {
  UUID getId();
  String getProductId();
  Integer getQuantity();
}
