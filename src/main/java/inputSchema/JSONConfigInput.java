package src.main.java.inputSchema;

import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONConfigInput implements Input{
  private FileReader fileReader;
  private JSONParser parser;

  public JSONConfigInput(String configLocation){
    openJSONConfig(configLocation);
  }

  @Override
  public Object read(){
    JSONObject configObject = new JSONObject();

    try{
      configObject = (JSONObject) parser.parse(fileReader);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return configObject;
  }

  private void openJSONConfig(String configLocation){
    try {
          fileReader = new FileReader(configLocation);
          parser = new JSONParser();
    } catch (FileNotFoundException e) {
          e.printStackTrace();
    }
  }
}
