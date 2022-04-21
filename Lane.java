import java.util.HashMap;
import java.util.List;

public class Lane {
  final Street leavingFrom;
  private final HashMap<Street, Double> goingTo;
  private final double carsPerSecond;
  private int numCars;

  public Lane(Street leavingFrom, double carsPerSecond, List<Street> goingToStreets, List<Double> goingToLikelihoods) {
    this.leavingFrom = leavingFrom;
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

  public void addCars(int numCars) {
    this.numCars += numCars;
  }
}
