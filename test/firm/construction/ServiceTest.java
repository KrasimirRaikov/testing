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
    Labour labour = new Labour("wfe", 35, 40, 23);
    service.addLabour(labour);
    assertThat(service.getPrice(), is(equalTo(64.98)));
    Material material1 = new Material("material2", 51, 42, 3);
    Labour labour1 = new Labour("erbh", 2, 92, 32);
    service.addLabour(labour1);
    service.addMaterial(material1);
    assertThat(service.getPrice(), is(equalTo(144.64)));

  }

  @Test
  public void servicePriceQuantityCalculation() {
    Service service = new Service("2432");
    Material material = new Material("m", 3, 19, 57);
    service.addMaterial(material);
    Labour labour = new Labour("wrth", 12, 4, 2);
    service.addLabour(labour);
    assertThat(service.getPrice(), is(equalTo(18.33)));
    Material material1 = new Material("sk", 92, 2, 23);
    Labour labour1 = new Labour("orergf", 22, 9, 13);
    service.addLabour(labour1);
    service.addMaterial(material1);
    service.setQuantity(2);
    assertThat(service.getPrice(), is(equalTo(321.70)));
  }

  @Test
  public void printService(){
    Service service= new Service("few");
    String newLine= System.getProperty("line.separator");
    service.addMaterial(new Material("gtre", 24, 13, 34));
    service.addLabour(new Labour("req", 42, 65, 42));
    service.addLabour(new Labour("rew", 23, 42, 23));
    assertThat(service.print(), is(equalTo("Material: gtre price: 36.34" +newLine+
            "labour: null price: 98.41 quantity: 1.0" +newLine+
            "labour: null price: 40.17 quantity: 1.0"+newLine)));
  }

}
