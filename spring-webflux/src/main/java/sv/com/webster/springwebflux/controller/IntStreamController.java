package sv.com.webster.springwebflux.controller;

import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/stream")
public class IntStreamController {
  @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<Integer> getStream() {
    return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1));
  }
}
