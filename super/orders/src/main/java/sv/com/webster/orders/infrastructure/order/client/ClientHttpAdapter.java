package sv.com.webster.orders.infrastructure.order.client;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sv.com.webster.orders.domain.model.Client;
import sv.com.webster.orders.domain.ports.ClientService;

@RequiredArgsConstructor
@Component
public class ClientHttpAdapter implements ClientService {
  private final RestTemplate restTemplate;

  @Override
  public Optional<Client> findByEmail(String email) {
    String url = "http://localhost:8081/api/v1/client/{email}";

    try {
      ResponseEntity<ClientResponseDTO> response = restTemplate.getForEntity(url, ClientResponseDTO.class, email);

      ClientResponseDTO responseDTO = response.getBody();
      return (responseDTO != null) ? Optional.of(new Client(responseDTO.getId())) : Optional.empty();
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
