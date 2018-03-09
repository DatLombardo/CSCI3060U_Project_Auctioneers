public class Item{
  public String itemName;
  public String sellerName;
  public String highestBidder;
  public int daysToExpiry;
  public double bid;

  public Item(String line){
    this.itemName = line.substring(0,25);
    this.sellerName = line.substring(26,41);
    this.highestBidder = line.substring(42,57);
    this.daysToExpiry = Integer.parseInt(line.substring(58,61));
    this.bid = Double.parseDouble(line.substring(62,69));
  }

  public String getItemName(){
    return this.itemName;
  }

  public String getSellerName(){
    return this.sellerName;
  }
  public String getHighestBidder(){
    return this.highestBidder;
  }

  public int getDaysToExpiry(){
    return this.daysToExpiry;
  }

  public double getBid(){
    return this.bid;
  }

  public void setHighestBidder(String newBidder){
    this.highestBidder = newBidder;
  }

  public String itemFileString(){
    //TODO:: Need to fill: username, type and funds with extra characters
    String finalString = "";
    return finalString;
  }
}
