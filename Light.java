
public class Light {
  static final int DURATION_BETWEEN_LIGHTS = 3;

  private final Street[] streets;
  final int duration;
  private boolean isGreen;

  public Light(int duration, Street[] streets) {
    this.duration = duration;
    this.streets = streets;
    isGreen = false;
  }

  public void advanceOneSecond() {
    for (Street street : streets) {
      street.enterCarsInOneSecond();
      if (isGreen) {
        street.moveCarsThroughInOneSecond();
      }
    }
  }
}
