package sv.com.webster.reactor;

import reactor.core.publisher.Flux;

public class FluxCombiner {
  public static void main(String[] args) {
    System.out.println("Combinaciones zipWith:");
    generateStringFlux()
      .zipWith(generateIntegerFlux(), (str, num) -> str + "-" + num)
      .subscribe(System.out::println);

    System.out.println();
    System.out.println("Combinaciones concat:");
    generateStringFlux()
      .concatWith(generateIntegerFlux().map(String::valueOf))
      .subscribe(System.out::println);
  }

  private static Flux<String> generateStringFlux() {
    return Flux.just("A", "B", "C");
  }

  private static Flux<Integer> generateIntegerFlux() {
    return Flux.range(1, 3);
  }
}
