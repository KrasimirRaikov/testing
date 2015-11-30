package construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Requirement {
  private final String name;
  private final double quantity;
  private double transportStorage=0;
  private double mechanisation=0;
  private final Measure measure;

  public Requirement(String name, double quantity, Measure measure) {
    this.name = name;
    this.quantity = quantity;
    this.measure = measure;
  }

  public Requirement(String name, double quantity, double transportStorage, double mechanisation, Measure measure) {

    this.name = name;
    this.quantity = quantity;
    this.transportStorage = transportStorage;
    this.mechanisation = mechanisation;
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


  public double getTransportStorage() {
    return transportStorage;
  }

  public double getMechanisation() {
    return mechanisation;
  }
}
