import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.sql2o.*;


public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    assertTrue(firstClient instanceof Client);
  }

  @Test
  public void getName_returnsClientName_Cathy() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    assertEquals("Cathy", firstClient.getName());
  }

  @Test
  public void getNotes_returnsClientNotes_Trim() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    assertEquals("Trim", firstClient.getNotes());
  }

  @Test
  public void getAppointment_10_30_2016() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    assertEquals("10/30/2016", firstClient.getAppointment());
  }

  @Test
  public void equals_firstClientIsSameAsSecondClient_true() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    Client secondClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_savesClientToDatabase_true() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    firstClient.save();
    assertTrue(Client.all().get(0).equals(firstClient));
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Martha", "Color", "10/30/2016", testStylist.getId());
    secondClient.save();
    assertTrue(Client.all().get(0).equals(firstClient));
    assertTrue(Client.all().get(1).equals(secondClient));
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Stylist testStylist = new Stylist("Mike");
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Martha", "Color", "10/30/2016", testStylist.getId());
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void find_returnsClientWithSameName_secondClient() {
    Stylist testStylist = new Stylist("Mike");
    testStylist.save();
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    System.out.println(testStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Martha", "Color", "10/30/2016", testStylist.getId());
    secondClient.save();
    assertEquals(Client.findName(secondClient.getName()), secondClient);
  }

  @Test
  public void update_updatesClient_Catherine() {
    Stylist testStylist = new Stylist("Mike");
    testStylist.save();
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    firstClient.save();
    firstClient.update("Catherine", "Trim and Color", "11/12/2016");
    assertEquals("Catherine", firstClient.getName());
  }

  @Test
  public void delete_deletesClient_null() {
    Stylist testStylist = new Stylist("Mike");
    testStylist.save();
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", testStylist.getId());
    firstClient.save();
    firstClient.delete();
    assertEquals(null, Client.find(firstClient.getId()));
  }

}
