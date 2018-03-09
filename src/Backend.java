import java.io.*;
import java.util.*;

public class Backend{
	//Containers for user and item class
	public static void main(String[] args){
		try{
			Parser parser = new Parser();
			Map<String, User> userList = parser.readUserFile("src/userlist.txt");
			Map<String, Item> itemList = parser.readItemFile("src/itemlist.txt");
			for (Map.Entry<String, User> entry : userList.entrySet()) {
				System.out.println(entry.getKey() + "\t");
			}
			System.out.println(userList.get("username01"));
		}catch(IOException e){
		  e.printStackTrace();
		}
	}
}
