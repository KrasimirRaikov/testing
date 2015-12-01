package construction;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
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
  public static Collection<Object[]> prices() {
    return Arrays.asList(new Object[][]{
            {1, 1, 2}, {13.5, 1.5, 15}, {2.75, 26.5, 29.25}
    });
  }

  private double materialPrice;
  private double workPrice;
  private double servicePrice;

  public ServiceTest(double materialPrice, double workPrice, double servicePrice) {
    this.materialPrice = materialPrice;
    this.workPrice = workPrice;
    this.servicePrice = servicePrice;
  }

  @Test
  public void detailedServicePricing() {
    List<Material> materials = new ArrayList<>();
    List<Work> works = new ArrayList<>();
    materials.add(new Material("paint", materialPrice, Measure.SQUARE_METER));
    works.add(new Work("painting  ", workPrice, Measure.SQUARE_METER));
    Multimap<Work, Material> multi = ArrayListMultimap.create();
    Service painting = new Service("painting", materials, works, Measure.SQUARE_METER);
    assertThat(painting.getPrice(), is(closeTo(servicePrice, 0.1)));
  }
}
