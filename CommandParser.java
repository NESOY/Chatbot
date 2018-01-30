import java.util.*;

import command.*;
import parseSchema.*;

public class CommandParser{
  private SchemaInterface schemaInterface;
  private List<CommandInterface> commandList;

  public CommandParser(){
    commandList = new ArrayList<CommandInterface>();
    registerCommands();
  }

  public CommandInterface parse(String stringOfCommand){
    List<String> argsList = schemaInterface.parse(stringOfCommand);

    for(CommandInterface currentCommand : commandList){
      if(currentCommand.isCommand(argsList)){
        currentCommand.setArgs(argsList);
        return currentCommand;
      }
    }

    return new EmptyCommand();
  }

  private void registerCommands(){ //Todo reflation
    commandList.add(new WeatherCommand());
    commandList.add(new DateCommand());
    commandList.add(new ExitCommand());
  }

  public void setSchemaInterface(SchemaInterface schemaInterface){
    this.schemaInterface = schemaInterface;
  }
}
