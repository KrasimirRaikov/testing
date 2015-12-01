package construction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Service {
  private final String name;
  private List<Material> materials = new ArrayList<>();
  private List<Work> works = new ArrayList<>();
  private final double price;
  private final Measure measure;

  public Service(String name, double price, Measure measure) {
    this.name = name;
    this.price = price;
    this.measure = measure;
  }

  public Service(String name, List<Material> materials, List<Work> works, Measure measure) {
    this.name = name;
    this.materials = materials;
    this.works = works;
    this.price = materialsPrice() + positionsPrice();
    this.measure = measure;
  }

  private double positionsPrice() {
    double sum = 0;
    for (Work work : works) {
      sum += work.getPrice();
    }
    return sum;
  }

  private double materialsPrice() {
    double sum = 0;
    for (Material material : materials) {
      sum += material.getPrice();
    }
    return sum;
  }


  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Service service = (Service) o;

    if (name != null ? !name.equals(service.name) : service.name != null) return false;
    return measure == service.measure;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (measure != null ? measure.hashCode() : 0);
    return result;
  }


}
