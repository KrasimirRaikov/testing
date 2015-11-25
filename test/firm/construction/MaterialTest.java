package firm.construction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
@RunWith(Parameterized.class)
public class MaterialTest {

  @Parameters
  public static Collection<Object[]> params() {
    return Arrays.asList(new Object[][]{
            {10, 20, 20, 26.40}, {5, 7, 13, 14.61}, {19, 52, 2, 3.62}, {10, 10, 10, 12.1}
    });
  }

  private double ts;
  private double vat;
  private double price;
  private double result;

  public MaterialTest(double ts, double vat, double price, double result) {
    this.ts = ts;
    this.vat = vat;
    this.price = price;
    this.result = result;
  }

  @Test
  public void materialPriceCalculation() {
    Material material = new Material("bricks", price, ts, vat);
    assertThat(material.getPrice(), is(equalTo(result)));
  }

  @Test
  public void materialPriceQuantityCalculation() {
    Material material = new Material("cement", price, ts, vat);
    material.setQuantity(6);
    DecimalFormat df = new DecimalFormat("0.00");
    double res = Double.valueOf(df.format(price * (ts * 0.01 + 1) * (vat * 0.01 + 1) * 6));
    assertThat(material.getPrice(), is(equalTo(res)));
  }

  @Test
  public void materialSetPrice(){
    Material material = new Material("bricks", price, ts, vat);
    material.setPrice(price*2);
    DecimalFormat df = new DecimalFormat("0.00");
    double res= Double.valueOf(df.format(2*price * (ts * 0.01 + 1) * (vat * 0.01 + 1)));
    assertThat(material.getPrice(), is(equalTo(res)));
  }

  @Test
  public void printMaterial() {
    Material material = new Material("block", price, ts, vat);
    assertThat(material.print(), is(equalTo("Material: " + material.getName() + " price: " + material.getPrice())));
  }
}
