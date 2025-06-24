package sv.com.webster.propuesto01;

import java.util.Collection;
import java.util.Stack;

public class PilaCompleta<T> extends Stack<T> {

  /**
   * Agrega todos los items de una collection a la pila
   * @param items Collection de la cual se obtendran los objetos
   */
  public void pushAll(Collection<? extends T> items) {
    if (!items.isEmpty()) {
      this.addAll(items);
    }
  }

  /**
   * Elimina todos los items de la pila
   */
  public synchronized void popAll() {
    this.clear();
  }
}
