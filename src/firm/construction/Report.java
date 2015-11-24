package firm.construction;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Report {

  private List<Service> servicesReport = new ArrayList<>();
  private List<Service> conciseReport = new ArrayList<>();

  /**
   * Calculates the total reported price
   *
   * @return the sum of all prices in the servicesReport
   */
  public double getTotalPrice() {
    double sum = 0;
    for (Service service : servicesReport) {
      sum += service.getPrice();
    }
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(sum));
  }

  /**
   * adds service to be used as a report for the progress
   *
   * @param service service or services to be added to the report
   */
  public void addReport(Service... service) {
    Collections.addAll(servicesReport, service);
    for (Service oneService : service) {
      if (conciseReport.contains(oneService)) {
        int index = conciseReport.indexOf(oneService);
        Service originReport = conciseReport.get(index);
        Service service1 = new Service(originReport.getServiceName());
        service1.addLabour(originReport.getLabours());
        service1.addMaterial(originReport.getMaterials());
        service1.addLabour(oneService.getLabours());
        service1.addMaterial(oneService.getMaterials());
        service1.setQuantity(originReport.getQuantity() + oneService.getQuantity());
        conciseReport.set(index, service1);
      } else conciseReport.add(oneService);
    }
  }


  /**
   * turns the List of services into an array of services
   *
   * @return the array of services
   */
  public Service[] getServices() {
    return getServiceArray(servicesReport);

  }

  /**
   * turns the List of concise reported services into an array of those services
   *
   * @return the array of concise services
   */
  public Service[] getConciseServices() {
    return getServiceArray(conciseReport);
  }

  /**
   * turn a List of services into an array of services
   *
   * @param services the List to be transformed
   * @return the array of services
   */
  public Service[] getServiceArray(List<Service> services) {
    Object[] objs = services.toArray();
    Service[] servicess = new Service[services.size()];
    for (int i = 0; i < services.size(); i++) {
      servicess[i] = (Service) objs[i];
    }
    return servicess;
  }
}
