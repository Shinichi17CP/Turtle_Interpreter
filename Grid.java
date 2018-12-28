package turtle;

public class Grid {

  private final int x, y;
  char mark = ' ';

  public Grid() {
    this(0, 0);
  }

  public Grid(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setMark(char c) {
    mark = c;
  }
  
  public char getMark() {
    return mark;
  }

  @Override
  public String toString() {
    return String.valueOf(mark);
  }
}