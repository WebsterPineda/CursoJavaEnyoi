package sv.com.webster.springwebflux.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sv.com.webster.springwebflux.entity.Persona;
import sv.com.webster.springwebflux.helper.PersonaDTO;
import sv.com.webster.springwebflux.repository.CarroRepository;
import sv.com.webster.springwebflux.repository.PersonaRepository;

@Service
@RequiredArgsConstructor
public class PersonaService {
  private final PersonaRepository personaRepository;
  private final CarroService carroService;

  public Mono<Persona> save(Persona persona) {
    return personaRepository.save(persona);
  }

  public Flux<Persona> savePersonas(Flux<Persona> personas) {
    return personaRepository.saveAll(personas);
  }

  public Flux<PersonaDTO> findByEdad(Mono<Integer> edad) {
    return personaRepository.findByEdad(edad)
      .flatMap(persona -> carroService.findByPersona(persona.getId()).collectList().map(carro -> new PersonaDTO(persona, carro)));
  }

  public Flux<PersonaDTO> findByNombre(Flux<String> nombre) {
    return nombre.flatMap(name -> personaRepository.findByNombre(Mono.just(name)))
      .flatMap(persona -> carroService.findByPersona(persona.getId()).collectList().map(carro -> new PersonaDTO(persona, carro)));
  }
}
