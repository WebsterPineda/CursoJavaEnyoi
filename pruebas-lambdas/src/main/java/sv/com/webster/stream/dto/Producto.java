package sv.com.webster.stream.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
  private String nombre;
  private double precio;

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;

    if (!(o instanceof Producto)) return false;

    return ((Producto) o).getNombre().equals(this.getNombre());
  }

  @Override
  public int hashCode() {
    return nombre.hashCode();
  }
}
