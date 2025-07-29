package sv.com.webster.principal;

import sv.com.webster.interfaces.Saludador;

public class SaludadorImpl {
  public static void main(String[] args) {

    Saludador saludador = () -> System.out.println("Hola mundo!");

    saludador.saludar();
  }
}
