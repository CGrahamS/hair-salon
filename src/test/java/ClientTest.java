import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.sql2o.*;


public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    assertTrue(firstClient instanceof Client);
  }

}
