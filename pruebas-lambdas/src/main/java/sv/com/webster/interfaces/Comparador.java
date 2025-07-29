package sv.com.webster.interfaces;

public interface Comparador<T> {
  /**
   * Realiza la comparacion de x respecto a y
   * @param x valor a evaluar
   * @param y valor esperado
   * @return true si la comparacion es exitosa, false en caso contrario
   */
  boolean comparar(T x, T y);
}
