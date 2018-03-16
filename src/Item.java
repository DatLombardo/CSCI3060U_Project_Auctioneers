/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  Item.java
 */
public class Item{
  private String itemName;
  private String sellerName;
  private String highestBidder;
  private int daysToExpiry;
  private double bid;

  /**
   * General constructor for Item class, sets instance variables.
   * @param line
   */
  public Item(String line){
    this.itemName = line.substring(0,25);
    this.sellerName = line.substring(26,41);
    this.highestBidder = line.substring(42,57);
    this.daysToExpiry = Integer.parseInt(line.substring(58,61));
    this.bid = Double.parseDouble(line.substring(62,69));
  }

  /**
   * getItemName getter function
   * @return instance value
   */
  public String getItemName(){
    return this.itemName;
  }

  /**
   * getSellerName getter function
   * @return instance value
   */
  public String getSellerName(){
    return this.sellerName;
  }

  /**
   * getHighestBidder getter function
   * @return instance value
   */
  public String getHighestBidder(){
    return this.highestBidder;
  }

  /**
   * getDaysToExpiry getter function
   * @return instance value
   */
  public int getDaysToExpiry(){
    return this.daysToExpiry;
  }

  /**
   * getBid getter function
   * @return instance value
   */
  public double getBid(){
    return this.bid;
  }

  /**
   * setHigherBidder setter function.
   * @param newBidder
   */
  public void setHighestBidder(String newBidder, double bid){
    this.highestBidder = newBidder;
  }

  /**
   * itemFileString
   * Function called to write each of the items in the file
   * Format: IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_DDD_PPPPPP
   * @return file formatted Item string.
   */
  public String itemFileString(){
    Parser parser = new Parser();
    String finalString = this.itemName + " " + this.sellerName + " " + this.highestBidder + " "
                    + parser.fillDays(this.daysToExpiry) + " " + parser.fillBids(this.bid);
    return finalString;
  }
}
