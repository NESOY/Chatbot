package parser;

import java.util.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import command.*;
import parseSchema.*;

public class ConfigParser{
  private final static String COMMAND = "command";
  private String configLocation;

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
