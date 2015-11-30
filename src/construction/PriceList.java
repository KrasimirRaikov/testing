package construction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class PriceList {
  private List<Service> services= new ArrayList<>();

  public PriceList(Service... service) {
    Collections.addAll(services,service);
  }

  public Service findService(String name) {
    return services.get(services.indexOf(new Service(name, 0, Measure.SQUARE_METER)));
  }
}
