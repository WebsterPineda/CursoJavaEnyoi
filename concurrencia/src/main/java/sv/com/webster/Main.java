package sv.com.webster;

import sv.com.webster.dto.Inventario;

public class Main {
  public static void main(String[] args) {
    Inventario inventario = new Inventario();
    inventario.setProductId("ProductoA");

    Thread vendedor1 = new Thread(() -> inventario.sell(15));
    Thread vendedor2 = new Thread(() -> inventario.sell(50));

    Thread comprador1 = new Thread(() -> inventario.buy(100));
    Thread comprador2 = new Thread(() -> inventario.buy(5));

    vendedor1.start();
    vendedor2.start();
    comprador1.start();
    comprador2.start();

    System.out.println("Finalizado hilo principal");
  }
}
