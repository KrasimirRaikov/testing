package construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Report {
  private final String name;
  private final double quantity;
  private final double price;
  private final Measure measure;

  public Report(String name, double quantity, double price, Measure measure) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.measure = measure;
  }

  public double getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }
}
