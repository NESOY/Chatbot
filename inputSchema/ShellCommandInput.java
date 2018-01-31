package inputSchema;

import java.util.*;
import command.*;

public class ShellCommandInput implements Input{
  private Scanner scanner = new Scanner(System.in);

  public Object read(){
    System.out.print("명령어 > ");
    String command = scanner.nextLine();
    return command;
  }
}
