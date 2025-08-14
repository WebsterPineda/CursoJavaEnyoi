package sv.com.webster.springwebflux.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CARROS")
@Getter
@Setter
public class Carro {
  @Id
  private Long id;
  private String marca;
  private Integer personaId;
}
