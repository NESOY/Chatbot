package parser;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigParser{
  private final static String COMMAND = "command";

  private Map<String, String> commandMap;

  public ConfigParser(){
    commandMap = new HashMap<String, String>();
  }

  public void parse(JSONObject configObject){
    parseCommandConfig(configObject);
  }

  private void parseCommandConfig(JSONObject configObject){
      JSONObject commandArray = (JSONObject) configObject.get(COMMAND);

      Set<String> commandSet = commandArray.keySet();

      for(String commandName : commandSet){
        String commandClassName = commandArray.get(commandName).toString();
        commandMap.put(commandName,commandClassName);
      }
  }

  public Map<String, String> getUsableCommandMap(){
    return this.commandMap;
  }
}
