import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void test1() {
	User A = new User("admin01         AA 090090.00");
	assertEquals("admin01        ", A.getUsername());
    }
    @Test
    public void test2() {
	User A = new User("admin01         AA 090090.00");
	assertEquals("AA", A.getType());
    }
    @Test
    public void test3() {
	User A = new User("admin01         AA 090090.00");
	assertTrue(90090.0 == A.getFunds());
    }
    @Test
    public void test4() {
	User A = new User("admin01         AA 090090.00");
	A.setFunds(14.0);
	assertTrue(14.0 == A.getFunds());
    }
    @Test
    public void test7() {
	User A = new User("admin01         AA 090090.00");
	assertEquals("admin01         AA 090090.00", A.userFileString());
    }
}
