import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
	
    List<Light> lights = createModel();
  }
  
  public static List<Light> createModel() {
	  Street gboro = new Street("Glassboro");
	  Street north = new Street("North");
	  Street south = new Street("South");
	  Street sickler = new Street("Sicklerville");
	  Street clayton = new Street("Clayton");
 	  
	  gboro.addLane(Arrays.asList(sickler,south),Arrays.asList(0.476190476,0.437229437));
	  gboro.addLane(Arrays.asList(north,clayton),Arrays.asList(0.034632035,0.051948052));
	  north.addLane(Arrays.asList(sickler),Arrays.asList(0.357541899));
	  north.addLane(Arrays.asList(gboro,clayton,south),Arrays.asList(0.089385475,0.1620111730,0.391061453));
	  south.addLane(Arrays.asList(clayton,gboro),Arrays.asList(0.151898734,0.261603376));
	  south.addLane(Arrays.asList(north,sickler),Arrays.asList(0.493670886,0.092827004));
	  sickler.addLane(Arrays.asList(south),Arrays.asList(0.218518519));
	  sickler.addLane(Arrays.asList(clayton, gboro, north),Arrays.asList(0.407407407,0.244444444,0.12962963));
	  clayton.addLane(Arrays.asList(gboro,north),Arrays.asList(0.030973451,0.181415929));
	  clayton.addLane(Arrays.asList(sickler,south),Arrays.asList(0.623893805,0.163716814));
	  
	  Street[] ns = {north, south};
	  Street[] sc = {sickler, clayton};
	  Street[] g = {gboro};
	  Light northSouth = new Light(40, ns);
	  Light sicklerClayton = new Light(50,sc);
	  Light glassBoro = new Light(25,g);
	  return Arrays.asList(northSouth, sicklerClayton, glassBoro);
  }
}