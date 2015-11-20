package firm.construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Service {

  private double price;
  private List<Material> materials= new ArrayList<>();
  private List<Labour> labours=new ArrayList<>();
  private double quantity=1;

  public void addMaterial(Material material){
    materials.add(material);
  }

  public void addLabour(Labour labour){
    labours.add(labour);
  }

  public double getPrice() {
    double sum=0;
    for(Material material: materials){
      sum+=material.getPrice();
    }
    for(Labour l: labours){
      sum+=l.getPrice();
    }
    price=sum*quantity;
    return price;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
    this.price=getPrice()*quantity;
  }
}
