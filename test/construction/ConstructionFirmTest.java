package construction;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionFirmTest {

  @Test
  public void offerPrice() {
    PriceList priceList= new PriceList(new Service("painting", 2.5, Measure.SQUARE_METER));
    ConstructionFirm company= new ConstructionFirm(priceList);
    ConstructionSite store= new ConstructionSite("Store",new Requirement("painting", 100, Measure.SQUARE_METER));

    Offer offer= company.createOffer(store);
    assertThat(offer.price(), is(closeTo(250, 0.1)));
  }

  @Test
  public void offerAdditionalCosts(){
    PriceList priceList= new PriceList(new Service("scraping", 13, Measure.SQUARE_METER), new Service("plastering", 12, Measure.SQUARE_METER));
    ConstructionFirm company= new ConstructionFirm(priceList);
    ConstructionSite apartment= new ConstructionSite("Apartment 1342", new Requirement("scraping", 35, 15, 7, Measure.SQUARE_METER), new Requirement("plastering", 35, Measure.SQUARE_METER));

    Offer offer = company.createOffer(apartment);
    assertThat(offer.price(), is(closeTo(897,0.1)));
  }

  @Test
  public void ledgerPrice() {
    PriceList priceList= new PriceList(new Service("tiling", 16.5, Measure.SQUARE_METER));
    ConstructionFirm company = new ConstructionFirm(priceList);
    ConstructionSite office= new ConstructionSite("office 12", new Requirement("tiling", 5, Measure.SQUARE_METER));

    Ledger ledger = company.createReport(office);
    ledger.report(new Report("tiling", 3, 16, Measure.SQUARE_METER));
    ledger.report(new Report("tiling", 2, 15, Measure.SQUARE_METER));
    assertThat(ledger.price(), is(closeTo(78, 0.1)));
  }
}
