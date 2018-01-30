package outputSchema;

import java.util.*;
import command.*;

public class ShellOutput implements Output{
  public void print(List<String> result){
    for(String element : result){
      System.out.println(element);
    }
  }
}
