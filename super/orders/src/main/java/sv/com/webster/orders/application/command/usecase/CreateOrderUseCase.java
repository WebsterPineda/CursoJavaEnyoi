package sv.com.webster.orders.application.command.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import sv.com.webster.orders.application.command.CreateOrderCommand;
import sv.com.webster.orders.domain.model.Client;
import sv.com.webster.orders.domain.model.Order;
import sv.com.webster.orders.domain.ports.ClientService;
import sv.com.webster.orders.domain.ports.OrderRepository;

@RequiredArgsConstructor
public class CreateOrderUseCase {

  private final ClientService clientService;
  private final OrderRepository orderRepository;

  public Order execute(CreateOrderCommand input) {
    String email = input.clientEmail();
    Client client = clientService.findByEmail(email).orElseThrow(() -> new RuntimeException("client not found"));

    Order order = new Order(UUID.randomUUID(), client.getId(),input.orderDetails());
    return orderRepository.save(order);
  }
}
