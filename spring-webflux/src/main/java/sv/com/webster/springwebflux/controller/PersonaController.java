package sv.com.webster.springwebflux.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sv.com.webster.springwebflux.entity.Persona;
import sv.com.webster.springwebflux.helper.PersonaDTO;
import sv.com.webster.springwebflux.service.PersonaService;

@RestController
@RequestMapping("/api/v1/persona")
@RequiredArgsConstructor
public class PersonaController {
  private final PersonaService personaService;

  @PostMapping
  public Mono<Persona> save(@RequestBody Persona persona) {
    return personaService.save(persona);
  }

  @PostMapping(value = "/all", produces = MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<Persona> savePersonas(@RequestBody Flux<Persona> personas) {
    return personaService.savePersonas(personas);
  }

  @GetMapping(value = "/edad/{edad}", produces =  MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<PersonaDTO> findByEdad(@PathVariable Integer edad) {
    return personaService.findByEdad(Mono.just(edad));
  }

  @PostMapping(value = "/byname", produces =  MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<PersonaDTO> findByNombre(@RequestBody List<String> name) {
    return personaService.findByNombre(Flux.fromIterable(name));
  }
}
