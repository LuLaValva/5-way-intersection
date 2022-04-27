import java.util.LinkedList;
import java.util.List;

public class Intersection {
  private final LinkedList<Light> lights;

  public Intersection(List<Light> lights) {
    this.lights = new LinkedList<>(lights);
  }

  public void advanceOneSecond() {
    for (Light light : lights) {
      light.advanceOneSecond();
    }
  }

  public void printCSVHeader() {
    StringBuilder str = new StringBuilder();
    for (Light light : lights) {
      for (String laneName : light.getLaneNames()) {
        str.append(laneName);
        str.append(", ");
      }
    }
    if (str.length() > 0) {
      // Remove trailing comma
      str.deleteCharAt(str.length() - 2);
    }
    System.out.println(str);
  }

  public void printCSVRow() {
    StringBuilder str = new StringBuilder();
    for (Light light : lights) {
      for (Integer capacity : light.getLaneCapacities()) {
        str.append(capacity);
        str.append(", ");
      }
      str.append(light.getLaneCapacities());
    }
    if (str.length() > 0) {
      // Remove trailing comma
      str.deleteCharAt(str.length() - 2);
    }
    System.out.println(str);
  }
}
