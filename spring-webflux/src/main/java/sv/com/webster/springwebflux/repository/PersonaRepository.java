package sv.com.webster.springwebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sv.com.webster.springwebflux.entity.Persona;

public interface PersonaRepository extends ReactiveCrudRepository<Persona, Integer> {
  Flux<Persona> findByEdad(Mono<Integer> edad);
  Flux<Persona> findByNombre(Mono<String> nombre);
}
