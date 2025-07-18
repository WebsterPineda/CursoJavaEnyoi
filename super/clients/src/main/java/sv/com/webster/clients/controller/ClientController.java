package sv.com.webster.clients.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.com.webster.clients.dto.SaveNewClientDTO;
import sv.com.webster.clients.model.Client;
import sv.com.webster.clients.service.ClientService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/client")
public class ClientController {
  private final ClientService clientService;

  @GetMapping("/{email}")
  public Client getClientByEmail(@PathVariable("email") String email) {
    return clientService.getClientByEmail(email);
  }

  @PostMapping
  public Client saveClient(@RequestBody SaveNewClientDTO newClientDTO) {
    return clientService.save(newClientDTO);
  }
}
