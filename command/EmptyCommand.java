package command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmptyCommand implements CommandInterface{
  private List<String> args;
  private List<String> result;

  @Override
  public boolean isCommand(List<String> commendList){
    return false;
  }

  @Override
  public void execute(){
    result = new ArrayList<String>();

    result.add(new String("없는 명령어 입니다.")); //todo Refactor String -> Model
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
