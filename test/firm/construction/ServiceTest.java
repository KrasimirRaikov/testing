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

    Service service = new Service("1");
    Material material = new Material("material", 4, 10, 7);
    service.addMaterial(material);
    Employe employe = new Employe("wfe", 35, 40, 23);
    service.addLabour(employe);
    assertThat(service.getPrice(), is(equalTo(64.98)));
  }


  @Test
  public void printService() {
    Service service = new Service("few");
    String newLine = System.getProperty("line.separator");
    service.addMaterial(new Material("gtre", 24, 13, 34));
    service.addLabour(new Employe("req", 42, 65, 42));
    service.addLabour(new Employe("rew", 23, 42, 23));
    assertThat(service.print(), is(equalTo("Material: gtre price: 36.3408" + newLine +
            "labour: req price: 98.40599999999999 quantity: 1.0" + newLine +
            "labour: rew price: 40.1718 quantity: 1.0" + newLine)));
  }

}
