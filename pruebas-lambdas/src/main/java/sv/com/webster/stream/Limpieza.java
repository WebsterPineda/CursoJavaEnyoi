package sv.com.webster.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sv.com.webster.stream.dto.Producto;

public class Limpieza {
  public static void main(String[] args) {
    List<Producto> productos = poblarLista();

    Set<Producto> registrados = new HashSet<>();

    System.out.println("Lista de productos inicial: ");
    productos.stream()
      .filter(registrados::add)
      .forEach(producto -> System.out.println("Producto " + producto.getNombre() + ", precio: " + Math.floor(producto.getPrecio())));

    System.out.println("\n\nLista de productos con stream distinct");
    // Forma 2
    productos.stream()
      .distinct()
      .map(Producto::getPrecio)
      .forEach(precio -> System.out.println("precio: " + Math.floor(precio)));
  }

  public static List<Producto> poblarLista() {
    List<Producto> productos = new ArrayList<>();
    productos.add(new Producto("Leche", 5.256));
    productos.add(new Producto("Huevos", 15));
    productos.add(new Producto("Leche", 5));

    return productos;
  }
}
