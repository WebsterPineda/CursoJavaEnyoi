package sv.com.webster.springwebflux.controller;

import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Integer> test() {
    return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1));
  }

  @PostMapping(value = "/flux-input", produces = MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<Integer> testFluxInput(@RequestBody Flux<Integer> input) {
    return input.map(n -> n * 2);
  }
}
