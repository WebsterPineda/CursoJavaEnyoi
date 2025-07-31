package sv.com.webster.orders.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sv.com.webster.orders.application.command.usecase.CreateOrderUseCase;
import sv.com.webster.orders.application.command.usecase.GetOrderUseCase;
import sv.com.webster.orders.domain.ports.ClientService;
import sv.com.webster.orders.domain.ports.OrderRepository;

@Configuration
public class ApplicationBeanConfig {

  @Bean
  public CreateOrderUseCase createOrderUseCase(OrderRepository repository, ClientService clientService) {
    return new CreateOrderUseCase(clientService, repository);
  }

  @Bean
  public GetOrderUseCase getOrderUseCase(OrderRepository repository) {
    return new GetOrderUseCase(repository);
  }
}
