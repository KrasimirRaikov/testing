package construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Service {
  private final String name;
  private final double price;
  private final Measure measure;

  public Service(String name, double price, Measure measure) {
    this.name = name;
    this.price = price;
    this.measure = measure;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Service service = (Service) o;

    return !(name != null ? !name.equals(service.name) : service.name != null);

  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  public double getPrice() {
    return price;
  }
}
