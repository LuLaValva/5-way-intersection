import java.util.LinkedList;
import java.util.List;

public class Intersection {
  private final LinkedList<Light> lights;

  public Intersection(List<Light> lights) {
    this.lights = new LinkedList<>(lights);
  }

  public void advanceOneSecond() {
    for (int i = 0; i < lights.size(); i++) {
      if (lights.get(i).advanceOneSecond()) {
        lights.get((i + 1) % lights.size()).startGreenTime();
      }
    }
  }
}
