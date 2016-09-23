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

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getNotes() {
    return notes;
  }

  public String getAppointment() {
    return appointment_date;
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.name.equals(newClient.getName()) &&
             this.notes.equals(newClient.getNotes()) &&
             this.appointment_date.equals(newClient.getAppointment()) &&
             this.id == newClient.getId();
    }
  }
}
