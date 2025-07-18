package sv.com.webster.orders.interfaces.controller;

import java.net.URI;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.com.webster.orders.application.command.CreateOrderCommand;
import sv.com.webster.orders.application.command.usecase.CreateOrderUseCase;
import sv.com.webster.orders.application.command.usecase.GetOrderUseCase;
import sv.com.webster.orders.domain.model.Order;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
  private final CreateOrderUseCase createOrderUseCase;
  private final GetOrderUseCase getOrderUseCase;

  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrder(@PathVariable("id") UUID id) {
    try {
      return ResponseEntity.ok(getOrderUseCase.execute(id));
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Order> create(@RequestBody CreateOrderDTO orderDto) {
    Order order = createOrderUseCase.execute(new CreateOrderCommand(orderDto.clientEmail()));

    return ResponseEntity.created(URI.create("/api/v1/order/" + order.getId())).body(order);
  }
}
