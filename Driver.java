import java.util.*;

public class Driver {
  public static void main(String[] args) {
    Intersection intersection = createModel();

		intersection.printCSVHeader();
		for (int i=0; i < 1000; i++) {
			intersection.advanceOneSecond();
			intersection.printCSVRow();
		}
  }
  
  public static Intersection createModel() {
	  Street gboro = new Street("Glassboro");
	  Street north = new Street("North");
	  Street south = new Street("South");
	  Street sickler = new Street("Sicklerville");
	  Street clayton = new Street("Clayton");
 	  
	  gboro.addLane(0.066, 0.422, Arrays.asList(sickler,south),Arrays.asList(0.476190476,0.437229437));
	  gboro.addLane(0.01, 0.04, Arrays.asList(north,clayton),Arrays.asList(0.034632035,0.051948052));
	  north.addLane(0.033, 0.13325, Arrays.asList(sickler),Arrays.asList(0.357541899));
	  north.addLane(0.051, 0.23958, Arrays.asList(gboro,clayton,south),Arrays.asList(0.089385475,0.1620111730,0.391061453));
	  south.addLane(0.032, 0.13611, Arrays.asList(clayton,gboro),Arrays.asList(0.151898734,0.261603376));
	  south.addLane(0.05, 0.19306, Arrays.asList(north,sickler),Arrays.asList(0.493670886,0.092827004));
	  sickler.addLane(0.016, 0.059, Arrays.asList(south),Arrays.asList(0.218518519));
	  sickler.addLane(0.051, 0.211, Arrays.asList(clayton, gboro, north),Arrays.asList(0.407407407,0.244444444,0.12962963));
	  clayton.addLane(0.024, 0.07384, Arrays.asList(gboro,north),Arrays.asList(0.030973451,0.181415929));
	  clayton.addLane(0.072, 0.27384, Arrays.asList(sickler,south),Arrays.asList(0.623893805,0.163716814));
	  
	  Street[] ns = {north, south};
	  Street[] sc = {sickler, clayton};
	  Street[] g = {gboro};
	  Light northSouth = new Light(40, ns);
	  Light sicklerClayton = new Light(50,sc);
	  Light glassBoro = new Light(25,g);
	  return new Intersection(Arrays.asList(northSouth, sicklerClayton, glassBoro));
  }
}