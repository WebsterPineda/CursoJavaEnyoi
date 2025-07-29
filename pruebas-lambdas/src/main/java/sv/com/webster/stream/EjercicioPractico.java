package sv.com.webster.stream;

import java.util.List;

public class EjercicioPractico {
  public static void main(String[] args) {
    List<Integer> lista = List.of(5, 7, 12, 25, 30);

    int suma = lista.stream().reduce(0, Integer::sum);
    System.out.println(suma);
  }
}
