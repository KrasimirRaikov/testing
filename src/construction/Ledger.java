package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Ledger {
  private ConstructionSite site;
  private Offer offer;
  private List<Report> reports= new ArrayList<>();

  public Ledger(ConstructionSite site) {
    this.site = site;
  }

  public Ledger(ConstructionSite site, Offer offer) {
    this.site = site;
    this.offer = offer;
  }

  public double price() {
    double price=0;
    for(Report report: reports){
      price+=report.getQuantity()*report.getPrice();
    }
    return price;
  }

  public void report(Report serviceReport) {
    reports.add(serviceReport);
  }

  public double profit() {
    return offer.price()-price();
  }
}
