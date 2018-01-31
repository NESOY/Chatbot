package src.main.java.parseSchema;

import java.util.ArrayList;
import java.util.List;

public class CsvSchema implements SchemaInterface{

  public List<String> parse(String command){
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
