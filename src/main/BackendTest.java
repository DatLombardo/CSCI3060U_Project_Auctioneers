import java.io.*;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BackendTest {

  @Test(expected = IOException.class)
  public void test1()throws IOException{
    //test to see if null arguments are rejected
     String[] args=null;
      Backend b = new Backend(args);
  }

  @Test
  public void test2()throws IOException{
    //test to see if 3 arguments work
     String[] args=new String[]{"transactionFile.txt","userlist.txt","itemlist.txt"};
      Backend b = new Backend(args);
      assertEquals(args.length,3);
  }

  @Test(expected = IOException.class)
  public void test3()throws IOException{
    //test to see if not three arguments work
     String[] args = new String[] {"transactionFile.txt"};
     Backend b = new Backend(args);
     assertFalse("should not be right",false);
  }



}
