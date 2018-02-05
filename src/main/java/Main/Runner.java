package src.main.java.Main;

import org.json.simple.JSONObject;
import src.main.java.command.CommandInterface;
import src.main.java.inputSchema.Input;
import src.main.java.inputSchema.JSONConfigInput;
import src.main.java.inputSchema.ShellCommandInput;
import src.main.java.outputSchema.Output;
import src.main.java.outputSchema.ShellCommandOutput;
import src.main.java.parseSchema.SpaceSchema;
import src.main.java.parser.CommandParser;
import src.main.java.parser.ConfigParser;



public class Runner{
    public static void main(String args[]) {
      Input jsonConfigInput = new JSONConfigInput("src/main/resources/config.json");
      JSONObject configObject = (JSONObject) jsonConfigInput.read();

      ConfigParser configParser = new ConfigParser();
      configParser.parse(configObject);

      CommandParser commandParser = new CommandParser(configParser.getUsableCommandMap());
      commandParser.setSchemaInterface(new SpaceSchema());

      while(true){
        Input shellCommandinput = new ShellCommandInput();
        String command = (String) shellCommandinput.read();

        CommandInterface parsedCommand = commandParser.parse(command);
        parsedCommand.execute();

        Output shellCommandOutput = new ShellCommandOutput();
        shellCommandOutput.print(parsedCommand.getResult());
      }
    }
}
