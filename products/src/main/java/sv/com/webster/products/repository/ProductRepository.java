package sv.com.webster.products.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import sv.com.webster.products.entity.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
  Flux<Product> findAllById(String id);
}
