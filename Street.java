/**
 * @author Mathew Fiduk
 * @author Lucas LaValva
 * @author Matthew Rudderow
 * @author Alison Silvestri
 * @version 5/4/2022
 */
import java.util.LinkedList;
import java.util.List;

public class Street {
  private static final double JOCKEY_PROBABILITY = 0.001;

  private LinkedList<Lane> lanes;
  private final String NAME;

  public Street(String name) {
    this.NAME = name;
    lanes = new LinkedList<>();
  }

  public Lane addLane(double carsPerSecond, double leaveRate, List<Street> goingToStreets, List<Double> goingToLikelihoods) {
    Lane newLane = new Lane(carsPerSecond, leaveRate, goingToStreets, goingToLikelihoods);
    lanes.add(newLane);
    return newLane;
  }

  public LinkedList<Lane> getLanes() {
    return lanes;
  }
  
  public String getName() {
	  return NAME;
  }

  public void enterCarsInOneSecond() {
    for (final Lane lane : lanes) {
      lane.addCarsForOneSecond();
    }
  }

  public void doJockey() {
    int laneFrom = (int)(Math.random() * lanes.size());
    int laneTo;
    do {
      laneTo = (int)(Math.random() * lanes.size());
    } while (laneTo == laneFrom);
    lanes.get(laneFrom).jockeyCar();
    lanes.get(laneTo).addOneCar();
  }

  public List<Street> moveCarsThroughInOneSecond() {
    final List<Street> wentTo = new LinkedList<>();
    for (Lane lane : lanes) {
      final Street exitStreet = lane.moveCarsThroughInOneSecond();
      if (exitStreet != null)
        wentTo.add(exitStreet);
      if (Math.random() < JOCKEY_PROBABILITY)
        doJockey();
    }
    return wentTo;
  }
}
