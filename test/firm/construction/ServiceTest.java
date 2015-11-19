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
    Material material=new Material("material");
    material.setPrice(4);
    material.setTransportStorage(10);
    material.setVat(7);
    service.addMaterial(material);
    Labour labour= new Labour();
    labour.setPrice(35);
    labour.setTaxes(40);
    labour.setMechanisation(23);
    service.addLabour(labour);
    assertThat(service.getPrice(), is(equalTo(64.98)));
  }
}
