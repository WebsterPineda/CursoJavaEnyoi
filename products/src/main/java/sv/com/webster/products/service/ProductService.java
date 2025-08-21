package sv.com.webster.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sv.com.webster.products.entity.Product;
import sv.com.webster.products.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public Mono<Product> saveProduct(Product product) {
    return productRepository.save(product);
  }

  public Flux<Product> getProductsById(Flux<String> ids) {
    return productRepository.findAllById(ids);
  }

  public Mono<Product> getProductById(String id) {
    return productRepository.findById(id);
  }
}
