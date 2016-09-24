import java.util.Date;
import java.text.SimpleDateFormat;
import org.junit.*;
import static org.junit.Assert.*;

public class DateFormatterTest {

  @Test
  public void formatDate_formatsDateTo_MM_dd_yyyy_11_12_1990() {
    Stylist testStylist = new Stylist("Mike");
    testStylist.save();
    Client firstClient = new Client("Cathy", "Trim", "1990-11-12", testStylist.getId());
    firstClient.save();
    String formattedDate = DateFormatter.formatDate(firstClient.getAppointment());
    assertEquals("11/12/1990", formattedDate);
  }
}
