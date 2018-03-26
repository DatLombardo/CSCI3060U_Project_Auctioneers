import org.junit.jupiter.api.Test;


class BackendTest {

    @Test
    void main() {
      //test to see if no arguments do not work
      System.out.println("main");
       String[] args = null;
       Main.main(args);
       assertNotNULL(args);
    }
}
