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

  @Test
  public void equals_firstClientIsSameAsSecondClient_true() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    Client secondClient = new Client("Cathy", "Trim", "10/30/2016");
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_savesClientToDatabase_true() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    firstClient.save();
    assertTrue(Client.all().get(0).equals(firstClient));
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    firstClient.save();
    Client secondClient = new Client("Martha", "Color", "10/30/2016");
    secondClient.save();
    assertTrue(Client.all().get(0).equals(firstClient));
    assertTrue(Client.all().get(1).equals(secondClient));
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    firstClient.save();
    Client secondClient = new Client("Martha", "Color", "10/30/2016");
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void find_returnsClientWithSameName_secondClient() {
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016");
    firstClient.save();
    Client secondClient = new Client("Martha", "Color", "10/30/2016");
    secondClient.save();
    assertEquals(Client.findName(secondClient.getName()), secondClient);
  }

}
