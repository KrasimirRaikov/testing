package firm.construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Service {

  private double price;
  private List<Material> materials = new ArrayList<>();
  private List<Labour> labours = new ArrayList<>();
  private double quantity = 1;
  private String serviceName;

  public Service(){}

  public Service(String serviceName) {

    this.serviceName = serviceName;
  }

  public void addMaterial(Material material) {
    materials.add(material);
  }

  public void addLabour(Labour labour) {
    labours.add(labour);
  }

  public double getPrice() {
    double sum = 0;
    for (Material material : materials) {
      sum += material.getPrice();
    }
    for (Labour l : labours) {
      sum += l.getPrice();
    }
    price = sum * quantity;
    return price;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
    this.price = getPrice() * quantity;
  }

  public String getServiceName() {
    return serviceName;
  }

  @Override
  public boolean equals(Object obj){
    if (!(obj instanceof Service)) return false;
    Service that= (Service) obj;
    return this.serviceName.equals(that.getServiceName());

  }
}
