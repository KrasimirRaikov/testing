package firm.construction;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

  public Service(String serviceName) {

    this.serviceName = serviceName;
  }

  public void addMaterial(Material... material) {
    Collections.addAll(materials, material);
  }

  public void addLabour(Labour... labour) {
    labours.addAll(Arrays.asList(labour));
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
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(price));
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
    this.price = getPrice() * quantity;
  }

  public String getServiceName() {
    return serviceName;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Service)) return false;
    Service that = (Service) obj;
    return this.serviceName.equals(that.getServiceName());

  }

  public String print() {
    String result = "";
    String newLine = System.getProperty("line.separator");
    for (Material material : materials) {
      result += material.print() + newLine;
    }
    for (Labour work : labours) {
      result += work.print() + newLine;
    }
    return result;
  }

  public double getQuantity() {
    return quantity;
  }

  public Material[] getMaterials() {
    Object[] objs = materials.toArray();
    Material[] mats = new Material[materials.size()];
    for (int i = 0; i < materials.size(); i++) {
      mats[i] = (Material) objs[i];
    }
    return mats;
  }


}
