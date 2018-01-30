import java.util.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import command.*;
import parseSchema.*;

public class ConfigParser{
  private static String configLocation;
  private JSONParser parser = new JSONParser();
  private Map<String, String> commandMap;


  public ConfigParser(String configLocation){
    this.configLocation = configLocation;
    commandMap = new HashMap<String, String>();

    initConfig();
  }

  private void initConfig(){
    initCommandConfig();
  }

  private void initCommandConfig(){
      try {
          //todo naming
          JSONObject configObject = (JSONObject) parser.parse(new FileReader(configLocation));
          JSONObject commandArray = (JSONObject) configObject.get("command"); //todo remove Magic Number

          Set<String> commandSet = commandArray.keySet();

          for(String commandName : commandSet){
            String commandClassName = commandArray.get(commandName).toString();
            commandMap.put(commandName,commandClassName);
          }
          //todo handle error
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (ParseException e) {
          e.printStackTrace();
      }
  }

  public Map<String, String> getUsableCommandMap(){
    return this.commandMap;
  }
}
