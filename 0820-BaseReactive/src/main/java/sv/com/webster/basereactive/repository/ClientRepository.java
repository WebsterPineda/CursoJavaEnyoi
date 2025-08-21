package sv.com.webster.basereactive.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import sv.com.webster.basereactive.model.Client;

public interface ClientRepository extends R2dbcRepository<Client, Integer> {
}
