import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private int id;
  private String name;

  public Stylist(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.id == newStylist.getId();
    }
  }
  //should I build save or all first?
  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }

  public static List<Stylist> all() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists";
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public static Stylist find(int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id = :id";
      Stylist stylist = con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Stylist.class);
      return stylist; //how do I get a test like this to fail appropriately?
    }
  }

  public static Stylist findName(String name) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE name = :name";
      Stylist stylist = con.createQuery(sql).addParameter("name", name).executeAndFetchFirst(Stylist.class);
      return stylist; //check if you need this to display stylist name in app
    }
  }

}
