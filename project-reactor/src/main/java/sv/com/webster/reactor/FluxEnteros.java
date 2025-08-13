package sv.com.webster.reactor;

import reactor.core.publisher.Flux;

public class FluxEnteros {
  public static void main(String[] args) {
    generateFlux()
      .filter(i -> i % 2 == 0)
      .map(num -> num * 10)
      .subscribe(System.out::println);
  }

  private static Flux<Integer> generateFlux() {
    return Flux.range(1, 5);
  }
}
