package sv.com.webster.springwebflux.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import sv.com.webster.springwebflux.entity.Carro;
import sv.com.webster.springwebflux.repository.CarroRepository;

@Service
@RequiredArgsConstructor
public class CarroService {
  private final CarroRepository carroRepository;

  public Flux<Carro> findByPersona(Integer id) {
    return carroRepository.findByPersonaId(id);
  }
}
