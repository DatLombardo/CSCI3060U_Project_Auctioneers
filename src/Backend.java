import java.io.*;
import java.util.*;

/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  Backend.java
 */
public class Backend{
	//Containers for user and item class
	public static void main(String[] args){
		try{
			Parser parser = new Parser();
			Map<String, User> userList = parser.readUserFile("src/userlist.txt");
			Map<String, Item> itemList = parser.readItemFile("src/itemlist.txt");
			ArrayList<String> transactionFile = parser.readTransactionFile("src/transactionFile.txt");
			parser.clearFile("src/transactionFile.txt");

			/* How to Access the user and item lists.
			User currUser;
			System.out.println(userList);
			for (Map.Entry<String, User> entry : userList.entrySet()) {
				currUser = entry.getValue();
				System.out.println(currUser.getUsername() + currUser.getType() + " " + parser.fillFunds(currUser.getFunds()));
			}

			Item currItem;
			for (Map.Entry<String, Item> entry : itemList.entrySet()) {
				currItem = entry.getValue();
				System.out.println(currItem.getItemName() + currItem.getSellerName()  + currItem.getHighestBidder()
						+ parser.fillDays(currItem.getDaysToExpiry()) + " " +  parser.fillBids(currItem.getBid()));
			}
			*/
		}catch(IOException e){
		  e.printStackTrace();
		}
	}
}
