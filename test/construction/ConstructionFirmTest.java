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
  public void profitFromNothing() {
    ConstructionFirm firm= new ConstructionFirm();
    ConstructionSite officeBuilding = new ConstructionSite("office building on Buzludja");
    assertThat(firm.profit(officeBuilding), is(closeTo(0, 0.1)));
  }

  @Test
  public void profitFromMaterial(){
    ConstructionFirm company= new ConstructionFirm();
    ConstructionSite groceryStore= new ConstructionSite("grocery store on Gabrovski");

    Service pourConcrete = new Service("pour concrete");
    pourConcrete.addMaterial(new Material("concrete", 75, 1));
    company.addService(pourConcrete);
    company.addToProject(groceryStore, "pour concrete",200);

    company.report(groceryStore, "pour concrete", "concrete", 50, 200);
    assertThat(company.profit(groceryStore), is(closeTo(5000, 0.1)));
  }

  @Test
  public void profitFromEmploye() {
    ConstructionFirm company = new ConstructionFirm();
    ConstructionSite apartment= new ConstructionSite("private apartment");

    Service paint= new Service("paint walls");
    paint.addEmploye(new Employe(1710));
    company.addService(paint);
    company.addToProject(apartment, "paint walls", 10);

    company.report(apartment, "paint walls", 401, 10);
    assertThat(company.profit(apartment), is(closeTo(13090, 0.1)));
  }
}
