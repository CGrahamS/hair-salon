import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.sql2o.*;


public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist firstStylist = new Stylist("Mike");
    assertTrue(firstStylist instanceof Stylist);
  }

  @Test
  public void getName_returnsStylistName_Mike() {
    Stylist firstStylist = new Stylist("Mike");
    assertEquals("Mike", firstStylist.getName());
  }

  @Test //Should I even test for this before creating a save method?
  public void getId_returnsStylistId_id() {
    Stylist firstStylist = new Stylist("Mike");
    int id = firstStylist.getId();
    assertEquals(id, firstStylist.getId());
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame() {
    Stylist firstStylist = new Stylist("Mike");
    Stylist secondStylist = new Stylist("Mike");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Mike");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Brenda");
    secondStylist.save();
    assertTrue(Stylist.all().get(0).equals(firstStylist));
    assertTrue(Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void getClients_returnsAllClientsWithSameStylistId_true() {
    Stylist firstStylist = new Stylist("Mike");
    firstStylist.save();
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", firstStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Martha", "Color", "10/30/2016", firstStylist.getId());
    secondClient.save();
    assertTrue(firstStylist.getClients().get(0).equals(firstClient));
    assertTrue(firstStylist.getClients().get(1).equals(secondClient));
  }

  @Test
  public void save_savesStylistInDatabase_true() {
    Stylist firstStylist = new Stylist("Mike");
    firstStylist.save();
    assertTrue(Stylist.all().get(0).equals(firstStylist));
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Mike");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Brenda");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getName(), secondStylist.getId()), secondStylist);
  }

  @Test
  public void update_updatesStylist_Michael() {
    Stylist firstStylist = new Stylist("Mike");
    firstStylist.save();
    firstStylist.update("Michael");
    assertEquals("Michael", firstStylist.getName());
  }

  @Test
  public void delete_deletesStylistAndTheirClients_null() {
    Stylist firstStylist = new Stylist("Mike");
    firstStylist.save();
    Client firstClient = new Client("Cathy", "Trim", "10/30/2016", firstStylist.getId());
    firstClient.save();
    firstStylist.delete();
    assertEquals(null, firstClient.find(firstClient.getName(), firstClient.getId()));
    assertEquals(null, firstStylist.find(firstStylist.getName(), firstStylist.getId()));
  }

}
