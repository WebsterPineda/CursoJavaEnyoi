package sv.com.webster.propuesto03;

import java.util.List;
import java.util.stream.IntStream;

public class Utils {

  public static <T> void addOddElements(List<T> origen, List<T> destino) {
    IntStream.range(0, origen.size()).filter(i -> i % 2 != 0).mapToObj(origen::get).forEach(destino::add);
  }

  private Utils() {}
}
