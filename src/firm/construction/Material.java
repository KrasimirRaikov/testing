package firm.construction;

import java.text.DecimalFormat;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Material {
  private String name;
  private double price;
  private double vat = 20;
  private double transportStorage = 5;
  private double originalPrice;
  private double quantity;

  /**
   * Constructor that call's more concrete constructor with default value for the quantity
   *
   * @param name             the name of the material
   * @param price            the price of the material
   * @param transportStorage the transport and storage fee percent
   * @param vat              value added tax
   */
  public Material(String name, double price, double transportStorage, double vat) {
    this(name, price, transportStorage, vat, 1);
  }

  /**
   * more concrete constructor
   *
   * @param name             the name of the material
   * @param price            the price of the material
   * @param transportStorage the transport and storage fee percent
   * @param vat              value added tax
   * @param quantity         the quantity of the material needed for a specific service
   */
  public Material(String name, double price, double transportStorage, double vat, double quantity) {
    this.name = name;
    this.vat = vat;
    this.transportStorage = transportStorage;
    this.originalPrice = price;
    this.quantity = quantity;
  }

  /**
   * calculates the price for the material
   *
   * @return the price
   */
  public double getPrice() {
    price = originalPrice * (vat * 0.01 + 1) * (transportStorage * 0.01 + 1) * quantity;
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(price));
  }

  /**
   * sets the original price of the material before the calculation of the new value
   *
   * @param price the price
   */
  public void setPrice(double price) {
    originalPrice = price;
    this.price = price * (vat * 0.01 + 1) * (transportStorage * 0.01 + 1) * quantity;
  }

  /**
   * sets the vat field
   *
   * @param vat the value added tax(vat) field
   */
  public void setVat(double vat) {
    this.vat = vat;
  }

  /**
   * sets the transport and storage percent fee field
   *
   * @param transportStorage the transport and storage percent fee
   */
  public void setTransportStorage(double transportStorage) {
    this.transportStorage = transportStorage;
  }

  /**
   * gets the value added tax percent
   *
   * @return the vat percent
   */
  public double getVat() {
    return vat;
  }

  /**
   * gets the transport and storage percent fee
   *
   * @return transportStorage percent
   */
  public double getTransportStorage() {
    return transportStorage;
  }

  /**
   * sets the value for the quantity field of the material
   *
   * @param quantity the quantity
   */
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  /**
   * gets the name of the material
   *
   * @return the name of the material
   */
  public String getName() {
    return name;
  }

  /**
   * gets a string representing the material ready for print and returns it
   *
   * @return the material ready for print
   */
  public String print() {
    return "Material: " + name + " price: " + getPrice();
  }

}
