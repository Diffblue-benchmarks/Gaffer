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
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer.Builder;

class ElementTransformerDiffblueTest {
  /**
   * Test {@link ElementTransformer#apply(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link ElementTransformer} (default constructor).
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTransformer#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'element'; given ElementTransformer (default constructor); then return Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement_givenElementTransformer_thenReturnEdgeWithGroup() {
    // Arrange
    ElementTransformer elementTransformer = new ElementTransformer();
    Edge element = new Edge("Group");

    // Act
    Element actualApplyResult = elementTransformer.apply(element);

    // Assert
    assertSame(element, actualApplyResult);
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
   * Test {@link ElementTransformer#equals(Object)}, and {@link ElementTransformer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementTransformer#equals(Object)}
   *   <li>{@link ElementTransformer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementTransformer elementTransformer = new Builder().build();
    ElementTransformer elementTransformer2 = new Builder().build();

    // Act and Assert
    assertEquals(elementTransformer, elementTransformer2);
    assertEquals(elementTransformer.hashCode(), elementTransformer2.hashCode());
  }

  /**
   * Test {@link ElementTransformer#equals(Object)}, and {@link ElementTransformer#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementTransformer#equals(Object)}
   *   <li>{@link ElementTransformer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementTransformer elementTransformer = new Builder().build();

    // Act and Assert
    assertEquals(elementTransformer, elementTransformer);
    int expectedHashCodeResult = elementTransformer.hashCode();
    assertEquals(expectedHashCodeResult, elementTransformer.hashCode());
  }

  /**
   * Test {@link ElementTransformer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), null);
  }

  /**
   * Test {@link ElementTransformer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), "Different type to ElementTransformer");
  }

  /**
   * Test new {@link ElementTransformer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ElementTransformer}
   */
  @Test
  @DisplayName("Test new ElementTransformer (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewElementTransformer() {
    // Arrange, Act and Assert
    assertTrue(new ElementTransformer().getComponents().isEmpty());
  }

  /**
   * Test {@link ElementTransformer#toString()}.
   *
   * <p>Method under test: {@link ElementTransformer#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ElementTransformer[elementTuple=ElementTuple[]]", new Builder().build().toString());
  }
}
