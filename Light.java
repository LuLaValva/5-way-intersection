
public class Light {
  static final int DURATION_BETWEEN_LIGHTS = 3;

  private final Street[] streets;
  final int duration;

  public Light(int duration, Street[] streets) {
    this.duration = duration;
    this.streets = streets;
  }

  public void runLight() {

  }
}
