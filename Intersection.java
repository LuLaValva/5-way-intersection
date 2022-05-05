/**
 * @author Mathew Fiduk
 * @author Lucas LaValva
 * @author Matthew Rudderow
 * @author Alison Silvestri
 * @version 5/4/2022
 */
import java.util.LinkedList;
import java.util.List;

public class Intersection {
  private final LinkedList<Light> LIGHTS;

  public Intersection(List<Light> lights) {
    this.LIGHTS = new LinkedList<>(lights);
    if (LIGHTS.size() > 0) {
      LIGHTS.get(0).startGreenTime();
    }
  }

  public void advanceOneSecond() {
    for (int i = 0; i < LIGHTS.size(); i++) {
      if (LIGHTS.get(i).advanceOneSecond()) {
        LIGHTS.get((i + 1) % LIGHTS.size()).startGreenTime();
      }
    }
  }

  public void printCSVHeader() {
    StringBuilder str = new StringBuilder();
    for (Light light : LIGHTS) {
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
    for (Light light : LIGHTS) {
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
