package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionFirm {
  private PriceList priceList;

  public ConstructionFirm(PriceList priceList) {

    this.priceList = priceList;
  }

  public Offer createOffer(ConstructionSite site) {
    double sum = 0;
    List<Service> services = new ArrayList<>();
    for (Requirement requirement : site.getRequirements()) {
      services.add(priceList.findService(requirement.getName(), requirement.getMeasure()));
    }
    return new Offer(site, services);
  }

  public Ledger createLedger(ConstructionSite site) {
    return new Ledger(site);
  }

  public Ledger createLedger(ConstructionSite site, Offer offer) {
    return new Ledger(site, offer);
  }
}
