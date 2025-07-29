package sv.com.webster.interfaces;

public interface Convertidor<T, R> {
  R convertir(T x);
}
