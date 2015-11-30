package construction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ConstructionSite {
  private final String name;
  private final List<Requirement> requirements= new ArrayList<>();

  public ConstructionSite(String name, Requirement... requirement) {
    this.name = name;
    Collections.addAll(requirements,requirement);
  }

  public List<Requirement> getRequirements() {
    return requirements;
  }
}
