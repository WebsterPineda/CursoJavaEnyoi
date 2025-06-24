package sv.com.webster.propuesto02;

import java.util.Map;

public class Principal {

  public static void main(String[] args) {
    Map<String, String> mapa = new LocalHashMap<>();

    mapa.put("key1", null);
    mapa.put("key2", "value");

    if (mapa.size() != 1) {
      throw new IllegalStateException("No funcionó la prevencion de ingreso de valores null");
    }
  }
}
