package firm.construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionSiteTest {


  @Test
  public void offerReportComparing() {
    ConstructionSite cs = new ConstructionSite("cs 1");
    Service service = new Service("w4", 4);
    service.addLabour(new Employe("rew", 20, 0, 0, 1));
    cs.addToOffer(service);
    Service service1 = new Service("w4", 2);
    service1.addLabour(new Employe("rew", 10, 0, 0, 1));
    cs.addToReport(service1);
    double result = cs.statusReport().getProfit(new Service("w4"));
    assertThat(result, is(closeTo(20.0, 0.01)));
  }

  @Test
  public void multipleReportsOfferComparing() {
    ConstructionSite cs = new ConstructionSite("qwerty");

    Service service = new Service("ew", 10);
    service.addLabour(new Employe("as", 35, 10, 10));
    cs.addToOffer(service);

    Service serviceReport = new Service("ew", 3);
    serviceReport.addLabour(new Employe("as", 37, 17, 10));
    cs.addToReport(serviceReport);

    Service serviceReport2 = new Service("ew", 2);
    serviceReport2.addLabour(new Employe("as", 23, 20, 15));
    cs.addToReport(serviceReport2);

    double result = cs.conciseStatusReport().getProfit(new Service("ew"));
    assertThat(result, is(closeTo(-185.04, 0.02)));
  }

  @Test
  public void getConstructionSiteOffer() {
    ConstructionSite cs = new ConstructionSite("trv");
    Service service = new Service("ert", 2);
    service.addLabour(new Employe("ont", 23, 10, 10));
    service.addMaterial(new Material("oiu", 5, 20, 20));
    cs.addToOffer(service);
    assertThat(cs.getOffer().getTotalPrice(), is(closeTo(70.06, 0.01)));
  }


}
