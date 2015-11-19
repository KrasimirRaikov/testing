package firm.construction;

import java.text.DecimalFormat;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Material {
  private String name;
  private double price;
  private double vat=20;
  private double transportStorage=5;
  private double originalPrice;

  public Material(String name) {
    this.name = name;
  }

  public double getPrice() {
    price=originalPrice*(vat*0.01+1)*(transportStorage*0.01+1);
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(price));
  }

  public void setPrice(double price) {
    originalPrice=price;
    this.price = price*(vat*0.01+1)*(transportStorage*0.01+1);
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
}