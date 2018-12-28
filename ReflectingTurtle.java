package turtle;

public class ReflectingTurtle extends Turtle {
  
  private final int TURN_AROUND = 180;
  private final int SHARP_TURN = 90;
  private int currentX, currentY, newX, newY;
  
  public ReflectingTurtle(int x, int y, Paper paper) {
    super(x, y, paper);
  }

  @Override
  protected void moveOne(int x, int y) {
    currentX = position.getX();
    currentY = position.getY();
    newX = position.getX() + x;
    newY = position.getY() + y;

    try {
      position = paper.getGrid(newX, newY);

    } catch (ArrayIndexOutOfBoundsException e) {
      if (toRotateLeft()) {
        rotate('l', SHARP_TURN);
        moveReflectOne();
      } else if (toRotateRight()) {
        rotate('r', SHARP_TURN);
        moveReflectOne();
      } else {
        rotate('r', TURN_AROUND);
      }
    }
    finally {
      if (pen.isPenDown()) {
        position.setMark(pen.mark());
      }
    }
  }

  private boolean toRotateLeft() {
    return (currentX > 0 && currentY == (paper.getHeight() - 1) && dir == Dir.NW)
        || (currentX == 0 && currentY > 0 && dir == Dir.SW)
        || (currentX < (paper.getWidth() - 1) && currentY == 0 && dir == Dir.SE)
        || (currentX == (paper.getWidth() - 1) && currentY <
              (paper.getHeight() - 1) && dir == Dir.NE);
  }

  private boolean toRotateRight() {
    return (currentX < (paper.getWidth() - 1) && currentY ==
              (paper.getHeight() - 1) && dir == Dir.NE)
        || (currentX == (paper.getWidth() - 1) && currentY > 0 && dir == Dir.SE)
        || (currentX > 0 && currentY == 0 && dir == Dir.SW)
        || (currentX == 0 && currentY < (paper.getHeight() - 1) && dir == Dir.NW);

  }

  private void moveReflectOne() {
    if (sameX()) {
      position = paper.getGrid(position.getX(), newY);
    } else if (sameY()) {
      position = paper.getGrid(newX, position.getY());
    }
  }

  private boolean sameX() {
    return currentX == 0 || currentX == (paper.getWidth() - 1);
  }

  private boolean sameY() {
    return currentY == 0 || currentY == (paper.getHeight() - 1);
  }
}