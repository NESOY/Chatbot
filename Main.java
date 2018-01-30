import java.util.*;

import inputSchema.*;
import outputSchema.*;
import parseSchema.*;
import command.*;

public class Main{
    public static void main(String args[]) {
      System.out.println("Hello Chat Bot World"); // remove
      System.out.println("====================");

        while(true){
          InputInterface input = new ShellInput(); // Input
          String command = input.readCommand();

          CommandParser commandParser = new CommandParser();
          commandParser.setSchemaInterface(new SpaceSchema());

          CommandInterface parsedCommand = commandParser.parse(command);
          parsedCommand.execute();

          OutputInterface output = new ShellOutput(); //Output
          output.print(parsedCommand.getResult());
        }
    }
}
