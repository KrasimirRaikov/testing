package firm.construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class OfferTest {

  @Test
  public void makeOffer() {
    Offer offer= new Offer();
    Service service= new Service();
    service.addLabour(new Labour(3, 40, 23));
    service.addMaterial(new Material("sdf", 40, 10, 7));
    offer.makeOffer(service);
    assertThat(offer.getTotalPrice(), is(equalTo(52.25)));
  }
}
