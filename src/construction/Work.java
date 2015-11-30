package construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Work {
  private final String name;
  private final double price;
  private final Measure measure;

  public Work(String name, double price, Measure measure) {
    this.name = name;
    this.price = price;
    this.measure = measure;
  }

  public double getPrice() {
    return price;
  }
}
