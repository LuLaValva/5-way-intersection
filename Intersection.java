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
}
