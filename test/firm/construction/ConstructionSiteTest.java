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
  public void offerReportComparing() {
    String separator = System.getProperty("line.separator");
    ConstructionSite cs = new ConstructionSite("cs 1");
    Service service = new Service("w4");
    service.addLabour(new Labour("rew", 20, 0, 0, 1));
    service.addMaterial(new Material("rew", 10, 0, 0, 1));
    service.setQuantity(4);
    cs.addToOffer(service);
    Service service1 = new Service("w4");
    service1.addLabour(new Labour("rew", 10, 0, 0, 1));
    service1.addLabour(new Labour("what", 10, 0, 0, 1));
    service1.addMaterial(new Material("rew", 5, 0, 0, 1));
    service1.addMaterial(new Material("gh", 5, 0, 0, 1));
    service1.setQuantity(2);
    cs.addToReport(service1);
    assertThat(cs.statusReport(), is(equalTo("cs 1 service:w4 quantity:4.0" +
            " finishedQuantity:2.0 offeredPrice4ThatQuantity:60.0" +
            " reportedPrice4ThatQuantity:60.0" + separator)));
  }

  @Test
  public void multipleReportsOfferComparing(){

    ConstructionSite cs= new ConstructionSite("qwerty");
    Service service = new Service("ew");
    service.addLabour(new Labour("as", 35, 10, 10));
    service.addMaterial(new Material("ot", 15, 0, 0));
    service.setQuantity(10);
    cs.addToOffer(service);
    Service serviceReport= new Service("ew");
    serviceReport.addLabour(new Labour("as", 37, 17, 10));
    serviceReport.addMaterial(new Material("ot", 12, 0, 0));
    serviceReport.setQuantity(3);
    cs.addToReport(serviceReport);
    Service serviceReport2= new Service("ew");
    serviceReport2.addLabour(new Labour("as", 23, 20, 15));
    serviceReport2.addMaterial(new Material("ot", 15, 5, 0));
    serviceReport2.setQuantity(2);
    cs.addToReport(serviceReport2);
    assertThat(cs.conciseStatusReport(), is(equalTo("qwerty service:ew quantity:10.0 finishedQuantity:5.0"+
            " offeredPrice4ThatQuantity:286.75 reportedPrice4ThatQuantity:535.55"+System.getProperty("line.separator"))));
  }

  @Test
  public void getConstructionSiteOffer() {
    ConstructionSite cs= new ConstructionSite("trv");
    Service service= new Service("ert");
    service.addLabour(new Labour("ont", 23, 10, 10));
    service.setQuantity(2);
    service.addMaterial(new Material("oiu", 5, 20, 20));
    cs.addToOffer(service);
    assertThat(cs.getOffer().printOffer(), is(equalTo("ert quantity:2.0 price:70.06"+System.getProperty("line.separator"))));
  }



}
