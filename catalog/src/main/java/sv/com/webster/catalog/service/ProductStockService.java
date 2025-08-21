package sv.com.webster.catalog.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sv.com.webster.catalog.dto.ProductInfoDto;
import sv.com.webster.catalog.dto.ProductStockDto;
import sv.com.webster.catalog.entity.ProductStock;
import sv.com.webster.catalog.repository.ProductStockRepository;

@Service
@RequiredArgsConstructor
public class ProductStockService {
  private final ProductStockRepository productStockRepository;
  private final WebClient webClient = WebClient.create("http://localhost:8080");

  public Mono<ProductStock> createStock(ProductStock productStock) {
    return productStockRepository.save(productStock);
  }

  public Flux<ProductStockDto> getCatalogOfProductWithStock() {
    return productStockRepository.findByStockGreaterThanEqual(1)
      .flatMap(this::mergeProductInfo);
  }

  private Mono<ProductStockDto> mergeProductInfo(ProductStock stock) {
    return webClient.post()
      .uri("/api/v1/product/find/id")
      .bodyValue(List.of(stock.getProductId()))
      .retrieve()
      .bodyToMono(ProductInfoDto.class)
      .map(info -> mergeProductInfoWStock(stock, info));
  }

  private ProductStockDto mergeProductInfoWStock(ProductStock stock, ProductInfoDto info) {
    ProductStockDto dto = new ProductStockDto();
    dto.setId(info.getId());
    dto.setName(info.getName());
    dto.setDescription(info.getDescription());
    dto.setStock(stock.getStock());
    return dto;
  }
}
