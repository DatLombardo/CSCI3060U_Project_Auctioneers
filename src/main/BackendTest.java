import java.io.*;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BackendTest {

  @Test(expected = NullPointerException.class)
  public void test1()throws NullPointerException{
    //test to see if no arguments do not work
     String[] args=null;
      Backend b = new Backend(args);

  }

  @Test
  public void test2()throws NullPointerException{
    //test to see if no arguments do not work
     String[] args=new String[]{"transactionFile.txt","userlist.txt","itemlist.txt"};
      Backend b = new Backend(args);
      return;
  }


  /*  @Test
    public void test2()throws IOException{
      //test to see if no arguments do not work
       String[] args = new String[] {"transactionFile.txt","userlist.txt","itemlist.txt"};

       Backend.main(args);
    }*/
}
