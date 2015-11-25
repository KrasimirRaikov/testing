package firm.construction;

import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionSite {
  private String name;
  private Offer offer1 = new Offer();
  private Report report = new Report();

  /**
   * Constructor for naming the construction site
   *
   * @param name the name of this instance of construction site
   */
  public ConstructionSite(String name) {
    this.name = name;
  }

  /**
   * Returns a Status on the services on the construction site
   *
   * @return a Status on the services
   */
  public Status statusReport() {
    return reportStatus(report.getServices());
  }

  /**
   * Adds service to the offer for the construction site
   *
   * @param service the service to be added to the offer
   */
  public void addToOffer(Service service) {
    offer1.addToOffer(service);
  }

  /**
   * Adds service to the report for the construction site
   *
   * @param service the service to be added to the report
   */
  public void addToReport(Service service) {
    report.addToReport(service);
  }

  /**
   * Returns a Status on the services on that construction site
   *
   * @return a Status
   */
  public Status conciseStatusReport() {
    return reportStatus(report.getConciseServices());
  }

  /**
   * Returns a Status on a given services list
   *
   * @param services the services list
   * @return a Status on the services
   */
  private Status reportStatus(List<Service> services) {
    return new Status(offer1, services);
  }

  /**
   * Get's the offer on the construction site
   *
   * @return the Offer
   */
  public Offer getOffer() {
    return offer1;
  }
}
