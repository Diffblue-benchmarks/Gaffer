package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkEntitiesFromHopDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractWalkEntitiesFromHop#ExtractWalkEntitiesFromHop()}
   *   <li>{@link ExtractWalkEntitiesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEntitiesFromHop#getHop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractWalkEntitiesFromHop actualExtractWalkEntitiesFromHop = new ExtractWalkEntitiesFromHop();
    actualExtractWalkEntitiesFromHop.setHop(1);

    // Assert
    assertEquals(1, actualExtractWalkEntitiesFromHop.getHop());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractWalkEntitiesFromHop#ExtractWalkEntitiesFromHop(int)}
   *   <li>{@link ExtractWalkEntitiesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEntitiesFromHop#getHop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    ExtractWalkEntitiesFromHop actualExtractWalkEntitiesFromHop = new ExtractWalkEntitiesFromHop(1);
    actualExtractWalkEntitiesFromHop.setHop(1);

    // Assert
    assertEquals(1, actualExtractWalkEntitiesFromHop.getHop());
  }

  /**
   * Test {@link ExtractWalkEntitiesFromHop#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkEntitiesFromHop#apply(Walk)}
   */
  @Test
  @DisplayName(
      "Test apply(Walk) with 'Walk'; given SimpleEntry(Object, Object) with '42' and HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testApplyWithWalk_givenSimpleEntryWith42AndHashSet_thenReturnEmpty() {
    // Arrange
    ExtractWalkEntitiesFromHop extractWalkEntitiesFromHop = new ExtractWalkEntitiesFromHop(1);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    SimpleEntry<Object, Set<Entity>> simpleEntry2 = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry2);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertTrue(extractWalkEntitiesFromHop.apply(walk).isEmpty());
  }

  /**
   * Test {@link ExtractWalkEntitiesFromHop#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkEntitiesFromHop#apply(Walk)}
   */
  @Test
  @DisplayName("Test apply(Walk) with 'Walk'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testApplyWithWalk_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ExtractWalkEntitiesFromHop(1).apply(null));
  }
}
