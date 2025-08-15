package sv.com.webster.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sv.com.webster.catalog.dto.ProductStockDto;
import sv.com.webster.catalog.entity.ProductStock;
import sv.com.webster.catalog.service.ProductStockService;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class ProductStockController {
  private final ProductStockService productStockService;

  @PostMapping
  public Mono<ProductStock> create(@RequestBody ProductStock productStock) {
    return productStockService.createStock(productStock);
  }

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<ProductStockDto> findAll() {
    return productStockService.getCatalogOfProductWithStock();
  }
}
