package src.main.java.outputSchema;

import java.util.List;

public class ShellCommandOutput implements Output{
  public void print(List<String> result){
    for(String element : result){
      System.out.println(element);
    }
  }
}
