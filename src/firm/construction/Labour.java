package firm.construction;

import java.text.DecimalFormat;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Labour {

  private String name;
  private double taxes = 40;
  private double mechanisation = 5;
  private double originalPrice;
  private double quantity;

  /**
   * constructor for the Labour class which calls a more concrete constructor with a default value for quantity
   *
   * @param name          the name of the labour
   * @param price         the price of the labour
   * @param taxes         the taxes percent of the labour
   * @param mechanisation the mechanisation percent of the labour
   */
  public Labour(String name, double price, double taxes, double mechanisation) {
    this(name, price, taxes, mechanisation, 1);
  }

  /**
   * more concrete constructor for the labour
   *
   * @param name          the name of the labour
   * @param price         the price of the labour
   * @param taxes         the taxes percent of the labour
   * @param mechanisation the mechanisation percent of the labour
   * @param quantity      the quantity of the labour
   */
  public Labour(String name, double price, double taxes, double mechanisation, double quantity) {

    this.name = name;
    this.originalPrice = price;
    this.taxes = taxes;
    this.mechanisation = mechanisation;
    this.quantity = quantity;
  }

  /**
   * sets the original price of the labour
   *
   * @param price the price of the labour
   */
  public void setPrice(double price) {
    this.originalPrice = price;

  }


  /**
   * calculates the price of the labour
   *
   * @return the price of the labour
   */
  public double getPrice() {
    double price = originalPrice * (mechanisation * 0.01 + 1) * (taxes * 0.01 + 1) * quantity;
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(price));
  }

  /**
   * sets the mechanisation percent of the labour
   *
   * @param mechanisation the mechanisation percent
   */
  public void setMechanisation(double mechanisation) {
    this.mechanisation = mechanisation;
  }

  /**
   * sets the taxes of the labour
   *
   * @param taxes the taxes of the labour
   */
  public void setTaxes(double taxes) {
    this.taxes = taxes;
  }

  /**
   * sets the quantity of the labour needed for specific service
   *
   * @param quantity the quantity of the labour
   */
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  /**
   * gets the name of the labour
   *
   * @return the name of the labour
   */
  public String getName() {
    return name;
  }

  /**
   * gets the quantity of the labour
   *
   * @return the quantity
   */
  public double getQuantity() {
    return quantity;
  }

  /**
   * gets a string of the labour prepared for printing
   *
   * @return the labour as string
   */
  public String print() {
    return "labour: " + name + " price: " + getPrice() + " quantity: " + quantity;
  }
}
