package sv.com.webster.principal;

import sv.com.webster.interfaces.Comparador;

public class ComparadorImpl {
  public static void main(String[] args) {
    Comparador<Integer> comparador = (x, y) -> y * 2 == x;

    int valor1 = 10;
    int valor2 = 5;

    System.out.println("Es " + valor1 + " el doble de " + valor2 + "? " + comparador.comparar(valor1, valor2));
  }
}
