package command;

import java.util.*;

public class ExitCommand implements CommandInterface{
  private String command;
  private List<String> args;
  private List<String> result;

  public ExitCommand(String command){
    this.command = command;
  }

  @Override
  public boolean isCommand(List<String> commendList){
    return commendList.contains(command);
  }

  @Override
  public void execute(){
    System.exit(1);
  }

  @Override
  public List<String> getResult(){
    if(this.result == null){
      return Collections.emptyList();
    }
    return this.result;
  }

  @Override
  public void setArgs(List<String> args){
    this.args = args;
  }
}
