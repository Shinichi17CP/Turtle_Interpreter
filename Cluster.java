package turtle;

import java.util.Map;
import java.util.HashMap;

public class Cluster extends Turtle {
  
  private Map<String, Turtle> turtles = new HashMap<String, Turtle>();
  
  public Cluster(int x, int y, Paper paper) {
    super(x, y, paper);
  }
  
  public void addTurtle(String name, Turtle turtle) {
    turtles.put(name, turtle);
  }
  
  @Override
  public void move() {
    for (Turtle t : turtles.values()) {
      t.move();
    }
  }
  
  @Override
  public void rotate(char d, int degrees) {
    for (Turtle t : turtles.values()) {
      t.rotate(d, degrees);
    }
  }
}