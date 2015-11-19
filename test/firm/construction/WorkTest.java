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
public class WorkTest {

  private double price;
  private double mechanisation;
  private double taxes;
  private double result;

  @Parameters
  public static Collection<Object[]> params(){
    return Arrays.asList(new Object[][]{
            {2.45, 5, 45, 3.73},{10, 5, 40, 14.70},{53, 21, 34, 85.93}
    });
  }

  public WorkTest(double price, double mechanisation, double taxes, double result){

    this.price = price;
    this.mechanisation = mechanisation;
    this.taxes = taxes;
    this.result = result;
  }

  @Test
  public void workPriceCalculation() {
    Labour work = new Labour();
    work.setPrice(price);
    work.setMechanisation(mechanisation);
    work.setTaxes(taxes);
    assertThat(work.getPrice(), is(equalTo(result)));
  }
}
