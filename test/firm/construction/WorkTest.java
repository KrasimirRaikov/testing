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
import static org.hamcrest.number.IsCloseTo.closeTo;

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
  public static Collection<Object[]> params() {
    return Arrays.asList(new Object[][]{
            {2.45, 5, 45, 3.73}, {10, 5, 40, 14.70}, {53, 21, 34, 85.93}, {10, 10, 10, 12.1}
    });
  }

  public WorkTest(double price, double mechanisation, double taxes, double result) {

    this.price = price;
    this.mechanisation = mechanisation;
    this.taxes = taxes;
    this.result = result;
  }

  @Test
  public void workPriceCalculation() {
    Employe work = new Employe("gheui", price, taxes, mechanisation);
    assertThat(work.getPrice(), is(closeTo(result, 0.01)));
  }

  @Test
  public void workPriceQuantityCalculation() {
    Employe work = new Employe("dsf", price, taxes, mechanisation, 2.5);
    DecimalFormat df = new DecimalFormat("0.00");
    double res = Double.valueOf(df.format(price * (taxes * 0.01 + 1) * (mechanisation * 0.01 + 1) * 2.5));
    assertThat(work.getPrice(), is(closeTo(res, 0.01)));
  }

  @Test
  public void printLabour() {
    Employe work = new Employe("fdijoreg", price, taxes, mechanisation, 4);
    assertThat(work.print(), is(equalTo("labour: " + work.getName() + " price: " + work.getPrice() + " quantity: " + work.getQuantity())));
  }

}
