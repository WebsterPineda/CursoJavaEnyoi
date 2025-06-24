package sv.com.webster.propuesto02;

import java.util.HashMap;
import java.util.Objects;

public class LocalHashMap<K, V> extends HashMap<K, V> {

  @Override
  public V put(K key, V value) {
    if (Objects.isNull(value)) {
      return null;
    }

    return super.put(key, value);
  }
}
