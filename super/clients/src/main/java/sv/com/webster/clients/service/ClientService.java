package sv.com.webster.clients.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.com.webster.clients.dto.SaveNewClientDTO;
import sv.com.webster.clients.model.Client;
import sv.com.webster.clients.repository.ClientRepository;

@RequiredArgsConstructor
@Service
public class ClientService {
  private final ClientRepository repository;

  public Client save(SaveNewClientDTO dto) {
    Client client = mapDtoToClient(dto);
    return repository.save(client);
  }

  public Client getClientByEmail(String email) {
    return repository.findByEmail(email);
  }

  public Client mapDtoToClient(SaveNewClientDTO dto) {
    Client client = new Client();
    client.setEmail(dto.getEmail());
    client.setName(dto.getName());

    return client;
  }
}
