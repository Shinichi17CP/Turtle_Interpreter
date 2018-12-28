package turtle;

public class BouncyTurtle extends Turtle {
  
  private final int TURN_AROUND = 180;
  
  public BouncyTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  @Override
  protected void moveOne(int x, int y) {
    try {
      position = paper.getGrid(position.getX() + x, position.getY() + y);
    } catch (ArrayIndexOutOfBoundsException e) {
      rotate('r', TURN_AROUND);
    }
    finally {
      if (pen.isPenDown()) {
        position.setMark(pen.mark());
      }
    }
  }
  
}