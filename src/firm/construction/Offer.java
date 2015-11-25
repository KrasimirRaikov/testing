package firm.construction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Offer {

  private List<Service> services = new ArrayList<>();

  /**
   * Adds services to a List which represents the offer
   *
   * @param servicess the services to be added
   */
  public void addToOffer(Service... servicess) {
    Collections.addAll(services, servicess);
  }

  /**
   * Calculates the total price of the offer
   *
   * @return the total price
   */
  public double getTotalPrice() {
    double sum = 0;
    for (Service service : services) {
      sum += service.getPrice();
    }
    return sum;
  }


  /**
   * Get's the price of a single service
   *
   * @param serviceName the name of the service
   * @return the price of the service
   */
  public double getServicePrice(String serviceName) {
    return services.get(services.indexOf(new Service(serviceName))).getPrice();
  }

  /**
   * Gets the entire offer ready for printing
   *
   * @return a string which is the offer
   */
  public String printOffer() {
    String message = "";
    String separator = System.getProperty("line.separator");
    for (Service service : services) {
      message += service.getServiceName() + " quantity:" + service.getQuantity() + " price:" + service.getPrice() + separator;
    }
    return message;
  }

  /**
   * Finds and returns a service
   *
   * @param service to be searched for
   * @return the service
   */
  public Service find(Service service) {
    return services.get(services.indexOf(service));
  }
}
