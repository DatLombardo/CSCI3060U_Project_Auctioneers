import java.io.*;
import java.util.*;
//completly untested
public class TransactionProcessor{
    public void TransactionProcessor(String line, Map<String, Item> items, Map<String, User> users){
        int action=Integer.parseInt(line.substring(0,2));
        Parser parser = new Parser();
        switch(action){
            case 0:
                //logout
                break;
            case 10;
                //login
                break;
            case 1:
                //create
                String username=line.substring(3,18);
                String type=line.substring(19,21);
                double credit=Double.parseDouble(line.substring(22,31));
                create(username,type,credit);
                break;
            case 2:
                //delete
                String username=line.substring(3,18);
                delete(username);
                break;
            case 3:
                //advertise
                String seller=line.substring(3,22);
                String itemname=line.substring(23,36);
                double bid=Double.parseDouble(line.substring(41,47));
                int days=Integer.parseInt(line.substring(37,40));
                advertise(seller,itemname,bid,days);
                break;
            case 4:
                //bid
                String seller=line.substring(23,37);
                String buyer=line.substring(39,53);
                String itemname=line.substring(3,22);
                double bid=Double.parseDouble(line.substring(54,60));
                bid(seller,buyer,itemname,bid);
                break;
            case 5:
                //refund
                String seller=line.substring(19,34);
                String buyer=line.substring(3,18);
                double amountDouble.parseDouble(line.substring(35,44));
                refund(seller,buyer,amount);
                break;
            case 6:
                //addCredit
                String username=line.substring(3,18);
                double credit=Double.parseDouble(line.substring(22,31));
                addCreadit(username,balance);
                break;
        }
    }
    public void processTransation(){

    }
    private void create(String username, String type, double credit){

    }
    private void delete(String username){
        users.remove("username")
    }
    private void advertise(String seller, String itemname, double bid, int days){

    }
    private void bid(String seller, String buyer, String itemname, double bid){

    }
    private void refund(String seller, String buyer, double amount){

    }
    private void addCreadit(String username, double balance){

    }
}