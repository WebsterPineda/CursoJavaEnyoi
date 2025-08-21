package sv.com.webster.basereactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import sv.com.webster.basereactive.dto.ClientResponseDto;
import sv.com.webster.basereactive.mapper.ClientMapper;
import sv.com.webster.basereactive.model.Client;
import sv.com.webster.basereactive.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {
  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper;

  /**
   * Obtains the list of clients registered in database
   * @return flux of clients registered in db
   */
  public Flux<ClientResponseDto> listClients() {
    return clientMapper.mapClientsByModel(clientRepository.findAll());
  }

  public Flux<Client> saveClients(Flux<Client> clients) {
    return clientRepository.saveAll(clients);
  }
}
