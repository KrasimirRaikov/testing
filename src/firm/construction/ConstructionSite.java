package firm.construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionSite {
  private String name;
  private Offer offer= new Offer();
  private Report report = new Report();

  public ConstructionSite(String name) {
    this.name = name;
  }

  public String offerReport() {
    String message = "";
    String separator= System.getProperty("line.separator");
    for(Service service: report.getServices()){
      Service offeredService = offer.find(service);
      message+= name+" service:"+offeredService.getServiceName()+" quantity:"+offeredService.getQuantity()+
              " finishedQuantity:"+service.getQuantity()+" offeredPrice4ThatQuantity:"+
              ((offeredService.getPrice()/offeredService.getQuantity())*service.getQuantity())+
              " reportedPrice4ThatQuantity:"+service.getPrice()+separator;
    }
    return message;

  }

  public void addToOffer(Service service) {
    offer.makeOffer(service);
  }

  public void addToReport(Service service) {
    report.addReport(service);
  }
}
