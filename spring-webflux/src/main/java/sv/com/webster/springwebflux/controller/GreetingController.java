package sv.com.webster.springwebflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/greet")
public class GreetingController {
  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Mono<String> greeting() {
    return Mono.just("Hola mundo!");
  }
}
