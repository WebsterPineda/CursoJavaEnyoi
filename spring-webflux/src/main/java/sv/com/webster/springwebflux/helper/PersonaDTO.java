package sv.com.webster.springwebflux.helper;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.com.webster.springwebflux.entity.Carro;
import sv.com.webster.springwebflux.entity.Persona;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaDTO {
  private Persona persona;
  private List<Carro> carros;
}
