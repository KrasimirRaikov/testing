package firm.construction;

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
    return sum;
  }

  /**
   * Adds service to be used as a report for the progress
   *
   * @param service service or services to be added to the report
   */
  public void addToReport(Service... service) {
    Collections.addAll(servicesReport, service);
    for (Service oneService : service) {
      if (conciseReport.contains(oneService)) {
        int index = conciseReport.indexOf(oneService);
        Service originReport = conciseReport.get(index);
        Service service1 = new Service(originReport.getServiceName(), originReport.getQuantity() + oneService.getQuantity());
        service1.addLabour(originReport.getEmployes());
        service1.addMaterial(originReport.getMaterials());
        service1.addLabour(oneService.getEmployes());
        service1.addMaterial(oneService.getMaterials());
        conciseReport.set(index, service1);
      } else conciseReport.add(oneService);
    }
  }

  /**
   * Getter for the services report
   *
   * @return the services report
   */
  public List<Service> getServices() {
    return servicesReport;

  }

  /**
   * Getter for the concise services report
   *
   * @return the concise services report
   */
  public List<Service> getConciseServices() {
    return conciseReport;
  }


}
