import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public Database database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist firstStylist = new Stylist("Mike");
    assertTrue(firstStylist instanceof Stylist);
  }
}
