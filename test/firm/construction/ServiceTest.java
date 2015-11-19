package firm.construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ServiceTest {

  @Test
  public void servicePriceCalculation() {

    Service service = new Service();
    Material material=new Material("material", 4, 10, 7);
    service.addMaterial(material);
    Labour labour= new Labour(35, 40, 23);
    service.addLabour(labour);
    assertThat(service.getPrice(), is(equalTo(64.98)));
    Material material1= new Material("material2", 51, 42, 3);
    Labour labour1= new Labour(2, 92, 32);
    service.addLabour(labour1);
    service.addMaterial(material1);
    assertThat(service.getPrice(), is(equalTo(144.64)));
  }
}
