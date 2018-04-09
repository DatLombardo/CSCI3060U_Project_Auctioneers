import java.io.*;
import java.util.*;

/*import org.junit.runner.JUnitCore;
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
	/*	Result result = JUnitCore.runClasses(BackendTest.class);
		Result result2 = JUnitCore.runClasses(ItemTest.class);
		Result result3 = JUnitCore.runClasses(UserTest.class);
		Result result4 = JUnitCore.runClasses(ParserTest.class);
		Result result5 = JUnitCore.runClasses(TransactionProcessorTest.class);*/
		try{
			//this is where all the work is done
			Backend backend = new Backend(args);
			backend.doWork();
			System.out.println("backend has finished");
		}catch(IOException e){
			e.printStackTrace();
		}
		/*
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		for (Failure failure : result2.getFailures()) {
			System.out.println(failure.toString());
		}
		for (Failure failure : result3.getFailures()) {
			System.out.println(failure.toString());
		}
		for (Failure failure : result4.getFailures()) {
			System.out.println(failure.toString());
		}
		for (Failure failure : result5.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println("SUCCESSFUL TEST(Backend) RUN: " + result.wasSuccessful());
		System.out.println("SUCCESSFUL TEST(Item) RUN: " + result2.wasSuccessful());
		System.out.println("SUCCESSFUL TEST(User) RUN: " + result3.wasSuccessful());
		System.out.println("SUCCESSFUL TEST(Parser) RUN: " + result4.wasSuccessful());
		System.out.println("SUCCESSFUL TEST(TransactionProcessor) RUN: " + result5.wasSuccessful());*/
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

			ArrayList<String> transactionFile = parser.readTransactionFile(transactionPath);
			parser.splitTransactions();
			ArrayList<String> transactions = parser.transactions;
			ArrayList<String> deleteTransactions = parser.deleteTransactions;


			//Loop through transactions, update user and items
			TransactionProcessor tp = new TransactionProcessor(itemList, userList);
			for (int i = 0; i < deleteTransactions.size(); i++) {
				tp.processTransation(deleteTransactions.get(i));
			}

			for (int i = 0; i < transactions.size(); i++) {
				tp.processTransation(transactions.get(i));
			}

			parser.writeAccounts(usersPath, tp.users);
			parser.writeItems(itemsPath, tp.items);
			return true;
	}
}
