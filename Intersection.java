import java.util.LinkedList;
import java.util.List;

public class Intersection {
  private final LinkedList<Lane> lanes;

  public Intersection(List<Lane> lanes) {
    this.lanes = new LinkedList<>(lanes);
  }
}
