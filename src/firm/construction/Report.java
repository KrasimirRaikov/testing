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

  public double getTotalPrice() {
    double sum = 0;
    for (Service service : servicesReport) {
      sum += service.getPrice();
    }
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(sum));
  }

  public void addReport(Service... service) {
    Collections.addAll(servicesReport, service);
    for(Service oneService:service){
      if (conciseReport.contains(oneService)){
        int index= conciseReport.indexOf(oneService);
        Service originReport= conciseReport.get(index);
        Service service1= new Service(originReport.getServiceName());
        service1.addLabour(originReport.getLabours());
        service1.addMaterial(originReport.getMaterials());
        service1.addLabour(oneService.getLabours());
        service1.addMaterial(oneService.getMaterials());
        service1.setQuantity(originReport.getQuantity()+oneService.getQuantity());
        conciseReport.set(index, service1);
      }
      else conciseReport.add(oneService);
    }
  }

  public Service[] getServices() {
    return getServiceArray(servicesReport);

  }

  public Service[] getConciseServices() {
    return getServiceArray(conciseReport);
  }

  public Service[] getServiceArray(List<Service> services){
    Object[] objs= services.toArray();
    Service[] servicess= new Service[services.size()];
    for (int i = 0; i < services.size(); i++) {
      servicess[i] = (Service) objs[i];
    }
    return servicess;
  }
}
