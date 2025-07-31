package sv.com.webster.orders.infrastructure.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
  @Id
  private UUID id;
  private String clientId;
  private LocalDateTime orderDate;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderDetailEntity> details;

  public OrderEntity(UUID id, String clientId, LocalDateTime orderDate) {
    this.id = id;
    this.clientId = clientId;
    this.orderDate = orderDate;
    details = new ArrayList<>();
  }
}
