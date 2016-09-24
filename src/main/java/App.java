
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Arrays;


public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    String header = "templates/header.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("title", "Salon Dion");
      model.put("stylists", Stylist.all());
      model.put("header", header);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylist/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Stylist newStylist = new Stylist(name);
      newStylist.save();
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:name/:id/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(request.params(":name"), Integer.parseInt(request.params(":id")));
      model.put("title", stylist.getName() + "'s Clients");
      model.put("clients", stylist.getClients());
      model.put("header", header);
      model.put("stylist", stylist);
      model.put("template", "templates/stylist-details.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/:name/:id/client/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(request.params(":name"), Integer.parseInt(request.params(":id")));
      String name = request.queryParams("name");
      String notes = request.queryParams("notes");
      String appointment_date = request.queryParams("appointment_date");
      Client newClient = new Client(name, notes, appointment_date, stylist.getId());
      newClient.save();
      String url ="/" + stylist.getName() + "/" + stylist.getId() + "/clients";
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:name/:id/:client_name/:client_id/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(request.params(":name"), Integer.parseInt(request.params(":id")));
      Client client = Client.find(request.params(":client_name"), Integer.parseInt(request.params(":client_id")));
      model.put("title", client.getName()+ "'s Details");
      model.put("header", header);
      model.put("stylist", stylist);
      model.put("client", client);
      model.put("template", "templates/client-details.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/:name/:id/:client_name/:client_id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(request.params(":name"), Integer.parseInt(request.params(":id")));
      Client client = Client.find(request.params(":client_name"), Integer.parseInt(request.params("client_id")));
      String name = request.queryParams("name");
      String notes = request.queryParams("notes");
      String appointment_date = request.queryParams("appointment_date");
      client.update(name, notes, appointment_date);
      String url ="/" + stylist.getName() + "/" + stylist.getId() + "/" + client.getName() + "/" + client.getId() + "/edit";
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
