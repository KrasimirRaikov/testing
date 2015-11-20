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

    Service service2= new Service();
    service2.addLabour(new Labour(45, 30, 4));
    service2.addMaterial(new Material("fde", 24, 43, 34));

    offer.makeOffer(service, service2);
    assertThat(offer.getTotalPrice(), is(equalTo(159.08)));
  }

  @Test
  public void offerGetSpecificServicePrice() {
    Offer offer= new Offer();
    Service service= new Service("rt");
    service.addLabour(new Labour(42, 12, 42));
    service.addMaterial(new Material("tyr", 342, 23, 23));
    offer.makeOffer(service);
    assertThat(offer.getServicePrice("rt"), is(equalTo(584.21)));
  }
}
