package uk.gov.gchq.gaffer.data.graph.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleEntityMapsDiffblueTest {
  /**
   * Test {@link SimpleEntityMaps#asList()}.
   *
   * <p>Method under test: {@link SimpleEntityMaps#asList()}
   */
  @Test
  @DisplayName("Test asList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SimpleEntityMaps.asList()"})
  void testAsList() {
    // Arrange, Act and Assert
    assertTrue(new SimpleEntityMaps().asList().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleEntityMaps}
   *   <li>{@link SimpleEntityMaps#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleEntityMaps.<init>()",
    "java.lang.String SimpleEntityMaps.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SimpleEntityMaps actualSimpleEntityMaps = new SimpleEntityMaps();
    actualSimpleEntityMaps.toString();

    // Assert
    assertEquals(0, actualSimpleEntityMaps.size());
  }
}
