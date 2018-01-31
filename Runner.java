import command.CommandInterface;
import inputSchema.Input;
import inputSchema.JSONConfigInput;
import inputSchema.ShellCommandInput;
import org.json.simple.JSONObject;
import outputSchema.Output;
import outputSchema.ShellCommandOutput;
import parseSchema.SpaceSchema;
import parser.CommandParser;
import parser.ConfigParser;



public class Runner{
    public static void main(String args[]) {
      Input jsonConfigInput = new JSONConfigInput("config/config.json");
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
