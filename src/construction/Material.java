package construction;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Material {
  private final String materialName;
  private double singlePrice;
  private double quantity=1;

  public Material(String materialName, double singlePrice, double quantity) {

    this.materialName = materialName;
    this.singlePrice = singlePrice;
    this.quantity = quantity;
  }

  public double getQuantity() {
    return quantity;
  }

  public double getSinglePrice() {
    return singlePrice;
  }

  public void setSinglePrice(double singlePrice) {
    this.singlePrice = singlePrice;
  }
}
