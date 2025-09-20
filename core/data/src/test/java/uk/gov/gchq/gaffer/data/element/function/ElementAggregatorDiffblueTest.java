package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator.Builder;

class ElementAggregatorDiffblueTest {
  /**
   * Test {@link ElementAggregator#apply(Element, Element)} with {@code state}, {@code element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element, Element) with 'state', 'element'; when Edge(String) with 'Group'; then return Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithStateElement_whenEdgeWithGroup_thenReturnEdgeWithGroup() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge state = new Edge("Group");

    // Act
    Element actualApplyResult = elementAggregator.apply(state, new Edge("Group"));

    // Assert
    assertSame(state, actualApplyResult);
  }

  /**
   * Test {@link ElementAggregator#apply(Element, Element)} with {@code state}, {@code element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element, Element) with 'state', 'element'; when 'null'; then return Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithStateElement_whenNull_thenReturnEdgeWithGroup() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge element = new Edge("Group");

    // Act
    Element actualApplyResult = elementAggregator.apply(null, element);

    // Assert
    assertSame(element, actualApplyResult);
  }

  /**
   * Test {@link ElementAggregator#apply(Properties, Properties)} with {@code state}, {@code
   * properties}.
   *
   * <ul>
   *   <li>Given {@link ElementAggregator} (default constructor).
   *   <li>Then return {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregator#apply(Properties, Properties)}
   */
  @Test
  @DisplayName(
      "Test apply(Properties, Properties) with 'state', 'properties'; given ElementAggregator (default constructor); then return Properties()")
  @Tag("MaintainedByDiffblue")
  void testApplyWithStateProperties_givenElementAggregator_thenReturnProperties() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Properties state = new Properties();

    // Act
    Properties actualApplyResult = elementAggregator.apply(state, new Properties());

    // Assert
    assertSame(state, actualApplyResult);
  }

  /**
   * Test {@link ElementAggregator#apply(Properties, Properties)} with {@code state}, {@code
   * properties}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregator#apply(Properties, Properties)}
   */
  @Test
  @DisplayName(
      "Test apply(Properties, Properties) with 'state', 'properties'; when 'null'; then return Properties()")
  @Tag("MaintainedByDiffblue")
  void testApplyWithStateProperties_whenNull_thenReturnProperties() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Properties properties = new Properties();

    // Act
    Properties actualApplyResult = elementAggregator.apply(null, properties);

    // Assert
    assertSame(properties, actualApplyResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getComponents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#Builder()}.
   *
   * <p>Method under test: {@link Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getComponents().isEmpty());
  }

  /**
   * Test {@link ElementAggregator#getComponents()}.
   *
   * <p>Method under test: {@link ElementAggregator#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents()")
  @Tag("MaintainedByDiffblue")
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue(new ElementAggregator().getComponents().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementAggregator#lock()}
   *   <li>{@link ElementAggregator#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    ElementAggregator elementAggregator = new Builder().build();

    // Act
    elementAggregator.lock();

    // Assert
    assertEquals(
        "ElementAggregator[stateTuple=PropertiesTuple[],propertiesTuple=PropertiesTuple[]]",
        elementAggregator.toString());
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}, and {@link ElementAggregator#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementAggregator#equals(Object)}
   *   <li>{@link ElementAggregator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementAggregator elementAggregator = new Builder().build();
    ElementAggregator elementAggregator2 = new Builder().build();

    // Act and Assert
    assertEquals(elementAggregator, elementAggregator2);
    assertEquals(elementAggregator.hashCode(), elementAggregator2.hashCode());
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}, and {@link ElementAggregator#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementAggregator#equals(Object)}
   *   <li>{@link ElementAggregator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementAggregator elementAggregator = new Builder().build();

    // Act and Assert
    assertEquals(elementAggregator, elementAggregator);
    int expectedHashCodeResult = elementAggregator.hashCode();
    assertEquals(expectedHashCodeResult, elementAggregator.hashCode());
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), null);
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), "Different type to ElementAggregator");
  }

  /**
   * Test new {@link ElementAggregator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ElementAggregator}
   */
  @Test
  @DisplayName("Test new ElementAggregator (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewElementAggregator() {
    // Arrange, Act and Assert
    assertTrue(new ElementAggregator().getComponents().isEmpty());
  }
}
