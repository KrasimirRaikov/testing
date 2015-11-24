package firm.construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionSite {
  private String name;
  private Offer offer1 = new Offer();
  private Report report = new Report();

  public ConstructionSite(String name) {
    this.name = name;
  }

  public String statusReport() {
    return reportStatus(report.getServices(), offer1);

  }

  public void addToOffer(Service service) {
    offer1.makeOffer(service);
  }

  public void addToReport(Service service) {
    report.addReport(service);
  }

  public String conciseStatusReport() {
    return reportStatus(report.getConciseServices(), offer1);
  }

  private String reportStatus(Service[] services, Offer offer) {
    String message = "";
    String separator= System.getProperty("line.separator");
    for(Service service: services){
      Service offeredService = offer.find(service);
      message+= name+" service:"+offeredService.getServiceName()+" quantity:"+offeredService.getQuantity()+
              " finishedQuantity:"+service.getQuantity()+" offeredPrice4ThatQuantity:"+
              ((offeredService.getPrice()/offeredService.getQuantity())*service.getQuantity())+
              " reportedPrice4ThatQuantity:"+service.getPrice()+separator;
    }
    return message;
  }

  public Offer getOffer() {
    return offer1;
  }
}
