
public class Light {
  static final int DURATION_BETWEEN_LIGHTS = 3;

  private final Street[] streets;
  final int duration;
  private int greenTimeLeft;

  public Light(int duration, Street[] streets) {
    this.duration = duration;
    this.streets = streets;
    greenTimeLeft = 0;
  }

  public void startGreenTime() {
    greenTimeLeft = duration;
  }

  public boolean advanceOneSecond() {
    for (Street street : streets) {
      street.enterCarsInOneSecond();
      if (greenTimeLeft > 0) {
        street.moveCarsThroughInOneSecond();
      }
    }
    if (greenTimeLeft > 0) {
      greenTimeLeft--;
      return greenTimeLeft == 0;
    }
    return false;
  }
}
