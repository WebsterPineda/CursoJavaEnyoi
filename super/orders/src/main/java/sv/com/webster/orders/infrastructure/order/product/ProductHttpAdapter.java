package sv.com.webster.orders.infrastructure.order.product;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sv.com.webster.orders.domain.model.Product;
import sv.com.webster.orders.domain.ports.ProductService;

@Component
@RequiredArgsConstructor
public class ProductHttpAdapter implements ProductService {
  private static final String BASE_URL = "http://localhost:8082/api/v1/products/";
  private final RestTemplate restTemplate;


  @Override
  public Optional<Product> findByName(String name) {
    String url = BASE_URL + "/{name}";

    try {
      ResponseEntity<ProductResponseDTO> response = restTemplate.getForEntity(url, ProductResponseDTO.class, name);

      ProductResponseDTO responseDTO = response.getBody();
      return (responseDTO != null) ? Optional.of(new Product(responseDTO.getId())) : Optional.empty();
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  @Override
  public void sell(String id, @NonNull ProductSellRequestDto sellDto) {
    String url = BASE_URL + "/{id}";

    try {
      restTemplate.put(url, sellDto, id);
    } catch (Exception e) {
      // ignored
    }
  }
}
