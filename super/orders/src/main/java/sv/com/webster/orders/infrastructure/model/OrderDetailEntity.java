package sv.com.webster.orders.infrastructure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.com.webster.orders.shared.OrderDetailData;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity implements OrderDetailData {
  @Id
  private UUID id;
  private String productId;
  private Integer quantity;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderEntity order;
}
