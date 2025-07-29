package sv.com.webster.stream;

import java.util.Arrays;
import java.util.List;

public class ConversorNombre {
  public static void main(String[] args) {
    List<String> listaNombres = Arrays.asList("Juan", "Ana", "Mario", "Rocio", "Oscar");

    List<String> nombresFiltrados = listaNombres.stream().filter(nombre -> nombre.length() > 4).map(String::toUpperCase).toList();

    nombresFiltrados.forEach(System.out::println);
  }
}
