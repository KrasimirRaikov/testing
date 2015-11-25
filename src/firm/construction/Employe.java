package firm.construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Employe {

  private String name;
  private double taxes = 40;
  private double mechanisation = 5;
  private double originalPrice;
  private double quantity;

  /**
   * Constructor for the Employe class which calls a more concrete constructor with a default value for quantity
   *
   * @param name          the name of the employe
   * @param price         the price of the employe
   * @param taxes         the taxes percent of the employe
   * @param mechanisation the mechanisation percent of the employe
   */
  public Employe(String name, double price, double taxes, double mechanisation) {
    this(name, price, taxes, mechanisation, 1);
  }

  /**
   * More concrete constructor for the employe
   *
   * @param name          the name of the employe
   * @param price         the price of the employe
   * @param taxes         the taxes percent of the employe
   * @param mechanisation the mechanisation percent of the employe
   * @param quantity      the quantity of the employe
   */
  public Employe(String name, double price, double taxes, double mechanisation, double quantity) {

    this.name = name;
    this.originalPrice = price;
    this.taxes = taxes;
    this.mechanisation = mechanisation;
    this.quantity = quantity;
  }


  /**
   * Calculates the price of the employe
   *
   * @return the price of the employe
   */
  public double getPrice() {
    return originalPrice * (mechanisation * 0.01 + 1) * (taxes * 0.01 + 1) * quantity;
  }


  /**
   * Gets the name of the employe
   *
   * @return the name of the employe
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the quantity of the employe
   *
   * @return the quantity
   */
  public double getQuantity() {
    return quantity;
  }

  /**
   * Gets a string of the employe prepared for printing
   *
   * @return the employe as string
   */
  public String print() {
    return "labour: " + name + " price: " + getPrice() + " quantity: " + quantity;
  }
}
