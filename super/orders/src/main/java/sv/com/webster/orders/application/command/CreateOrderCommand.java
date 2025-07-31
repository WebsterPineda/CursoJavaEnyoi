package sv.com.webster.orders.application.command;

import java.util.List;
import sv.com.webster.orders.domain.model.OrderDetail;

public record CreateOrderCommand(String clientEmail, List<ProductDetailCommand> orderDetails) {
  public boolean hasDetails() {
    return orderDetails != null && !orderDetails.isEmpty();
  }
}
