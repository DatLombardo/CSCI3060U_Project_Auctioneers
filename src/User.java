public class User{
  public String username;
  public String type;
  public double funds;

  public User(String line){
    this.username = line.substring(0,15);
    this.type = line.substring(16,18);
    this.funds = Double.parseDouble(line.substring(19,28));
  }

  public String getUsername(){
    return this.username;
  }

  public String getType(){
    return this.type;
  }

  public double getFunds(){
    return this.funds;
  }

  public void setFunds(double newFunds){
    this.funds = newFunds;
  }

  public String userFileString(){
    //TODO:: Need to fill: username, type and funds with extra characters
    String finalString = "";
    return finalString;
  }
}
