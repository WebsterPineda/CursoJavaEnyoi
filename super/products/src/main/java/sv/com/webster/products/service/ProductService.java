package sv.com.webster.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.com.webster.products.model.Product;
import sv.com.webster.products.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public Product saveNewProduct(String name) {
    Product newProduct = new Product();
    newProduct.setName(name);
    newProduct.setStock(100);

    return productRepository.save(newProduct);
  }

  public Product getProductByName(String name) {
    return productRepository.findByName(name);
  }

  public Product updateStock(String id, Integer quantitySold) {
    Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " does not exist."));

    product.setStock(product.getStock() - quantitySold);
    return productRepository.save(product);
  }
}
