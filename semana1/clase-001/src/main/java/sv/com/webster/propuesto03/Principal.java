package sv.com.webster.propuesto03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
  public static void main(String[] args) {
    List<String> lista = Arrays.asList("a", "b", "c", "d", "e");
    List<String> lista1 = new ArrayList<>();

    Utils.addOddElements(lista, lista1);

    if (lista1.size() != 2) {
      throw new IllegalStateException("Algo salio mal con la extraccion de elementos impares");
    }

    for (String s : lista1) {
      System.out.println(s);
    }
  }
}
