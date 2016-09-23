import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;
  private String notes;
  private String appointment_date;
  private int stylist_id;

  public Client(String name, String notes, String appointment_date, int stylist_id) {
    this.name = name;
    this.notes = notes;
    this.appointment_date = appointment_date;
    this.stylist_id = stylist_id;
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

  public int getStylistId() {
    return stylist_id;
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
             this.id == newClient.getId() &&
             this.stylist_id == newClient.getStylistId();
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
      String sql = "INSERT INTO clients (name, notes, appointment_date, stylist_id) VALUES (:name, :notes, :appointment_date, :stylist_id)";
      this.id = (int) con.createQuery(sql, true)
                         .addParameter("name", this.name)
                         .addParameter("notes", this.notes)
                         .addParameter("appointment_date", this.appointment_date)
                         .addParameter("stylist_id", this.stylist_id)
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

  public void update(String name, String notes, String appointment_date) {
    try (Connection con = DB.sql2o.open()) {
      this.name = name;
      this.notes = notes;
      this.appointment_date = appointment_date;
      String sql = "UPDATE clients SET name = :name, notes = :notes, appointment_date = :appointment_date WHERE id = :id";
      con.createQuery(sql)
         .addParameter("name", name)
         .addParameter("notes", notes)
         .addParameter("appointment_date", appointment_date)
         .addParameter("id", id)
         .executeUpdate();
    }
  }

  public void delete() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id = :id";
      con.createQuery(sql)
         .addParameter("id", id)
         .executeUpdate();
    }
  }
}
