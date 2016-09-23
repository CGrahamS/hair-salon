import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;
  private String notes;
  private String appointment_date;
  private int stylist_id;

  public Client(String name, String notes, String appointment_date) {
    this.name = name;
    this.notes = notes;
    this.appointment_date = appointment_date;
  }

  public String getName() {
    return name;
  }

  public String getNotes() {
    return notes;
  }
}
