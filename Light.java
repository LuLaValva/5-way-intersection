/**
 * @author Mathew Fiduk
 * @author Lucas LaValva
 * @author Matthew Rudderow
 * @author Alison Silvestri
 * @version 5/4/2022
 */
import java.util.LinkedList;
import java.util.List;

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

  public List<String> getLaneNames() {
    List<String> laneNames = new LinkedList<>();
    for (Street street : streets) {
      for (int i = 1, numLanes = street.getLanes().size(); i <= numLanes; i++) {
        laneNames.add(street.getName() + "_" + i);
      }
    }
    return laneNames;
  }

  public List<Integer> getLaneCapacities() {
    List<Integer> laneCapacities = new LinkedList<>();
    for (Street street : streets) {
      for (Lane lane : street.getLanes()) {
        laneCapacities.add(lane.getNumCars());
      }
    }
    return laneCapacities;
  }
}
