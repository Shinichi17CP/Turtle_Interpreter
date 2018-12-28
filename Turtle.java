package turtle;

public abstract class Turtle {

  protected Pen pen;
  protected Dir dir;
  protected Grid position;
  protected Paper paper;

  public Turtle(int x, int y, Paper paper) {
    this.paper = paper;
    position = paper.getGrid(x, y);
    pen = new Pen('*');
    dir = Dir.N;
  }
  
  public Pen getPen() {
    return pen;
  }

  public void move() {
    int x = 0; int y = 0;
    switch (dir) {
      case N:
        y = 1;
        break;
      case NE:
        x = 1; y =1;
        break;
      case E:
        x = 1;
        break;
      case SE:
        x = 1; y = -1;
        break;
      case S:
        y = -1;
        break;
      case SW:
        x = -1; y = -1;
        break;
      case W:
        x = -1;
        break;
      case NW:
        x = -1; y = 1;
        break;
      default:
        System.out.printf("Turtle direction not valid"); break;
    }
    moveOne(x, y);

  }

  protected void moveOne(int x, int y) {
    try {
      position = paper.getGrid(position.getX() + x, position.getY() + y);
    } catch (ArrayIndexOutOfBoundsException e) {}
    finally {
      if (pen.isPenDown()) {
        position.setMark(pen.mark());
      }
    }
  }

  public void rotate(char d, int degrees) {
    int turns = degrees / 45;
    if (d == 'r') {
      for (int i = 0; i < turns; i++) {
        dir = dir.next();
      }
    } else {
      for (int i = 0; i < turns; i++) {
        dir = dir.previous();
      }
    }
  }
  
  public void addTurtle(String name, Turtle turtle) {}
}