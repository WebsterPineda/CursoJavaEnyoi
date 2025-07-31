package sv.com.webster.dto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventario {
  private String productId;
  private int stock;
  private final ReentrantLock lock = new ReentrantLock();
  private final Condition hasStock = lock.newCondition();

  public void sell(int cantidad) {
    lock.lock();
    while(stock - cantidad < 0) {
      System.out.println("No hay stock para la venta");
      try {
        hasStock.await();
      } catch (InterruptedException e) {}
    }

    stock -= cantidad;
    System.out.println("Venta efectuada: " + cantidad + ", nuevo stock: " + stock);
    lock.unlock();
  }

  public void buy(int cantidad) {
    lock.lock();

    try {
      stock += cantidad;
      System.out.println("Se ha abastecido con " + cantidad + " productos, stock: " + stock);
      hasStock.signalAll();
    } finally {
      lock.unlock();
    }
  }
}
