package firm.construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ReportTest {

  @Test
  public void addReport() {
    Report report = new Report();
    Service service = new Service("ds");
    service.addLabour(new Labour("ert", 43, 23.4, 43.45));
    service.addMaterial(new Material("ew", 43.3, 34.3, 32));
    report.addReport(service);
    assertThat(report.getTotalPrice(), is(equalTo(152.88)));
  }

  @Test
  public void addMaterialReport() {
    Report report = new Report();
    Service service = new Service("we");
    service.addMaterial(new Material("ers", 2, 5, 5));
    report.addReport(service);
    Service service2 = new Service("we");
    service2.addMaterial(new Material("ers", 10, 10, 10));
    report.addReport(service2);
    assertThat(report.getTotalPrice(), is(equalTo(14.31)));
  }

  @Test
  public void addLabourReport(){
    Report report = new Report();
    Service service = new Service("i");
    service.addLabour(new Labour("43", 42, 4, 2));
    report.addReport(service);
    Service service2 = new Service("i");
    service2.addLabour(new Labour("43", 29, 23, 5));
    report.addReport(service2);
    service.setQuantity(2);
    service2.setQuantity(2);
    assertThat(report.getTotalPrice(), is(equalTo(164.0)));
  }


}