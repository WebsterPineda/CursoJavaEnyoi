package sv.com.webster.reactor;

import java.util.concurrent.CountDownLatch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DividerFlux {
  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(1);

    System.out.println("Impresion de valores con onErrorReturn");
    generateIntegerFlux()
      .map(num -> 10 / num)
      .onErrorReturn(-1)
      .subscribe(System.out::println);

    System.out.println("\n\nImpresion de valores con onErrorResume");
    generateIntegerFlux()
      .map(num -> 10 / num)
      .onErrorResume(e -> {
        System.out.println("Error: division by zero");
        return Mono.just(-1);
      })
      .subscribe(System.out::println,
        e -> {
          e.printStackTrace();
          latch.countDown();
        },
        latch::countDown);

    try {
      latch.await();
    } catch(InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static Flux<Integer> generateIntegerFlux() {
    return Flux.just(1, 2, 0, 4);
  }
}
