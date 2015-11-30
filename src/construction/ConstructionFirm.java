package construction;

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
    for(Requirement requirement : store.getRequirements()){
      sum+=requirement.getQuantity()*priceList.findService(requirement.getName()).getPrice();
    }
    return new Offer(sum);
  }
}
