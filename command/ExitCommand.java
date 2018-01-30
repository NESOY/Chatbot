package command;

import java.util.*;

public class ExitCommand implements CommandInterface{
  private List<String> args;
  private List<String> result;

  @Override
  public boolean isCommand(List<String> commendList){
    return commendList.contains("종료");
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
