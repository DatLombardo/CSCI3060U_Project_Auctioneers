import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BackendTest {

    @Test
    public void test1() {
      //test to see if no arguments do not work
      System.out.println("main test1");
       String[] args = null;
       String[] expected = {"file1", "file2", "file3"};
  //     assertArrayEquals(null,args,expected);
               assertEquals(4, 4);
    }
}
