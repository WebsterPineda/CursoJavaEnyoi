package sv.com.webster.products.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sv.com.webster.products.entity.Product;
import sv.com.webster.products.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_NDJSON_VALUE)
  public Mono<Product> save(@RequestBody Product product) {
    return productService.saveProduct(product);
  }

  @PostMapping(value="/find/id", produces = MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<Product> findById(@RequestBody List<String> ids) {
    return productService.getProductsById(Flux.fromIterable(ids));
  }

  @GetMapping("/{id}")
  public Mono<Product> findById(@PathVariable String id) {
    return productService.getProductById(id);
  }
}
