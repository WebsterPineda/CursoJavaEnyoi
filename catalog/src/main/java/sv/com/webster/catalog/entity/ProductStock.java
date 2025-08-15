package sv.com.webster.catalog.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCT_STOCK")
@Getter
@Setter
public class ProductStock {
  @Id
  private int id;
  @Column("product_id")
  private String productId;
  private Integer stock;
}
