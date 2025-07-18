package sv.com.webster.orders.infrastructure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sv.com.webster.orders.shared.OrderData;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity implements OrderData {
  @Id
  private UUID id;
  private String clientId;
  private LocalDateTime orderDate;
}
