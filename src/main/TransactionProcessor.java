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
                create(line);
                break;
            case 2:
                //delete
                username = line.substring(3,18);
                delete(username);
                break;
            case 3:
                //advertise
                advertise(line);
                break;
            case 4:
                //bid
                seller = parser.removeSpaceFill(line.substring(28,43));
                buyer = line.substring(44,59);
                itemname = parser.removeSpaceFill(line.substring(3,27));
                bid = Double.parseDouble(line.substring(60,66));
                System.out.println(bid);
                bid(seller,buyer,itemname,bid);
                break;
            case 5:
                //refund
                seller = parser.removeSpaceFill(line.substring(19,34));
                buyer = parser.removeSpaceFill(line.substring(3,18));
                double amount = Double.parseDouble(line.substring(35,44));
                refund(seller,buyer,amount);
                break;
            case 6:
                //addCredit
                username = parser.removeSpaceFill(line.substring(3,18));
                credit = Double.parseDouble(line.substring(22,31));
                addCredit(username, credit);
                break;
        }

    }

    /**
     * create
     * @param line
     */
    private void create(String line){
        User ABC = new User(line);
        String username=parser.removeSpaceFill(line.substring(3,18));
        users.put(username,ABC);
    }

    /**
     * delete
     * @param username
     */
     private void delete(String username){
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
        Item ABC=new Item(line);
        String seller = parser.removeSpaceFill(line.substring(3,22));
        String itemname=parser.removeSpaceFill(line.substring(23,36));
        items.put(itemname+seller,ABC);
    }

    /**
     * bid
     * @param seller
     * @param buyer
     * @param itemname
     * @param bid
     */
    private void bid(String seller, String buyer, String itemname, double bid){
        items.get(itemname+seller).setHighestBidder(buyer, bid);
    }

    /**
     * refund
     * @param seller
     * @param buyer
     * @param amount
     */
    private void refund(String seller, String buyer, double amount){
        users.get(seller).funds-=amount;
        users.get(buyer).funds+=amount;
    }

        /**
     * addCredit
     * @param username
     * @param balance
     */
    private void addCredit(String username, double balance){
        users.get(username).funds+=balance;
    }
}
