package turtle;

public class ContinuousTurtle extends Turtle {

  public ContinuousTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }
  
  @Override
  protected void moveOne(int x, int y) {
    try {
      position = paper.getGrid(position.getX() + x, position.getY() + y);
    } catch (ArrayIndexOutOfBoundsException e) {
      position = new Grid(position.getX() + x, position.getY() + y);
    }
    finally {
      if (pen.isPenDown()) {
        position.setMark(pen.mark());
      }
    }
  }
}