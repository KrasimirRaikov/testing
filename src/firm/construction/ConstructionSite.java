package firm.construction;

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
   * status report for the services quantity and price on the construction site
   *
   * @return a string that is the report
   */
  public String statusReport() {
    return reportStatus(report.getServices());
  }

  /**
   * adds service to the offer for the construction site
   *
   * @param service the service to be added to the offer
   */
  public void addToOffer(Service service) {
    offer1.makeOffer(service);
  }

  /**
   * adds service to the report for the construction site
   *
   * @param service the service to be added to the report
   */
  public void addToReport(Service service) {
    report.addReport(service);
  }


  /**
   * return's concise report for the quantity and price of the construction site
   *
   * @return a string that represents the report
   */
  public String conciseStatusReport() {
    return reportStatus(report.getConciseServices());
  }

  /**
   * get's a report on a array of services compared to the offer for the construction site
   *
   * @param services the array of services which to be reported about
   * @return a string which is the report
   */
  private String reportStatus(Service[] services) {
    String message = "";
    String separator = System.getProperty("line.separator");
    for (Service service : services) {
      Service offeredService = offer1.find(service);
      message += name + " service:" + offeredService.getServiceName() + " quantity:" + offeredService.getQuantity() +
              " finishedQuantity:" + service.getQuantity() + " offeredPrice4ThatQuantity:" +
              ((offeredService.getPrice() / offeredService.getQuantity()) * service.getQuantity()) +
              " reportedPrice4ThatQuantity:" + service.getPrice() + separator;
    }
    return message;
  }

  public Offer getOffer() {
    return offer1;
  }
}
