package sv.com.webster.basereactive.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CLIENTS")
@Getter
@Setter
public class Client {
  @Id
  private Integer id;
  private String name;
  private Integer age;
  private String email;
}
