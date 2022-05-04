import java.util.HashMap;
import java.util.List;

public class Lane {
  private final double CAR_MOVE_LIKELIHOOD_PER_SECOND;

  final Street leavingFrom;
  private final HashMap<Street, Double> goingTo;
  private final double carsPerSecond;
  private int numCars;

  public Lane(Street leavingFrom, double carsPerSecond, double leaveRate, List<Street> goingToStreets, List<Double> goingToLikelihoods) {
	this.leavingFrom = leavingFrom;
	CAR_MOVE_LIKELIHOOD_PER_SECOND = leaveRate;
    this.numCars = 0;
    this.carsPerSecond = carsPerSecond;

    // Populate Streets with likelihoods
    if (goingToStreets.size() != goingToLikelihoods.size())
      throw new Error("Streets and Likelihoods must be the same size");
    this.goingTo = new HashMap<>();
    for (int i = goingToStreets.size(); --i >= 0;) {
      goingTo.put(goingToStreets.get(i), goingToLikelihoods.get(i));
    }

  }

  public Street moveCarThrough() {
    if (numCars > 0) {
      numCars--;

      double currLikelihood = 0;
      double random = Math.random();

      for (Street item : goingTo.keySet()) {
        currLikelihood += goingTo.get(item);
        if (random < currLikelihood)
          return item;
      }
      // Should not ever get here due but might because of rounding errors
      return goingTo.keySet().iterator().next();
    } else {
      return null;
    }
  }

  public void addCarsForOneSecond() {
    if (Math.random() < carsPerSecond) {
      numCars++;
    }
  }

  public Street moveCarsThroughInOneSecond() {
    if (Math.random() < CAR_MOVE_LIKELIHOOD_PER_SECOND) {
      return moveCarThrough();
    } else {
      return null;
    }
  }

  public void addOneCar() {
    numCars++;
  }

  public void balkCar() {
    if (numCars > 0) {
      numCars--;
    }
  }

  public int getNumCars() {
    return numCars;
  }
}
