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

  @Test //Should I even test for this before saving?
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

}
