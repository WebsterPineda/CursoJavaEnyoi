package sv.com.webster.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sv.com.webster.products.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
  Product findByName(String name);
}
