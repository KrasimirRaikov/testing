package firm.construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Material {
  private String name;
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
   * More concrete constructor
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
   * Calculates the price for the material
   *
   * @return the price
   */
  public double getPrice() {
    double price = originalPrice * (vat * 0.01 + 1) * (transportStorage * 0.01 + 1) * quantity;
    return price;
  }


  /**
   * Gets the name of the material
   *
   * @return the name of the material
   */
  public String getName() {
    return name;
  }

  /**
   * Gets a string representing the material ready for print and returns it
   *
   * @return the material ready for print
   */
  public String print() {
    return "Material: " + name + " price: " + getPrice();
  }

}
