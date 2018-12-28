package turtle;

import java.io.FileNotFoundException;
import java.lang.IndexOutOfBoundsException;
import java.io.File;
import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
  
  public static void main(String[] args) throws FileNotFoundException {
  
    TurtleInterpreter tI;
    Scanner s;
    PrintStream out;
    
    if (args.length == 0) {
      s = new Scanner(System.in);
      out = System.out;
      
    } else {
      File file = new File(args[0]);
      s = new Scanner(file);
      
      try {
        out = new PrintStream(new File(args[1]));
      } catch (IndexOutOfBoundsException e) {
        out = System.out;
      }
    }
  
    tI = new TurtleInterpreter(s, out);
  }
}
