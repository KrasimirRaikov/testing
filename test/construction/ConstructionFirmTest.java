package construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionFirmTest {

  @Test
  public void offerPrice() {
    PriceList priceList= new PriceList(new Service("painting", 2.5, Measure.SQUARE_METER));
    ConstructionFirm company= new ConstructionFirm(priceList);
    ConstructionSite store= new ConstructionSite("Store",new Requirement("painting", 100, Measure.SQUARE_METER));

    Offer offer= company.createOffer(store);
    assertThat(offer.price(), is(closeTo(250, 0.1)));
  }

}
