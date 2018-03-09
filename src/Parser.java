import java.io.*;
import java.util.*;

public class Parser{
  public Map<String, User> userList = new HashMap<String, User>();
  public Map<String, Item> itemList = new HashMap<String, Item>();
  public Parser(){ }
  public Map<String, User> readUserFile(String path) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(path));
        String line = "";
        while ((line = in.readLine()) != null) {
            User newUser = new User(line);
            this.userList.put(removeSpaceFill(newUser.getUsername()), newUser);
        }
        in.close();
        return this.userList;
	}

	public Map<String, Item> readItemFile(String path) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(path));
        String line = "";
        while ((line = in.readLine()) != null) {
            Item newItem = new Item(line);
            String newKey = removeSpaceFill(newItem.getItemName()) + removeSpaceFill(newItem.getSellerName());
            this.itemList.put(newKey, newItem);
    }
        in.close();
        return this.itemList;
	}

    public String removeSpaceFill(String input){
        if( input == null)
            return null;
        int len = input.length();
        for( ; len > 0; len--){
            if( ! Character.isWhitespace( input.charAt( len - 1)))
                break;
        }
        return input.substring( 0, len);
    }
}
