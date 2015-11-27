package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Service {
  private String serviceName;
  private List<Material> materials= new ArrayList<>();
  private double quantity=1;
  private List<Employe> employes= new ArrayList<>();

  public Service(String serviceName) {
    this.serviceName = serviceName;
  }

  public void addMaterial(Material material) {
    materials.add(material);
  }

  public double getQuantifiedPrice() {
    double result= 0;
    for(Material material: materials){
      result+=material.getSinglePrice()*material.getQuantity();
    }
    for(Employe employe:employes){
      result +=employe.getSinglePrice();
    }
    return result*quantity;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Service service = (Service) o;

    return serviceName.equals(service.serviceName);

  }

  @Override
  public int hashCode() {
    return serviceName.hashCode();
  }

  public void addEmploye(Employe employe) {
    employes.add(employe);
  }
}
