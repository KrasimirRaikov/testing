package firm.construction;

import java.text.DecimalFormat;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Material {
  private String name;
  private double price;
  private double vat = 20;
  private double transportStorage = 5;
  private double originalPrice;
  private double quantity;

  public Material(String name, double price, double transportStorage, double vat) {
    this(name, price, transportStorage, vat, 1);
  }

  public Material(String name, double price, double transportStorage, double vat, double quantity) {
    this.name = name;
    this.vat = vat;
    this.transportStorage = transportStorage;
    this.originalPrice = price;
    this.quantity = quantity;
  }

  public double getPrice() {
    price = originalPrice * (vat * 0.01 + 1) * (transportStorage * 0.01 + 1) * quantity;
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(price));
  }

  public void setPrice(double price) {
    originalPrice = price;
    this.price = price * (vat * 0.01 + 1) * (transportStorage * 0.01 + 1) * quantity;
  }

  public void setVat(double vat) {
    this.vat = vat;
  }

  public void setTransportStorage(double transportStorage) {
    this.transportStorage = transportStorage;
  }

  public double getVat() {
    return vat;
  }

  public double getTransportStorage() {
    return transportStorage;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }


  public String print() {
    return "Material: " + name + " price: " + getPrice();
  }

}
