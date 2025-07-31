package sv.com.webster.principal;

import sv.com.webster.interfaces.Convertidor;

public class ConvertidorImpl {
  public static void main(String[] args) {
    Convertidor<String, Integer> convertidor = String::length;

    String texto = "Hola mundo!";

    System.out.println("La variable \"" +  texto + "\" tiene una longitud de: " + convertidor.convertir(texto) + " caracteres");
  }
}
