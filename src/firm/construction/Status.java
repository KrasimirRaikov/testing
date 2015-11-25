package firm.construction;

import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Status {


  private Offer offer1;
  private List<Service> services;

  /**
   * Constructor for the Status that takes the Offer object and a services list comprised of reported services
   *
   * @param offer  the offer
   * @param report the reported services
   */
  public Status(Offer offer, List<Service> report) {
    this.offer1 = offer;
    this.services = report;
  }

  /**
   * Get's the profit from a service
   *
   * @param service the service whose profit needs calculating
   * @return the profit from that service
   */
  public double getProfit(Service service) {
    return calculateProfit(offer1.find(service), services.get(services.indexOf(service)));
  }

  /**
   * Calculates the profit from a service
   *
   * @param offered  the service from the offer
   * @param reported the service from the report
   * @return the calculated profit
   */
  public double calculateProfit(Service offered, Service reported) {
    double offeredPrice = offered.getPrice();
    double offeredQuantity = offered.getQuantity();
    double reportedPrice = reported.getPrice();
    double reportedQuantity = reported.getQuantity();
    return ((offeredPrice / offeredQuantity) * reportedQuantity) - reportedPrice;
  }
}
