package firm.construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionSiteTest {


  @Test
  public void OfferReportComparing() {
    String separator= System.getProperty("line.separator");
    ConstructionSite cs= new ConstructionSite("cs 1");
    Service service = new Service("w4");
    service.addLabour(new Labour("rew", 20, 0, 0, 1));
    service.addMaterial(new Material("rew", 10, 0, 0, 1));
    service.setQuantity(4);
    cs.addToOffer(service);
    Service service1= new Service("w4");
    service1.addLabour(new Labour("rew", 10, 0, 0, 1));
    service1.addLabour(new Labour("what", 10, 0 ,0, 1));
    service1.addMaterial(new Material("rew", 5, 0, 0, 1));
    service1.addMaterial(new Material("gh", 5, 0, 0, 1));
    service1.setQuantity(2);
    cs.addToReport(service1);
    assertThat(cs.offerReport(), is(equalTo("cs 1 service:w4 quantity:4.0"+
            " finishedQuantity:2.0 offeredPrice4ThatQuantity:60.0"+
    " reportedPrice4ThatQuantity:60.0"+separator)));
  }


}
