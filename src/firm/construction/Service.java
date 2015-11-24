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

  /**
   * Constructor of Service class
   *
   * @param serviceName the name of the service
   */
  public Service(String serviceName) {

    this.serviceName = serviceName;
  }

  /**
   * adds a material to a List of needed materials for the completion of the service
   *
   * @param material the material
   */
  public void addMaterial(Material... material) {
    Collections.addAll(materials, material);
  }

  /**
   * adds a labour to a List of needed labours for the completion of the service
   *
   * @param labour the labour
   */
  public void addLabour(Labour... labour) {
    labours.addAll(Arrays.asList(labour));
  }

  /**
   * calculates the price of the entire service
   *
   * @return the price
   */
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

  /**
   * sets the quantity of the service
   *
   * @param quantity the quantity
   */
  public void setQuantity(double quantity) {
    this.quantity = quantity;
    this.price = getPrice() * quantity;
  }

  /**
   * gets the name of the service
   *
   * @return returns the name of the service
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * overrides the equals method so that the services equal the ones with the same name
   *
   * @param obj the object to be compared to tha service
   * @return true if the object is service and it's name is equal to the name of the current service and false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Service)) return false;
    Service that = (Service) obj;
    return this.serviceName.equals(that.getServiceName());

  }

  /**
   * gets a string representation of the service ready to be printed and return it
   *
   * @return return's the string representation of the service
   */
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

  /**
   * gets the quantity of the service
   *
   * @return returns the quantity of the service
   */
  public double getQuantity() {
    return quantity;
  }

  /**
   * gets the materials List as an array of materials
   *
   * @return the array of materials
   */
  public Material[] getMaterials() {
    Object[] objs = materials.toArray();
    Material[] mats = new Material[materials.size()];
    for (int i = 0; i < materials.size(); i++) {
      mats[i] = (Material) objs[i];
    }
    return mats;
  }


  /**
   * gets the labours List as an array of labours
   *
   * @return the array of labours
   */
  public Labour[] getLabours() {
    Object[] objs = labours.toArray();
    Labour[] labs = new Labour[labours.size()];
    for (int i = 0; i < labours.size(); i++) {
      labs[i] = (Labour) objs[i];
    }
    return labs;
  }
}
