package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionFirm {
  private List<Service> services = new ArrayList<>();

  public double profit(ConstructionSite constructionSite) {
    return constructionSite.getProfit();
  }

  public void report(ConstructionSite constructionSite, String serviceName, String material, double singlePrice, double quantity) {
    Service service = new Service(serviceName);
    service.addMaterial(new Material(material, singlePrice, quantity));
    constructionSite.report(service);
  }

  public void addService(Service service) {
    services.add(service);
  }

  public void addToProject(ConstructionSite constructionSite, String serviceName, double quantity) {
    int index = services.indexOf(new Service(serviceName));
    Service service = services.get(index);
    service.setQuantity(quantity);
    constructionSite.addToProject(service);
  }


  public void report(ConstructionSite constructionSite, String serviceName, double singlePrice, double quantity) {
    Service service= new Service(serviceName);
    service.addEmploye(new Employe(singlePrice));
    service.setQuantity(quantity);
    constructionSite.report(service);
  }
}
