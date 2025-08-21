package sv.com.webster.reactor;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import reactor.core.publisher.Flux;

public class FruitFlux {

  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(1);
    generateFruitFlux().subscribe(fruit -> System.out.println(fruit + " [" + Instant.now() + "]"),
      err -> {
        System.err.println("Error: " + err);
        latch.countDown();
      },
      latch::countDown);

    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }

  private static Flux<String> generateFruitFlux() {
    return Flux.just("Mango", "Fresa", "Uva").delayElements(Duration.ofSeconds(1));
  }
}
