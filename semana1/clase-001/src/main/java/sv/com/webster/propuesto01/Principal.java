package sv.com.webster.propuesto01;

import java.util.Arrays;
import java.util.List;

public class Principal {

  public static void main(String[] args) {
    List<String> valores = Arrays.asList("a", "b", "c");

    PilaCompleta<String> pila = new PilaCompleta<>();
    pila.pushAll(valores);

    System.out.println(pila.size());

    pila.popAll();
    System.out.println(pila.empty());
  }
}
