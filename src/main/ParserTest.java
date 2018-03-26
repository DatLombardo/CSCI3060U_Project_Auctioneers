import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io;

public class ParserTest {
    @Test
    public void test1() {
      //Statement Coverage for clearFile
      Parser parser = new Parser();
      File f = new File("testFile.txt");
      parser.clearFile();
      assertEquals(f.exists(), true);
    }
    @Test
    public void test2() {
      //Loop Coverage for writeAccounts (0)
      Parser parser = new Parser();
      Map<String, User> userList = new HashMap<String, User>();
      parser.writeAccounts("userlist.txt", userList);
      return;
    }
    @Test
    public void test3() {
      //Loop Coverage for writeAccounts (1)
      Parser parser = new Parser();
      Map<String, User> userList = new HashMap<String, User>();
      User u1 = new User("username01      FS 010000.00");
      userList.put(parser.removeSpaceFill(u1.getUsername()), u1);
      parser.writeAccounts("userlist.txt", userList);
      return;
    }
    @Test
    public void test4() {
      //Loop Coverage for writeAccounts (2)
      Parser parser = new Parser();
      Map<String, User> userList = new HashMap<String, User>();
      User u1 = new User("username01      FS 010000.00");
      User u2 = new User("admin01         AA 090090.00");
      userList.put(parser.removeSpaceFill(u1.getUsername()), u1);
      userList.put(parser.removeSpaceFill(u2.getUsername()), u2);
      parser.writeAccounts("userlist.txt", userList);
      return;
    }
    @Test
    public void test5() {
      //Loop Coverage for writeAccounts (many)
      Parser parser = new Parser();
      Map<String, User> userList = new HashMap<String, User>();
      User u1 = new User("username01      FS 010000.00");
      User u2 = new User("admin01         AA 090090.00");
      User u3 = new User("username02      BS 010000.00");
      userList.put(parser.removeSpaceFill(u1.getUsername()), u1);
      userList.put(parser.removeSpaceFill(u2.getUsername()), u2);
      userList.put(parser.removeSpaceFill(u3.getUsername()), u3);
      parser.writeAccounts("userlist.txt", userList);
      return;
    }
    @Test
    public void test6() {
      //Loop Coverage for writeItems (0)
      Parser parser = new Parser();
      Map<String, Item> itemList = new HashMap<String, Item>();
      parser.writeItems("itemlist.txt", itemList);
      return;
    }
    @Test
    public void test7() {
      //Loop Coverage for writeItems (1)
      Parser parser = new Parser();
      Map<String, Item> itemList = new HashMap<String, Item>();
      Item newItem1 = new Item("itemspew01                seller01        username01      002 0010.00");
      String newKey1 = parser.removeSpaceFill(newItem1.getItemName()) + parser.removeSpaceFill(newItem1.getSellerName());
      itemList.put(newKey1, newItem1);
      parser.writeItems("itemlist.txt", itemList);
      return;
    }
    @Test
    public void test8() {
      //Loop Coverage for writeItems (2)
      Parser parser = new Parser();
      Map<String, Item> itemList = new HashMap<String, Item>();
      Item newItem1 = new Item("itemspew01                seller01        username01      002 0010.00");
      String newKey1 = parser.removeSpaceFill(newItem1.getItemName()) + parser.removeSpaceFill(newItem1.getSellerName());
      Item newItem2 = new Item("itemspew02                seller01        admin01         006 0050.00");
      String newKey2 = parser.removeSpaceFill(newItem2.getItemName()) + parser.removeSpaceFill(newItem2.getSellerName());
      itemList.put(newKey1, newItem1);
      itemList.put(newKey2, newItem2);
      parser.writeItems("itemlist.txt", itemList);
      return;
    }
    @Test
    public void test9() {
      //Loop Coverage for writeItems (many)
      Parser parser = new Parser();
      Map<String, Item> itemList = new HashMap<String, Item>();
      Item newItem1 = new Item("itemspew01                seller01        username01      002 0010.00");
      String newKey1 = parser.removeSpaceFill(newItem1.getItemName()) + parser.removeSpaceFill(newItem1.getSellerName());
      Item newItem2 = new Item("itemspew02                seller01        admin01         006 0050.00");
      String newKey2 = parser.removeSpaceFill(newItem2.getItemName()) + parser.removeSpaceFill(newItem2.getSellerName());
      Item newItem3 = new Item("pentax                    seller01        username02      012 0300.00");
      String newKey3 = parser.removeSpaceFill(newItem3.getItemName()) + parser.removeSpaceFill(newItem3.getSellerName());
      itemList.put(newKey1, newItem1);
      itemList.put(newKey2, newItem2);
      itemList.put(newKey3, newItem3);
      parser.writeItems("itemlist.txt", itemList);
      return;
    }
    @Test
    public void test10() {
      //Loop Coverage for splitTransactions (0)
      Parser parser = new Parser();
      //Empty transaction file.
      parser.splitTransactions();
      return;
    }
    @Test
    public void test11() {
      //Loop Coverage for splitTransactions (1)
      Parser parser = new Parser();
      parser.transactionFile.add("10 admin01         AA 090090.00");
      parser.splitTransactions();
      return;
    }
    @Test
    public void test12() {
      //Loop Coverage for splitTransactions (2)
      Parser parser = new Parser();
      parser.transactionFile.add("10 admin01         AA 090090.00");
      parser.transactionFile.add("02 user01          FS 000900.00");
      parser.splitTransactions();
      return;
    }
    @Test
    public void test13() {
      //Loop Coverage for splitTransactions (many)
      Parser parser = new Parser();
      parser.transactionFile.add("10 admin01         AA 090090.00");
      parser.transactionFile.add("02 user01          FS 000900.00");
      parser.transactionFile.add("00 admin01         AA 090090.00");
      parser.splitTransactions();
      return;
    }
    @Test
    public void test14() {
      //Statement coverage for removeSpaceFill
      Parser parser = new Parser();
      String tester = parser.removeSpaceFill("admin01        ");
      assertEquals(tester, "admin01");
    }

    @Test
    public void test15() {
      //Statement coverage for fillFunds
      Parser parser = new Parser();
      String tester = parser.fillFunds(5.00);
      assertEquals(tester, "000005.00");
    }

    @Test
    public void test16() {
      //Statement coverage for fillBids
      Parser parser = new Parser();
      String tester = parser.fillBids(300.00);
      assertEquals(tester, "0300.00");
    }
    @Test
    public void test17() {
      //Statement coverage for fillDays
      Parser parser = new Parser();
      String tester = parser.fillDays(12);
      assertEquals(tester, "012");
    }
}
