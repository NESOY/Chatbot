package inputSchema;

import java.util.*;
import command.*;

public class ShellInput implements Input{
  private Scanner scanner = new Scanner(System.in);

  public String readCommand(){
    System.out.print("명령어 > ");
    String command = scanner.nextLine();
    return command;
  }
}
