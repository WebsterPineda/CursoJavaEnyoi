package sv.com.webster.orders.domain.ports;

import java.util.Optional;
import sv.com.webster.orders.domain.model.Product;
import sv.com.webster.orders.infrastructure.order.product.ProductSellRequestDto;

public interface ProductService {
  Optional<Product> findByName(String name);

  void sell(String id, ProductSellRequestDto sellDto);
}
