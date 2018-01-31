package command;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateCommand implements CommandInterface{
  private String command;
  private List<String> args;
  private List<String> result;

  public DateCommand(String command){
    this.command = command;
  }

  @Override
  public boolean isCommand(List<String> commendList){
    return commendList.contains(command);
  }

  @Override
  public void execute(){
    result = new ArrayList<String>();

    LocalDateTime currentTime = LocalDateTime.now();
    result.add(new String("현재 날짜 : " + currentTime)); // todo Refactor String -> Model
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
