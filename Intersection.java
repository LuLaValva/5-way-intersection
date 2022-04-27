import java.util.LinkedList;
import java.util.List;

public class Intersection {
  private final LinkedList<Light> lights;

  public Intersection(List<Light> lights) {
    this.lights = new LinkedList<>(lights);
    if (lights.size() > 0) {
      lights.get(0).startGreenTime();
    }
  }

  public void advanceOneSecond() {
    for (int i = 0; i < lights.size(); i++) {
      if (lights.get(i).advanceOneSecond()) {
        lights.get((i + 1) % lights.size()).startGreenTime();
      }
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
    }
    if (str.length() > 0) {
      // Remove trailing comma
      str.deleteCharAt(str.length() - 2);
    }
    System.out.println(str);
  }
}
