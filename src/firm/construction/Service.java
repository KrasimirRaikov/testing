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
  private List<Employe> employes = new ArrayList<>();
  private double quantity;
  private String serviceName;

  /**
   * Common Constructor of Service class that calls more concrete one
   *
   * @param serviceName the name of the service
   */
  public Service(String serviceName) {

    this(serviceName, 1);
  }

  /**
   * More concrete constructor for the Service class
   *
   * @param serviceName the name of the service
   * @param quantity    the quantity of the service
   */
  public Service(String serviceName, double quantity) {

    this.serviceName = serviceName;
    this.quantity = quantity;
  }

  /**
   * Adds a material to a List of needed materials for the completion of the service
   *
   * @param material the material
   */
  public void addMaterial(Material... material) {
    Collections.addAll(materials, material);
  }

  /**
   * Adds a employe to a List of needed employes for the completion of the service
   *
   * @param employe the employe
   */
  public void addLabour(Employe... employe) {
    employes.addAll(Arrays.asList(employe));
  }

  /**
   * Calculates the price of the entire service
   *
   * @return the price
   */
  public double getPrice() {
    double sum = 0;
    for (Material material : materials) {
      sum += material.getPrice();
    }
    for (Employe l : employes) {
      sum += l.getPrice();
    }
    price = sum * quantity;
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(price));
  }


  /**
   * Gets the name of the service
   *
   * @return the name of the service
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * Overrides the equals method so that the services equal the ones with the same name
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
   * Gets a string representation of the service ready to be printed and return it
   *
   * @return return's the string representation of the service
   */
  public String print() {
    String result = "";
    String newLine = System.getProperty("line.separator");
    for (Material material : materials) {
      result += material.print() + newLine;
    }
    for (Employe work : employes) {
      result += work.print() + newLine;
    }
    return result;
  }

  /**
   * Gets the quantity of the service
   *
   * @return returns the quantity of the service
   */
  public double getQuantity() {
    return quantity;
  }

  /**
   * Gets the materials List as an array of materials
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
   * Gets the employes List as an array of employes
   *
   * @return the array of employes
   */
  public Employe[] getEmployes() {
    Object[] objs = employes.toArray();
    Employe[] labs = new Employe[employes.size()];
    for (int i = 0; i < employes.size(); i++) {
      labs[i] = (Employe) objs[i];
    }
    return labs;
  }
}
