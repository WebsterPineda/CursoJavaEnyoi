package sv.com.webster.stream;

import java.util.ArrayList;
import java.util.List;
import sv.com.webster.stream.dto.Persona;

public class PromedioEdades {

  public static void main(String[] args) {
    List<Persona> personas = new ArrayList<>();
    personas.add(new Persona("Juan", 15));
    personas.add(new Persona("Jose", 25));
    personas.add(new Persona("Oscar", 50));
    personas.add(new Persona("Roberto", 10));

    double edadPromedio = personas.stream().filter(p -> p.getEdad() > 17).mapToInt(Persona::getEdad).average().orElse(0);
    System.out.println(edadPromedio);
  }
}
