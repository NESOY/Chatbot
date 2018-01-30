package outputSchema;

import java.util.*;
import command.*;

public class ShellOutput implements OutputInterface{
  public void print(List<String> result){
    for(String element : result){
      System.out.println(element);
    }
  }
}
