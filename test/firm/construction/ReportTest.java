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
}
