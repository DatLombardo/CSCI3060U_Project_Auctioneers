import java.io.*;
import java.util.*;

/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  Backend.java

  This program is the backend for an auction house system.
  A merged transaction file, user file and items file (in that order)
  are all sent in as arguments to the auction house system
  The system applies changes made to the user and items files
  Changes are specifed in the transaction file.  All changes are
  recorded in the system when a login transaction is read in.
  Changes are official when a logout transaction is read.
  If a user is deleted before they make any transactions then those
  transactions will never exist.
 */
public class Backend{
	//Containers for user and item class
	public static void main(String[] args){
		try{
			if(args.length!=3){
				System.out.println("Please enter a transaction file,  user file, then a items file");
				return;
			}
			String transactionPath = args[0];
			String usersPath = args[1];
			String itemsPath = args[2];


			Parser parser = new Parser();
			Map<String, User> userList = parser.readUserFile(usersPath);
			Map<String, Item> itemList = parser.readItemFile(itemsPath);
			ArrayList<String> transactionFile = parser.readTransactionFile(transactionPath);
			parser.clearFile(transactionPath);

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
		}catch(IOException e){
		  e.printStackTrace();
		}
	}
}
