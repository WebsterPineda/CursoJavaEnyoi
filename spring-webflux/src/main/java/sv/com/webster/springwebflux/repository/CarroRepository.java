package sv.com.webster.springwebflux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import sv.com.webster.springwebflux.entity.Carro;

public interface CarroRepository extends R2dbcRepository<Carro, Long> {
  Flux<Carro> findByPersonaId(Integer id);
}
