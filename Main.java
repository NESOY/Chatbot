import java.util.*;

import inputSchema.*;
import outputSchema.*;
import parseSchema.*;
import command.*;

public class Main{
    public static void main(String args[]) {
      ConfigParser configParser = new ConfigParser("config/config.json");

        while(true){
          Input input = new ShellInput();
          String command = input.readCommand();

          CommandParser commandParser = new CommandParser(configParser.getUsableCommandMap());
          commandParser.setSchemaInterface(new SpaceSchema());


          CommandInterface parsedCommand = commandParser.parse(command);
          parsedCommand.execute();

          Output output = new ShellOutput(); //Output
          output.print(parsedCommand.getResult());
        }
    }
}
