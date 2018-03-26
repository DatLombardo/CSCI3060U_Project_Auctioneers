import java.io.*;
import java.util.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  Backend.java
 */

public class Backend{
	//Containers for user and item class
	public static void main(String[] args)  throws NullPointerException{
		Result result = JUnitCore.runClasses(BackendTest.class);
		Result result2 = JUnitCore.runClasses(ItemTest.class);
		Result result3 = JUnitCore.runClasses(UserTest.class);
		try{
			Backend backend = new Backend(args);
			backend.doWork();
		}catch(IOException e){
			e.printStackTrace();
		}
		for (Failure failure : result.getFailures()) {
		System.out.println(failure.toString());
		}

		System.out.println("SUCCESSFUL TEST RUN: " + result.wasSuccessful());
	}


	String transactionPath;
	String usersPath;
	String itemsPath;

	public Backend(String[] args)throws IOException{
		if(args == null || args.length!=3){
			System.out.println("Please enter a transaction file,  user file, then a items file");
			throw new IOException();
		}
		transactionPath = args[0];
		usersPath = args[1];
		itemsPath = args[2];

	}

	private Boolean doWork() throws IOException{
			Parser parser = new Parser();
			//Read in the files
			Map<String, User> userList = parser.readUserFile(usersPath);
			Map<String, Item> itemList = parser.readItemFile(itemsPath);
			//
			ArrayList<String> transactionFile = parser.readTransactionFile(transactionPath);
			parser.splitTransactions();
			ArrayList<String> transactions = parser.transactions;
			ArrayList<String> deleteTransactions = parser.deleteTransactions;

			//Clear the transaction file
			//parser.clearFile(transactionPath);

			//Loop through transactions, update user and items
			TransactionProcessor tp = new TransactionProcessor(itemList, userList);
			for (int i = 0; i < deleteTransactions.size(); i++) {
				tp.processTransation(deleteTransactions.get(i));
			}
			for (int i = 0; i < transactions.size(); i++) {
				tp.processTransation(transactions.get(i));
			}

			parser.writeAccounts("userlist.txt", tp.users);
			parser.writeItems("itemlist.txt", tp.items);
			return true;
	}
}
