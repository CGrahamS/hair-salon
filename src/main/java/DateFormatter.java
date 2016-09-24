import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormatter {

  public static String formatDate(String oldDateFormat) {
    final String OLD_FORMAT = "yyyy-MM-dd";
    final String NEW_FORMAT = "MM/dd/yyyy";
    String formattedDate;
    SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
    //parse would not work without a try and catch
    try {
      Date date = sdf.parse(oldDateFormat);
      sdf.applyPattern(NEW_FORMAT);
      formattedDate = sdf.format(date);
      return formattedDate;
    }
    catch (Exception e) { //uncertain of what the "e" means
      return null;
    }
  }
}
