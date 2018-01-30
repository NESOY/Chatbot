package parseSchema;

import java.util.*;
import command.*;

public class CsvSchema implements SchemaInterface{

  public List parse(String command){
    List<String> argsList = new ArrayList<String>();

    for(String commandToken : command.split(",")){
      if(commandToken.length() > 0){
        String trimCommandToken = commandToken.trim();
        argsList.add(trimCommandToken);
      }
    }
    
    return argsList;
  }
}
