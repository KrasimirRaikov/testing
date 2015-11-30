package construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Requirement {
  private final String name;
  private final double quantity;
  private final Measure measure;

  public Requirement(String name, double quantity, Measure measure) {
    this.name = name;
    this.quantity = quantity;
    this.measure = measure;
  }

  public String getName() {
    return name;
  }

  public double getQuantity() {
    return quantity;
  }

  public Measure getMeasure() {
    return measure;
  }
}
