package sv.com.webster.reactor;

import reactor.core.publisher.Mono;

public class Impresor {
  public static void main(String[] args) {
    generateString().map(str -> str.concat(" desde Project Reactor")).subscribe(System.out::println);
  }

  private static Mono<String> generateString() {
    return Mono.just("Hola, mundo reactivo");
  }
}
