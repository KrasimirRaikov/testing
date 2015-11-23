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
    Offer offer = new Offer();
    Service service = new Service("s");
    service.addLabour(new Labour("reujk", 3, 40, 23));
    service.addMaterial(new Material("sdf", 40, 10, 7));

    Service service2 = new Service("k");
    service2.addLabour(new Labour("htre", 45, 30, 4));
    service2.addMaterial(new Material("fde", 24, 43, 34));

    offer.makeOffer(service, service2);
    assertThat(offer.getTotalPrice(), is(equalTo(159.08)));
  }

  @Test
  public void offerGetSpecificServicePrice() {
    Offer offer = new Offer();
    Service service = new Service("rt");
    service.addLabour(new Labour("htre", 42, 12, 42));
    service.addMaterial(new Material("tyr", 342, 23, 23));
    offer.makeOffer(service);
    assertThat(offer.getServicePrice("rt"), is(equalTo(584.21)));
  }

  @Test
  public void printOffer() {
    String separator = System.getProperty("line.separator");
    Offer offer = new Offer();
    Service service = new Service("ASD");
    service.addLabour(new Labour("sdf", 342.3, 23, 34, 2));
    service.addMaterial(new Material("erw", 234, 23, 32));
    service.setQuantity(4.5);
    Service service2 = new Service("PTS");
    service2.addMaterial(new Material("we", 43, 2, 43));
    service2.addLabour(new Labour("dfs", 32, 43, 32, 4));
    offer.makeOffer(service, service2);
    assertThat(offer.printOffer(), is(equalTo("ASD quantity:4.5 price:6787.26" + separator +
            "PTS quantity:1.0 price:304.33" + separator)));
  }

}
