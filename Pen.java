package turtle;

public class Pen {

  private char state = 'u';
  private char brush;

  public Pen(char brush) {
    this.brush = brush;
  }

  public void changeState(char s) {
    assert (s == 'u' || s == 'd');
    state = s;
  }

  public void setBrush(char c) {
    brush = c;
  }

  public boolean isPenDown() {
    return state == 'd';
  }
  
  public char mark() {
    return brush;
  }
}