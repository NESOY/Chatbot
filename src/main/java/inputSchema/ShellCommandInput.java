package src.main.java.inputSchema;

import java.util.*;

public class ShellCommandInput implements Input{
  private Scanner scanner = new Scanner(System.in);

  public Object read(){
    System.out.print("명령어 > ");
    String command = scanner.nextLine();
    return command;
  }
}
