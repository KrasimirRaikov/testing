package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionSite {

  private List<Service> reports= new ArrayList<>();
  private List<Service> project = new ArrayList<>();

  public ConstructionSite(String name) {
  }

  public double getProfit() {
    return projectPrice()-expenses();
  }

  private double projectPrice() {
    double result=0;

    for (Service service: project){
      result+=service.getQuantifiedPrice();
    }
    return result;
  }

  private double expenses() {
    double result=0;

    for (Service service: reports){
      result+=service.getQuantifiedPrice();
    }
    return result;
  }

  public void report(Service service) {
    reports.add(service);
  }

  public void addToProject(Service service) {
    project.add(service);
  }
}
