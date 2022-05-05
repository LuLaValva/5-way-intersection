/**
 * @author Mathew Fiduk
 * @author Lucas LaValva
 * @author Matthew Rudderow
 * @author Alison Silvestri
 * @version 5/4/2022
 */
import java.util.HashMap;
import java.util.List;

public class Lane {
  private final double CAR_MOVE_LIKELIHOOD_PER_SECOND;

  private final HashMap<Street, Double> GOING_TO;
  private final double CARS_PER_SECOND;
  private int numCars;

  public Lane(double carsPerSecond, double leaveRate, List<Street> goingToStreets, List<Double> goingToLikelihoods) {
	CAR_MOVE_LIKELIHOOD_PER_SECOND = leaveRate;
    this.numCars = 0;
    this.CARS_PER_SECOND = carsPerSecond;

    // Populate Streets with likelihoods
    if (goingToStreets.size() != goingToLikelihoods.size())
      throw new Error("Streets and Likelihoods must be the same size");
    this.GOING_TO = new HashMap<>();
    for (int i = goingToStreets.size(); --i >= 0;) {
      GOING_TO.put(goingToStreets.get(i), goingToLikelihoods.get(i));
    }

  }

  public Street moveCarThrough() {
    if (numCars > 0) {
      numCars--;

      double currLikelihood = 0;
      double random = Math.random();

      for (Street item : GOING_TO.keySet()) {
        currLikelihood += GOING_TO.get(item);
        if (random < currLikelihood)
          return item;
      }
      // Should not ever get here due but might because of rounding errors
      return GOING_TO.keySet().iterator().next();
    } else {
      return null;
    }
  }

  public void addCarsForOneSecond() {
    if (Math.random() < CARS_PER_SECOND) {
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
