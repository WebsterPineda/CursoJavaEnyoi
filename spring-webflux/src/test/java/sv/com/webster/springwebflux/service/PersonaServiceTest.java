package sv.com.webster.springwebflux.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import sv.com.webster.springwebflux.entity.Persona;
import sv.com.webster.springwebflux.repository.PersonaRepository;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {
  @Mock
  PersonaRepository personaRepository;
  @Mock
  CarroService carroService;
  @InjectMocks
  PersonaService personaService;

  @Test
  void testSave() {
    Persona persona = new Persona();

    Mockito.when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(Mono.just(persona));

    StepVerifier.create(personaService.save(persona)).expectNext(persona).verifyComplete();

    Mockito.verify(personaRepository).save(Mockito.any(Persona.class));
  }

  @Test
  void testSavePersonas() {
    Persona persona = new Persona();
    Persona persona2 = new Persona();
    Mockito.when(personaRepository.saveAll(Mockito.<Flux<Persona>>any())).thenReturn(Flux.just(persona, persona2));

    StepVerifier.create(personaService.savePersonas(Flux.just(persona, persona2))).expectNext(persona, persona2).verifyComplete();
    Mockito.verify(personaRepository).saveAll(Mockito.<Flux<Persona>>any());
  }

  @Test
  void testFindByEdad() {
    Persona persona = new Persona();
    persona.setId(1);
    persona.setEdad(10);
    persona.setNombre("Test");
    
    Mockito.when(personaRepository.findByEdad(Mockito.any())).thenReturn(Flux.just(persona));
    Mockito.when(carroService.findByPersona(1)).thenReturn(Flux.empty());

    StepVerifier.create(personaService.findByEdad(Mono.just(10)))
      .expectNextMatches(dto -> dto.getPersona().equals(persona) && dto.getCarros().isEmpty()).verifyComplete();

    Mockito.verify(personaRepository).findByEdad(Mockito.any());
    Mockito.verify(carroService).findByPersona(Mockito.any());
  }
}
