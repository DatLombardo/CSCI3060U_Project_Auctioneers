import java.io.*;
import java.util.*;
//completly untested
//not sure about the numbers

/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  TransactionProcessor.java
 */
>>>>>>> 0694a638ab70723b90b9e8c5860d5284841c9fa8
public class TransactionProcessor{
    /**
     * TransactionProcessor
     * General Constructor for each transaction request, read in the line and complete request.
     * @param line
     * @param items
     * @param users
     */
    public void TransactionProcessor(String line, Map<String, Item> items, Map<String, User> users){
        int action=Integer.parseInt(line.substring(0,2));
        Parser parser = new Parser();
        String username, type, buyer, seller, itemname;
        double bid;
        switch(action){
            case 0:
                //logout
                break;
            case 10:
                //login
                break;
            case 1:
                //create
                username=line.substring(3,18);
                type=line.substring(19,21);
                double credit=Double.parseDouble(line.substring(22,31));
                create(username,type,credit);
                break;
            case 2:
                //delete
                username=line.substring(3,18);
                delete(username);
                break;
            case 3:
                //advertise
                seller = line.substring(3,22);
                itemname=line.substring(23,36);
                bid = Double.parseDouble(line.substring(41,47));
                int days=Integer.parseInt(line.substring(37,40));
                advertise(seller,itemname,bid,days);
                break;
            case 4:
                //bid
                seller = line.substring(23,37);
                buyer = line.substring(39,53);
                itemname = line.substring(3,22);
                bid = Double.parseDouble(line.substring(54,60));
                bid(seller,buyer,itemname,bid);
                break;
            case 5:
                //refund
                seller = line.substring(19,34);
                buyer = line.substring(3,18);
                double amount = Double.parseDouble(line.substring(35,44));
                refund(seller,buyer,amount);
                break;
            case 6:
                //addCredit
                username = line.substring(3,18);
                credit = Double.parseDouble(line.substring(22,31));
                addCredit(username, credit);
                break;
        }
    }

    /**
     * processTransaction
     */
    public void processTransation(){

    }

    /**
     * create
     * @param username
     * @param type
     * @param credit
     */
    private void create(String username, String type, double credit){

    }

    /**
     * delete
     * @param username
     */
    private void delete(String username){
        users.remove("username")
    }

    /**
     * advertise
     * @param seller
     * @param itemname
     * @param bid
     * @param days
     */
    private void advertise(String seller, String itemname, double bid, int days){

    }

    /**
     * bid
     * @param seller
     * @param buyer
     * @param itemname
     * @param bid
     */
    private void bid(String seller, String buyer, String itemname, double bid){

    }

    /**
     * refund
     * @param seller
     * @param buyer
     * @param amount
     */
    private void refund(String seller, String buyer, double amount){

    }

    /**
     * addCredit
     * @param username
     * @param balance
     */
    private void addCredit(String username, double balance){

    }
}