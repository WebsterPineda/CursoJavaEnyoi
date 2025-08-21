package sv.com.webster.springwebflux.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import sv.com.webster.springwebflux.entity.Carro;
import sv.com.webster.springwebflux.repository.CarroRepository;

@ExtendWith(MockitoExtension.class)
class CarroServiceTest {
  @Mock
  CarroRepository carroRepository;

  @InjectMocks
  CarroService carroService;

  @Test
  void testFindByPersona() {
    Carro carro = new Carro();
    carro.setId(1L);
    carro.setMarca("Test");
    carro.setPersonaId(1);

    Carro carro2 = new Carro();
    carro2.setId(2L);
    carro2.setMarca("Car");
    carro2.setPersonaId(1);

    Mockito.when(carroRepository.findByPersonaId(Mockito.anyInt())).thenReturn(Flux.just(carro, carro2));

    StepVerifier.create(carroService.findByPersona(1)).expectNext(carro, carro2).verifyComplete();
  }
}
