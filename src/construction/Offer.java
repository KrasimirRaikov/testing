package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Offer {
  private List<Service> services= new ArrayList<>();
  private List<Requirement> requirements= new ArrayList<>();
  private double price;

  public Offer(double price) {

    this.price = price;
  }

  public Offer(List<Requirement> requirements, List<Service> services) {
    this.requirements= requirements;
    this.services=services;
    this.price= updatePrice();
  }

  private double updatePrice() {
    double sum=0;
    for (Requirement requirement: requirements){
      sum+= requirement.getQuantity()*services.get(services.indexOf(new Service(requirement.getName(), 0, Measure.SQUARE_METER))).getPrice();
    }
    return sum;
  }

  public double price() {
    return price;
  }
}
