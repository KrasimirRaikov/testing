package firm.construction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
@RunWith(Parameterized.class)
public class MaterialTest {

  @Parameters(name = "{index}: price({0})= result{3}")
  public static Collection<Object[]> params() {
    return Arrays.asList(new Object[][]{
            {10, 20, 20, 3, 79.2}, {5, 10, 30, 5, 173.25}, {19, 52, 2, 11, 39.79}, {10, 10, 10, 1, 12.1}
    });
  }

  private double ts;
  private double vat;
  private double price;
  private double quantity;
  private double result;

  public MaterialTest(double ts, double vat, double price, double quantity, double result) {
    this.ts = ts;
    this.vat = vat;
    this.price = price;
    this.quantity = quantity;
    this.result = result;
  }

  @Test
  public void materialPriceCalculation() {
    Material material = new Material("bricks", price, ts, vat, quantity);
    assertThat(material.getPrice(), is(closeTo(result, 0.01)));
  }


  @Test
  public void printMaterial() {
    Material material = new Material("block", price, ts, vat);
    assertThat(material.print(), is(equalTo("Material: " + material.getName() + " price: " + material.getPrice())));
  }
}
