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
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
  public void findName_returnsStylistWithSameName_secondStylist() {
    Stylist firstStylist = new Stylist("Mike");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Brenda");
    secondStylist.save();
    assertEquals(Stylist.findName(secondStylist.getName()), secondStylist);
  }

  // @Test
  // public void update_updatesStylist_Michael() {
  //   Stylist firstStylist = new Stylist("Mike");
  //   firstStylist.save();
  //   firstStylist.update("Michael");
  //   assertEquals("Michael", firstStylist.getName());
  // }

}
