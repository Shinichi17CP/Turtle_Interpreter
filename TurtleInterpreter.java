package turtle;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TurtleInterpreter {

  private Scanner s;
  private Paper paper = new Paper();
  private String name;
  private Turtle turtle;
  private PrintStream out;
  
  public TurtleInterpreter(Scanner s, PrintStream out) {
    this.s = s;
    this.out = out;
    run();
  }
  
  public void run() {
    String command;
    
    while (s.hasNext()) {
      command = s.next();
      switch (command) {
        case "paper":
          int width = s.nextInt();
          int height = s.nextInt();
          paper = new Paper(width, height);
          break;
          
        case "new":
          String type = s.next();
          name = s.next();
          
          if (type.equals("cluster")) {
            int size = s.nextInt();
            String cName = name;
            Turtle cluster = new Cluster(0, 0, paper);
            
            for (int i = 0; i < size; i++) {
              s.next();
              name = cName + "." + s.next();
              type = s.next();
              turtleTypes(type);
              
              cluster.addTurtle(name, paper.getTurtle(name));
            }
            paper.addTurtle(cName, cluster);
            
          } else {
            turtleTypes(type);
          }
          break;
          
        case "pen":
          name = s.next();
          Pen pen = paper.getTurtle(name).getPen();
          
          String state = s.next();
          char st = state.charAt(0);
          if (state.equals("up") || state.equals("down")) {
            pen.changeState(st);
          } else {
            pen.setBrush(st);
          }
          break;
          
        case "move":
          name = s.next();
          int dist = s.nextInt();
          turtle = paper.getTurtle(name);

          for (int i = 0; i < dist; i++) {
            turtle.move();
          }
          break;
          
        case "right":
          name = s.next();
          int angleR = s.nextInt();
          turtle = paper.getTurtle(name);
          turtle.rotate('r', angleR);
          break;
          
        case "left":
          name = s.next();
          int angleL = s.nextInt();
          turtle = paper.getTurtle(name);
          turtle.rotate('l', angleL);
          break;
          
        case "show":
          paper.show(out);
          break;
          
        default:
          System.out.println("Command not valid, please try again"); break;
      }
    
    }
    s.close();
  }
  
  private void turtleTypes(String type) {
    int x = s.nextInt();
    int y = s.nextInt();
    switch (type) {
      case "normal":
        paper.addTurtle(name, new NormalTurtle(x, y, paper));
        break;
    
      case "continuous":
        paper.addTurtle(name, new ContinuousTurtle(x, y, paper));
        break;
    
      case "bouncy":
        paper.addTurtle(name, new BouncyTurtle(x, y, paper));
        break;
    
      case "reflecting":
        paper.addTurtle(name, new ReflectingTurtle(x, y, paper));
        break;
    
      case "wrapping":
        paper.addTurtle(name, new WrappingTurtle(x, y, paper));
        break;
    
      default:
        System.out.println("Turtle type not valid"); break;
    }
  }
}