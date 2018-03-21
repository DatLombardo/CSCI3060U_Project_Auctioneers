/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  User.java
 */

public class User{
  public String username;
  public String type;
  public double funds;

  /**
   * General constructor for User class, sets instance variables.
   * @param line
   */
  public User(String line){
    this.username = line.substring(0,15);
    this.type = line.substring(16,18);
    this.funds = Double.parseDouble(line.substring(19,28));
  }

  /**
   * getUsername getter function.
   * @return instance value
   */
  public String getUsername(){
    return this.username;
  }

  /**
   * getType getter function.
   * @return instance value
   */
  public String getType(){
    return this.type;
  }

  /**
   * getFunds getter function.
   * @return instance value
   */
  public double getFunds(){
    return this.funds;
  }

  /**
   * setFunds setter function.
   * @param newFunds
   */
  public void setFunds(double newFunds){
    this.funds = newFunds;
  }

  /**
   * userFileString
   * Function called to write each of the users in the file
   * Format: UUUUUUUUUUUUUUU_TT_CCCCCCCCC
   * @return file formatted User string
   */
  public String userFileString(){
    Parser parser = new Parser();
    String finalString = this.username + " " + this.type + " " + parser.fillFunds(this.funds);
    return finalString;
  }
}
