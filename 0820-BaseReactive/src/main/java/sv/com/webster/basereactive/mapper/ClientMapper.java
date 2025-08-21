package sv.com.webster.basereactive.mapper;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import sv.com.webster.basereactive.dto.ClientResponseDto;
import sv.com.webster.basereactive.model.Client;

@Component
public class ClientMapper {
  /**
   * Maps clients model to clients DTO
   * @param clients list of data from db
   * @return clients converted as dto
   */
  public Flux<ClientResponseDto> mapClientsByModel(Flux<Client> clients) {
    return clients.map(this::mapClientByModel);
  }

  /**
   * Mapper from Client Model to Client DTO
   * @param client model received from database
   * @return dto with the info from model
   */
  public ClientResponseDto mapClientByModel(Client client) {
    ClientResponseDto clientResponseDto = new ClientResponseDto();

    clientResponseDto.setId(client.getId());
    clientResponseDto.setName(client.getName());
    clientResponseDto.setEmail(client.getEmail());
    return clientResponseDto;
  }
}
