package turtle;

public enum Dir {
  N, NE, E, SE, S, SW, W, NW;
  
  private static Dir[] values = values();
  
  public Dir next() {
    return values[(this.ordinal() + 1) % values.length];
  }
  
  public Dir previous() {
    return values[(this.ordinal() + values.length - 1) % values.length];
  }
}