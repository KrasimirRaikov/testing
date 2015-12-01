package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Offer {
  private final ConstructionSite site;
  private List<Service> services = new ArrayList<>();
  private List<Requirement> requirements = new ArrayList<>();
  private double price;


  public Offer(ConstructionSite site, List<Service> services) {
    this.site = site;
    this.requirements = site.getRequirements();
    this.services = services;
    this.price = updatePrice();
  }

  private double updatePrice() {
    double sum = 0;
    for (Requirement requirement : requirements) {
      sum += requirement.getQuantity() * services.get(services.indexOf(new Service(requirement.getName(), 0, Measure.SQUARE_METER))).getPrice();
      sum += requirement.getTransportStorage() + requirement.getMechanisation();
    }
    return sum;
  }

  public double price() {
    return price;
  }
}
