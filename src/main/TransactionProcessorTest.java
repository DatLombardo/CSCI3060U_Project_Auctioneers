import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.*;


public class TransactionProcessorTest {

    @Test
    public void test1() {
      //test that the Constructor is valid
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
    	TransactionProcessor tp = new TransactionProcessor(items, users);
      return;
    }

    //does it do anything?  it shouldn't
    @Test
    public void test2(){
      //test logout is covered
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      TransactionProcessor tp = new TransactionProcessor(items, users);
      String logout = "00 user01          FS 090000.00";
      tp.processTransation(logout);
      assertEquals(items,tp.items);
      assertEquals(users,tp.users);
    }

    //does it do anything?  it shouldn't
    @Test
    public void test3(){
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      //test login is covered
      TransactionProcessor tp = new TransactionProcessor(items, users);
      String login = "10 user01          FS 090000.00";
      tp.processTransation(login);
      assertEquals(items,tp.items);
      assertEquals(users,tp.users);
    }

    //check that users contains the new user
    @Test
    public void test4(){
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      //test create is covered
      TransactionProcessor tp = new TransactionProcessor(items, users);
      String create = "01 Admin02         AA 000100.00";
      User user= new User("Admin02         AA 0000100.00");
      tp.processTransation(create);
      assertEquals(user,tp.users.get(user.getUsername()));
    }


    //test that users and items have removed the right itesm
    @Test
    public void test5(){
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      User user= new User("user01          FS 0000900.00");
      Item item = new Item("itemName3                 user01          Admin01         020 030.00");
      users.put("user01", user);
      items.put("itemName3"+"user01", item);
      //make sure in the map
      assertEquals(user,users.get(user.getUsername()));
      assertEquals(items,items.get(item.getItemName()));

      //test delete is covered
      TransactionProcessor tp = new TransactionProcessor(items, users);
      String delete = "02 user01          FS 000900.00";
      tp.processTransation(delete);

      assertNotEquals(user,tp.users.get(user.getUsername()));
      assertNotEquals(item,tp.items.get(item.getItemName()));
    }

    //test that a new item is created
    @Test
    public void test6(){
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      Item item = new Item("itemName3                 user01          Admin01         020 030.00");
      items.put("itemName3"+"user01", item);
      //test advertise is covered
      TransactionProcessor tp = new TransactionProcessor(items, users);
      String advertise = "03 Item01              Admin01         005   015.00";
      tp.processTransation(advertise);
      assertEquals(item,tp.items.get(item.getItemName()));
    }

    @Test
    public void test7(){
      //test the item is updated
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      TransactionProcessor tp = new TransactionProcessor(items, users);
      Item item = new Item("itemName3                 user01          Admin01         020 030.00");
      items.put("itemName3"+"user01", item);
      //test advertise is covered
      String advertise = "03 Item01              Admin01         005   015.00";
      tp.processTransation(advertise);
      String bid = "04 Item01                   Admin01         user01          200.00";
      tp.processTransation(bid);
      assertEquals(200.00,tp.items.get(item.getItemName()).getBid());

    }

    @Test
    public void test8(){
      //test that user has more money in their account
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      User user= new User("Admin02         AA 0000100.00");
      users.put(user.getUsername(),user);
      TransactionProcessor tp = new TransactionProcessor(items, users);
      String refund = "05 Admin02         seller01        000500.00";
      tp.processTransation(refund);
      assertEquals(user.getFunds() + 500.00,tp.users.get(user.getUsername()).getFunds());
    }

    @Test
    public void test9(){
      //test addCredit is covered
      Map<String, Item> items= new HashMap<String, Item>();
      Map<String, User> users= new HashMap<String, User>();
      User user= new User("User01          AA 0000100.00");
      users.put(user.getUsername(),user);
      TransactionProcessor tp = new TransactionProcessor(items, users);
      String addCredit = "06 User01          FS 000500.00";
      tp.processTransation(addCredit);
      assertEquals(user.getFunds() + 500.00,tp.users.get(user.getUsername()).getFunds());

    }



}
