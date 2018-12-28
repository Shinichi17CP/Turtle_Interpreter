package turtle;

import java.util.Map;
import java.util.HashMap;
import java.io.PrintStream;

public class Paper {

  private final int width, height;
  private Grid[][] paper;
  private Map<String, Turtle> turtles = new HashMap<String, Turtle>();

  public Paper() {
    this(10, 10);
  }

  public Paper(int width, int height) {
    this.width = width;
    this.height = height;
    paper = new Grid[width][height];

    for (int w = 0; w < width; w++) {
      for (int h = 0; h < height; h++) {
        paper[w][h] = new Grid(w, h);
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Grid getGrid(int x, int y) {
    return paper[x][y];
  }

  public void addTurtle(String name, Turtle turtle) {
    turtles.put(name, turtle);
  }
  
  public Turtle getTurtle(String name) {
    return turtles.get(name);
  }
 
  public void show(PrintStream out) {
    for (int h = height - 1; h >= 0; h--) {
      for (int w = 0; w < width; w++) {
        out.append(paper[w][h].getMark());
      }
      out.append('\n');
    }
    out.append('\n');
  }


}