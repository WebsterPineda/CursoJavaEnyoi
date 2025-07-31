package sv.com.webster.products.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.com.webster.products.dto.SaveNewProductDto;
import sv.com.webster.products.dto.UpdateProductDto;
import sv.com.webster.products.model.Product;
import sv.com.webster.products.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping
  public ResponseEntity<Product> saveNewProduct(@RequestBody SaveNewProductDto dto) {
    Product product = productService.saveNewProduct(dto.getName());
    return ResponseEntity.created(URI.create("/api/v1/product/" + product.getName())).body(product);
  }

  @GetMapping("/{name}")
  public ResponseEntity<Product> getProduct(@PathVariable("name") String name) {
    Product response = productService.getProductByName(name);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody UpdateProductDto dto) {
    Product response = productService.updateStock(id, dto.getQuantity());

    return ResponseEntity.ok(response);
  }
}
