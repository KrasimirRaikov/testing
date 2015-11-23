package firm.construction;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Offer {

  private List<Service> services= new ArrayList<>();

  public void makeOffer(Service... servicess){
    Collections.addAll(services, servicess);
  }

  public double getTotalPrice() {
    double sum= 0;
    for(Service service: services){
      sum+=service.getPrice();
    }
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(sum));
  }


  public double getServicePrice(String serviceName) {
    DecimalFormat df= new DecimalFormat("0.00");
    return Double.valueOf(df.format(services.get(services.indexOf(new Service(serviceName))).getPrice()));
  }

  public String printOffer() {
    String massage="";
    String separator=System.getProperty("line.separator");
    for(Service service: services){
      massage+= service.getServiceName()+" quantity:"+service.getQuantity()+" price:"+service.getPrice()+separator;
    }
    return massage;
  }
}
