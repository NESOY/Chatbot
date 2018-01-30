package command;

import java.util.*;
import java.time.*;

public class DateCommand implements CommandInterface{
  private List<String> args;
  private List<String> result;

  @Override
  public boolean isCommand(List<String> commendList){
    return commendList.contains("날짜");
  }

  @Override
  public void execute(){
    result = new ArrayList<String>();

    LocalDateTime currentTime = LocalDateTime.now();
    result.add(new String("현재 날짜 : " + currentTime));
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
