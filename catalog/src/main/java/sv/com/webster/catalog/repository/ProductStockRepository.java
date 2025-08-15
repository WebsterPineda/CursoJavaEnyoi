package sv.com.webster.catalog.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import sv.com.webster.catalog.entity.ProductStock;

public interface ProductStockRepository extends R2dbcRepository<ProductStock,String> {
  Flux<ProductStock> findByStockGreaterThanEqual(Integer stock);
}
