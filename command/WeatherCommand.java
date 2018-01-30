package command;

import java.util.*;

public class WeatherCommand implements CommandInterface{
  private String command;
  private Map<String, List<Double>> weatherInfo = new HashMap<String, List<Double>>();
  private List<String> result;
  private List<String> args;

  public WeatherCommand(String command){
    this.command = command;
    initWeatherData();
  }

  private void initWeatherData(){
    List<Double> seoulTemperList = Arrays.asList(-7.0, -8.0, -9.0, -8.0, -5.0);
    List<Double> busanTemperList = Arrays.asList(-5.0, -4.0, -6.0, -7.0, -1.0);
    List<Double> junjuTemperList = Arrays.asList(-3.0, -3.5, -4.0, -4.5, -5.0);

    weatherInfo.put("서울",seoulTemperList);
    weatherInfo.put("부산",busanTemperList);
    weatherInfo.put("전주",busanTemperList);
  }

  @Override
  public boolean isCommand(List<String> commendList){
    return commendList.contains(command);
  }

  @Override
  public void execute(){
    result = new ArrayList<String>();

    String location = getLocation();

    List<Double> temperList = getTemperList(location);

    if(temperList.size() > 0){
      result.add(new String("========== " + location + " =========="));
      for(Double temper : temperList){
        result.add(new String(temper.toString()));
      }
    }
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

  private List<Double> getTemperList(String location){
    List<Double> temperList = weatherInfo.get(location);
    if(temperList == null){
      return Collections.emptyList();
    }
    return temperList;
  }

  private String getLocation(){ //todo refactor
    for(String location : args){
      if(location.equals("서울")){
        return "서울";
      }
      else if(location.equals("부산")){
        return "부산";
      }
      else if(location.equals("전주")){
        return "전주";
      }
    }
    return "";
  }
}
