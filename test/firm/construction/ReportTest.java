package firm.construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ReportTest {

  @Test
  public void addReport() {
    Report report = new Report();
    Service service = new Service("ds");
    service.addLabour(new Employe("ert", 43, 23.4, 43.45));
    service.addMaterial(new Material("ew", 43.3, 34.3, 32));
    report.addToReport(service);
    assertThat(report.getTotalPrice(), is(closeTo(152.88, 0.01)));
  }

  @Test
  public void addMaterialReport() {
    Report report = new Report();
    Service service = new Service("we");
    service.addMaterial(new Material("ers", 2, 5, 5));
    report.addToReport(service);
    Service service2 = new Service("we");
    service2.addMaterial(new Material("ers", 10, 10, 10));
    report.addToReport(service2);
    assertThat(report.getTotalPrice(), is(closeTo(14.31, 0.01)));
  }

  @Test
  public void addLabourReport() {
    Report report = new Report();
    Service service = new Service("i", 2);
    service.addLabour(new Employe("43", 42, 4, 2));
    report.addToReport(service);
    Service service2 = new Service("i", 2);
    service2.addLabour(new Employe("43", 29, 23, 5));
    report.addToReport(service2);
    assertThat(report.getTotalPrice(), is(closeTo(164.0, 0.02)));
  }


}