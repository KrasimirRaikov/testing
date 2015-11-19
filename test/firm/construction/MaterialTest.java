package firm.construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class MaterialTest {

  @Test
  public void materialPriceCalculation() {
    Material material= new Material("bricks");
    material.setTransportStorage(10);
    material.setVat(20);
    material.setPrice(20.0);
    assertThat(material.getPrice(), is(equalTo(26.4)));
  }
}
