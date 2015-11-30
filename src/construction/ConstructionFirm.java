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

  public Offer createOffer(ConstructionSite store) {
    double sum=0;
    List<Service> services= new ArrayList<>();
    for(Requirement requirement : store.getRequirements()){
      services.add(priceList.findService(requirement.getName(), requirement.getMeasure()));
    }
    return new Offer(store.getRequirements(), services);
  }
}
