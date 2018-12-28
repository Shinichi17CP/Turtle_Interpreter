package turtle;

public class WrappingTurtle extends Turtle{
  
  public WrappingTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  @Override
  protected void moveOne(int x, int y) {
    try {
      position = paper.getGrid(position.getX() + x, position.getY() + y);
    } catch (ArrayIndexOutOfBoundsException e) {
      position = paper.getGrid(
          (position.getX() + paper.getWidth() + x) % paper.getWidth(),
          (position.getY() + paper.getHeight() + y) % paper.getHeight());
    }
    finally {
      if (pen.isPenDown()) {
        position.setMark(pen.mark());
      }
    }
  }
}