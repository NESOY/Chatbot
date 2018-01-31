package parser;

import java.util.*;
import java.lang.reflect.*;
import java.lang.*;

import command.*;
import parseSchema.*;

public class CommandParser{
  private SchemaInterface schemaInterface;
  private List<CommandInterface> commandList;
  private Map<String, String> usableCommandMap;

  public CommandParser(Map<String, String> usableCommandMap){
    this.usableCommandMap = usableCommandMap;
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

  private void registerCommands(){
    try{
      Iterator<String> keys = usableCommandMap.keySet().iterator();

      while(keys.hasNext()){
        String commandName = keys.next();
        String commandClassName = usableCommandMap.get(commandName);

        Class commandClass = Class.forName("command." + commandClassName); // todo remove Magic number
        Constructor cs = commandClass.getConstructor(new Class[]{String.class});

        commandList.add((CommandInterface)cs.newInstance(commandName));
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public void setSchemaInterface(SchemaInterface schemaInterface){
    this.schemaInterface = schemaInterface;
  }
}
