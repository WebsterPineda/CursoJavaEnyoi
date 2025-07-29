package sv.com.webster.principal;

import sv.com.webster.interfaces.Operador;

public class OperadorImpl {
  public static void main(String[] args) {
    Operador operador = Integer::sum;

    System.out.println("La suma de 10 y 2 es: " + operador.operar(10, 2));
  }
}
