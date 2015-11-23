package firm.construction;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Report {

  private List<Service> servicesReports = new ArrayList<>();

  public double getTotalPrice() {
    double sum = 0;
    for (Service service : servicesReports) {
      sum += service.getPrice();
    }
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(sum));
  }

  public void addReport(Service... service) {
    Collections.addAll(servicesReports, service);
  }

  public Service[] getServices() {
    Object[] objs= servicesReports.toArray();
    Service[] services= new Service[servicesReports.size()];
    for (int i = 0; i < servicesReports.size(); i++) {
      services[i] = (Service) objs[i];
    }
    return services;
  }
}
