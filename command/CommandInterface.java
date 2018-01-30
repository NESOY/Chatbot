package command;

import java.util.*;

public interface CommandInterface{
  boolean isCommand(List<String> commendList);
  void execute();
  List<String> getResult();
  void setArgs(List<String> args);
}
