import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void test1() {
	Item A = new Item("kite surfing set          seller01        username01      014 0300.00");
	assertEquals("kite surfing set         ", A.getItemName());
    }
    @Test
    public void test2() {
	Item A = new Item("kite surfing set          seller01        username01      014 0300.00");
	assertEquals("seller01       ", A.getSellerName());
    }
    @Test
    public void test3() {
	Item A = new Item("kite surfing set          seller01        username01      014 0300.00");
	assertEquals("username01     ", A.getHighestBidder());
    }
    @Test
    public void test4() {
	Item A = new Item("kite surfing set          seller01        username01      014 0300.00");
	assertEquals(14, A.getDaysToExpiry());
    }
    @Test
    public void test5() {
	Item A = new Item("kite surfing set          seller01        username01      014 0300.00");
	assertTrue(300.0==A.getBid());
    }
    @Test
    public void test6() {
	Item A = new Item("kite surfing set          seller01        username01      014 0300.00");
	A.setHighestBidder("newBidder     ", 400.0);
	assertTrue((400.0 == A.getBid()) && (A.getHighestBidder().equals("newBidder     ")));
    }
    @Test
    public void test7() {
	Item A = new Item("kite surfing set          seller01        username01      014 0300.00");
	assertEquals("kite surfing set          seller01        username01      014 0300.00", A.itemFileString());
    }
}
