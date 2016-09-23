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

  @Test
  public void getName_returnsClientName_Cathy() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    assertEquals("Cathy", firstClient.getName());
  }

  @Test
  public void getNotes_returnsClientNotes_Trim() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    assertEquals("Trim", firstClient.getNotes());
  }

  @Test
  public void getAppointment_10_30_2016() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    assertEquals("10/30/2016", firstClient.getAppointment());
  }

}
