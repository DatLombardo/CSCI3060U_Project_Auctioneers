
import java.io.*;
import java.util.*;

/*
  Auctioneers
  Michael Lombardo, Joseph Robertson, Michael Setnyk
  Parser.java
 */
public class Parser{
    //Container definition.
  public Map<String, User> userList = new HashMap<String, User>();
  public Map<String, Item> itemList = new HashMap<String, Item>();
  public ArrayList<String> transactionFile = new ArrayList<String>();

  public ArrayList<String> transactions = new ArrayList<String>();
  public ArrayList<String> deleteTransactions = new ArrayList<String>();

    /**
     * Default General Constructor for Parser class, defined to allow for system to use Parser anywhere.
     */
  public Parser(){ }

    /**
     * readUserFile
     * Reads in user file and stores all user instances into userList map.
     * @param path
     * @return userList map holding all instances of Users with key (username [unfilled])
     * @throws IOException
     */
  public Map<String, User> readUserFile(String path) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(path));
        String line;
        while ((line = in.readLine()) != null) {
            User newUser = new User(line);
            this.userList.put(removeSpaceFill(newUser.getUsername()), newUser);
        }
        in.close();
        return this.userList;
	}

    /**
     * readItemFile
     * Reads in item file and stores all item instances into itemList map.
     * @param path
     * @return itemList map holding all instances of Items with key (itemName+sellerName [unfilled])
     * @throws IOException
     */
	public Map<String, Item> readItemFile(String path) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(path));
        String line;
        while ((line = in.readLine()) != null) {
            Item newItem = new Item(line);
            String newKey = removeSpaceFill(newItem.getItemName()) + removeSpaceFill(newItem.getSellerName());
            this.itemList.put(newKey, newItem);
        }
        in.close();
        return this.itemList;
	}

    /**
     * readTransactionFile
     * Reads in daily transaction file and stores into transactionFile arrayList.
     * @param path
     * @return arrayList of dailyTransaction file requests
     * @throws IOException
     */
	public ArrayList<String> readTransactionFile(String path) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(path));
        String line = "";
        while ((line = in.readLine()) != null) {
            this.transactionFile.add(line);
        }
        in.close();
        return this.transactionFile;
    }

    /**
     *  clearFile
     *  Called to remove contents from any file passed.
     * @param path - desired path to file of removal
     * @throws IOException
     */
    public void clearFile(String path) throws IOException{
        PrintWriter writer = new PrintWriter(path);
        writer.print("");
        writer.close();
    }

    /**
     * writeAccounts
     * Called to write Current User Accounts file after all user accounts manipulation is complete.
     * Assumes that the file is empty, need to call clearFile
     * Format: UUUUUUUUUUUUUUU_TT_CCCCCCCCC
     * @param path - desired path for write
     * @throws IOException
     */
    public void writeAccounts(String path) throws IOException{
        File writer = new File(path);
        FileOutputStream fileOut = new FileOutputStream(writer);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOut));

        User currUser;
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            currUser = entry.getValue();
            bw.write(currUser.userFileString());
            bw.newLine();
        }
        bw.close();

    }

    /**
     * writeItems
     * Called to write Availiable Items File
     * Assumes that the file is empty, need to call clearFile.
     * Format: IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUU_DDD_PPPPPP
     * @param path - desired path for write
     * @throws IOException
     */
    public void writeItems(String path) throws IOException{
        File writer = new File(path);
        FileOutputStream fileOut = new FileOutputStream(writer);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOut));

        Item currItem;
        for (Map.Entry<String, Item> entry : this.itemList.entrySet()) {
            currItem = entry.getValue();
            bw.write(currItem.itemFileString());
            bw.newLine();
        }
        bw.close();

    }

    /**
     * removeSpaceFill
     * Removes extra spacing from the end of usernames / itemnames to allow for key generation for the
     * itemList and userList.
     * @param input - arguement to be trimmed.
     * @return trimmed input.
     */
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

    /**
     * fillFunds
     * Called to add additional zeroes to the left-side of the funds value for file writing.
     * @param input
     * @return
     */
    public String fillFunds(double input){
        String filledInput = String.format("%09.2f", input);
        return filledInput;
    }

    /**
     * fillBids
     * Called to add additional zeroes to the left-side of the bid value for file writing.
     * @param input
     * @return
     */
    public String fillBids(double input){
        String filledInput = String.format("%07.2f", input);
        return filledInput;
    }

    /**
     * fillDays
     * Called to add additional zeroes to the left-side of the daysToExpiry value for file writing.
     * @param input
     * @return
     */
    public String fillDays(int input){
        String filledInput = String.format("%03d", input);
        return filledInput;
    }

    /**
     * splitTransactions
     * used to break up delete transactions and non-delete transactions
     * such that all deletes are handled before anything else.
     *
     */

    public void splitTransactions() throws IOException {
        for (int i = 0; i < transactionFile.size(); i++) {
            System.out.println(transactionFile.get(i));
            int action = Integer.parseInt(transactionFile.get(i).substring(0,2));
            if (action == 2) {
                this.deleteTransactions.add(transactionFile.get(i));
            }
            else {
                  this.transactions.add(transactionFile.get(i));
            }
        }
    }
}
