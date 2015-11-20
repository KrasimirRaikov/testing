package firm.construction;

import java.text.DecimalFormat;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Labour {

  private double price;
  private double taxes=40;
  private double mechanisation=5;
  private double originalPrice;
  private double quantity=1;

  public Labour(String name, double price, double taxes, double mechanisation) {
    this.originalPrice = price;
    this.taxes = taxes;
    this.mechanisation = mechanisation;
  }

  public void setPrice(double price){
    this.originalPrice=price;

  }

  public double getPrice() {
    this.price=originalPrice*(mechanisation*0.01+1)*(taxes*0.01+1)*quantity;
    DecimalFormat df = new DecimalFormat("0.00");
    return Double.valueOf(df.format(price));
  }

  public void setMechanisation(double mechanisation) {
    this.mechanisation = mechanisation;
  }

  public void setTaxes(double taxes) {
    this.taxes = taxes;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }
}
