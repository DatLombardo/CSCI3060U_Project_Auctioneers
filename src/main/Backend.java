package main;
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
			if(args.length!=3){
				System.out.println("Please enter a transaction file,  user file, then a items file");
				return;
			}
			String transactionPath = args[0];
			String usersPath = args[1];
			String itemsPath = args[2];


			Parser parser = new Parser();

			//Read in the files
			Map<String, User> userList = parser.readUserFile(usersPath);
			Map<String, Item> itemList = parser.readItemFile(itemsPath);
			//
			ArrayList<String> transactionFile = parser.readTransactionFile(transactionPath);

			//Clear the transaction file
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

			//Loop through transactions, update user and items
			TransactionProcessor tp = new TransactionProcessor();


		}catch(IOException e){
		  e.printStackTrace();
		}
	}
}
