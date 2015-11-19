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

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
@RunWith(Parameterized.class)
public class MaterialTest {

  @Parameters
  public static Collection<Object[]> params(){
    return Arrays.asList(new Object[][]{
            {10, 20, 20, 26.40},{5, 7, 13, 14.61}, {19, 52, 2, 3.62}
    });
  }

  private double ts;
  private double vat;
  private double price;
  private double result;

  public MaterialTest(double ts, double vat, double price, double result){
    this.ts = ts;
    this.vat = vat;
    this.price = price;
    this.result = result;
  }

  @Test
  public void materialPriceCalculation() {
    Material material= new Material("bricks", price, ts, vat);
    assertThat(material.getPrice(), is(equalTo(result)));
  }
}
