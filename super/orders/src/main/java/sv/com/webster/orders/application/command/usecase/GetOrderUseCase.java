package sv.com.webster.orders.application.command.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import sv.com.webster.orders.domain.model.Order;
import sv.com.webster.orders.domain.ports.OrderRepository;

@RequiredArgsConstructor
public class GetOrderUseCase {
  private final OrderRepository orderRepository;

  public Order execute(UUID id) {
    return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("The order " + id + " does not exist."));
  }
}
