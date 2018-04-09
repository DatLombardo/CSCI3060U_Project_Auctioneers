import java.io.*;
import java.util.*;

/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  TransactionProcessor.java
*/
public class TransactionProcessor{
    private String line;
    public Parser parser=new Parser();
    public Map<String, Item> items;
    public Map<String, User> users;

    /**
     * TransactionProcessor
     * General Constructor for each transaction request, read in the line and complete request.
     * @param items
     * @param users
     */
    public TransactionProcessor(Map<String, Item> items, Map<String, User> users){
        this.items=items;
        this.users=users;
    }

    /**
     * processTransaction
     * @param line
     */
    public void processTransation(String line){
        int action=Integer.parseInt(line.substring(0,2));
        String input = line.substring(3);
        Parser parser = new Parser();
        String username, type, buyer, seller, itemname;
        double bid, credit;
        //decide which transaction to do
        switch(action){
            case 0:
                //logout
                break;
            case 10:
                //login
                break;
            case 1:
                //create
                create(input);
                break;
            case 2:
                //delete
                username = line.substring(3,18);
                delete(username);
                break;
            case 3:
                //advertise
                advertise(input);
                break;
            case 4:
                //bid
                bid(input);
                break;
            case 5:
                //refund

                refund(input);
                break;
            case 6:
                //addCredit
                addCredit(input);
                break;
        }

    }

    /**
     * create
     * @param line
     */
    private void create(String line){
        User ABC = new User(line);
        String username=parser.removeSpaceFill(line.substring(0,15));
        users.put(username,ABC);
    }

    /**
     * delete
     * @param username
     */
     private void delete(String username){
       System.out.println("delete: " + username)
         //Remove user instance
         users.remove(parser.removeSpaceFill(username));

         Item currItem;
         //Remove potential instances of the user within the item list
         for (Map.Entry<String, Item> entry : this.items.entrySet()) {
             currItem = entry.getValue();
             //Deleting a user who is selling items, need to delete item.
             if (currItem.getSellerName() == username){
                 items.remove(entry.getKey());
             }
             if (currItem.getHighestBidder() == username){
                 currItem.setHighestBidder(currItem.getSellerName(), currItem.getBid());
             }
         }
     }

    /**
     * advertise
     * @param line
     */
    private void advertise(String line){
        //item name
        String input = line.substring(0,25);
        input+="NULL";
        for (int i =0;i<=11;i++){
          input+= " ";
        }
        input+=line.substring(25);

        Item ABC=new Item(input);
        String seller = ABC.getSellerName();
        String itemname= ABC.getItemName();
        items.put(itemname+seller,ABC);
    }

    /**
     * bid
     * @param seller
     * @param buyer
     * @param itemname
     * @param bid
     */
    private void bid(String line){
      String seller = parser.removeSpaceFill(line.substring(26,40));
      String itemname = parser.removeSpaceFill(line.substring(0,25));
      String buyer = line.substring(42,56);
      double bid = Double.parseDouble(line.substring(58));

      if(items.get(itemname+seller)!=null){
        items.get(itemname+seller).setHighestBidder(buyer, bid);
      }else{
        System.out.println("ERROR: item does not exist");
      }
    }

    /**
     * refund
     * @param seller
     * @param buyer
     * @param amount
     */
    private void refund(String line){
      String buyer =  line.substring(0,15);
      String seller = line.substring(16,31);
      double amount = Double.parseDouble(line.substring(32));

      User sellerUser =  users.get(seller);
      User buyerUser =   users.get(buyer);
      if(sellerUser != null && buyerUser != null){
         users.get(seller).setFunds(sellerUser.getFunds() - amount);
          users.get(buyer).setFunds(buyerUser.getFunds() + amount);
        }else{
          System.out.println("ERROR: error seller and buyer no longer exist");
        }
      }
        /**
     * addCredit
     * @param username
     * @param balance
     */
    private void addCredit(String line){

  String username = line.substring(0,15);
  double balance = Double.parseDouble(line.substring(18));
      if(users.get(username) != null){
        users.get(username).funds+=balance;

        }else{
          System.out.println("ERROR: error user does not exist");
        }
    }
}
