import java.util.LinkedList;
import java.util.List;

public class Street {
  private LinkedList<Lane> lanes;
  final String name;

  public Street(String name) {
    this.name = name;
  }

  public Lane addLane(double carsPerSecond, List<Street> goingToStreets, List<Double> goingToLikelihoods) {
    Lane newLane = new Lane(this, carsPerSecond, goingToStreets, goingToLikelihoods);
    lanes.add(newLane);
    return newLane;
  }

  public LinkedList<Lane> getLanes() {
    return lanes;
  }

  public void enterCarsInOneSecond() {
    for (final Lane lane : lanes) {
      lane.addCarsForOneSecond();
    }
  }

  public List<Street> moveCarsThroughInOneSecond() {
    final List<Street> wentTo = new LinkedList<>();
    for (Lane lane : lanes) {
      final Street exitStreet = lane.moveCarsThroughInOneSecond();
      if (exitStreet != null)
        wentTo.add(exitStreet);
    }
    return wentTo;
  }
}
