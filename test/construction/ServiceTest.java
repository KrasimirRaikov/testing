package construction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
@RunWith(Parameterized.class)
public class ServiceTest {



  @Parameters
  public static Collection<Object[]> prices(){
    return Arrays.asList(new Object[][]{
            {1, 1, 2}, {13.5, 1.5, 15}, {2.75, 26.5, 29.25}
    });
  }

  private double materialPrice;
  private double positionPrice;
  private double servicePrice;

  public ServiceTest(double materialPrice, double positionPrice, double servicePrice){
    this.materialPrice = materialPrice;
    this.positionPrice = positionPrice;
    this.servicePrice = servicePrice;
  }

  @Test
  public void detailedServicePricing(){
    List<Material> materials=new ArrayList<>();
    List<Position> positions= new ArrayList<>();
    materials.add(new Material("paint", materialPrice, Measure.SQUARE_METER));
    positions.add(new Position("painter", positionPrice, Measure.SQUARE_METER));
    Service painting= new Service("painting", materials, positions, Measure.SQUARE_METER);
    assertThat(painting.getPrice(), is(closeTo(servicePrice, 0.1)));
  }
}
