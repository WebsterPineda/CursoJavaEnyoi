package sv.com.webster.basereactive.controller;

import java.time.Duration;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import sv.com.webster.basereactive.dto.ClientResponseDto;
import sv.com.webster.basereactive.model.Client;
import sv.com.webster.basereactive.service.ClientService;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
class ClientController {
  private final ClientService clientService;
  private final Random rnd = new Random();

  @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<ClientResponseDto> listClients() {
    return clientService.listClients().delayElements(Duration.ofMillis(rnd.nextLong(501)));
  }

  @PostMapping(consumes = MediaType.APPLICATION_NDJSON_VALUE, produces = MediaType.APPLICATION_NDJSON_VALUE)
  public Flux<Client> registerStream(@RequestBody Flux<Client> clients) {
    return clientService.saveClients(clients).delayElements(Duration.ofMillis(rnd.nextLong(1000)));
  }
}
