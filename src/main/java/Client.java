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

  public static List<Client> all() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients";
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, notes, appointment_date) VALUES (:name, :notes, :appointment_date)";
      this.id = (int) con.createQuery(sql, true)
                         .addParameter("name", name)
                         .addParameter("notes", notes)
                         .addParameter("appointment_date", appointment_date)
                         .executeUpdate()
                         .getKey();
    }
  }

  public static Client find(int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id = :id";
      Client client = con.createQuery(sql)
                           .addParameter("id", id)
                           .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public static Client findName(String name) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE name = :name";
      Client client = con.createQuery(sql)
                           .addParameter("name", name)
                           .executeAndFetchFirst(Client.class);
      return client;
    }
  }
}
