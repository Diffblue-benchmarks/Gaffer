package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElementTupleDefinitionDiffblueTest {
  /**
   * Test {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#ElementTupleDefinition()}
   */
  @Test
  @DisplayName("Test new ElementTupleDefinition()")
  @Tag("MaintainedByDiffblue")
  void testNewElementTupleDefinition() {
    // Arrange, Act and Assert
    assertTrue(new ElementTupleDefinition().isEmpty());
  }

  /**
   * Test {@link ElementTupleDefinition#ElementTupleDefinition(String)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#ElementTupleDefinition(String)}
   */
  @Test
  @DisplayName("Test new ElementTupleDefinition(String)")
  @Tag("MaintainedByDiffblue")
  void testNewElementTupleDefinition2() {
    // Arrange and Act
    ElementTupleDefinition actualElementTupleDefinition = new ElementTupleDefinition("Group");

    // Assert
    assertEquals(1, actualElementTupleDefinition.size());
    assertEquals("Group", actualElementTupleDefinition.get(ElementTupleDefinition.GROUP));
  }

  /**
   * Test {@link ElementTupleDefinition#getGroup()}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()} {@link
   *       ElementTupleDefinition#GROUP} is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given ElementTupleDefinition() GROUP is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  void testGetGroup_givenElementTupleDefinitionGroupIs42_thenReturn42() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.put(ElementTupleDefinition.GROUP, "42");

    // Act and Assert
    assertEquals("42", elementTupleDefinition.getGroup());
  }

  /**
   * Test {@link ElementTupleDefinition#getGroup()}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given ElementTupleDefinition(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetGroup_givenElementTupleDefinition_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ElementTupleDefinition().getGroup());
  }

  /**
   * Test {@link ElementTupleDefinition#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()} {@link
   *       ElementTupleDefinition#DIRECTED} is {@code 42}.
   *   <li>When {@link ElementTupleDefinition#DIRECTED}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  @DisplayName(
      "Test get(Object); given ElementTupleDefinition() DIRECTED is '42'; when DIRECTED; then return '42'")
  @Tag("MaintainedByDiffblue")
  void testGet_givenElementTupleDefinitionDirectedIs42_whenDirected_thenReturn42() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.put(ElementTupleDefinition.DIRECTED, "42");

    // Act and Assert
    assertEquals("42", elementTupleDefinition.get(ElementTupleDefinition.DIRECTED));
  }

  /**
   * Test {@link ElementTupleDefinition#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>When {@link ElementTupleDefinition#DIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  @DisplayName(
      "Test get(Object); given ElementTupleDefinition(); when DIRECTED; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testGet_givenElementTupleDefinition_whenDirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) new ElementTupleDefinition().get(ElementTupleDefinition.DIRECTED));
  }

  /**
   * Test {@link ElementTupleDefinition#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); given ElementTupleDefinition(); when 'Key'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGet_givenElementTupleDefinition_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ElementTupleDefinition().get("Key"));
  }

  /**
   * Test {@link ElementTupleDefinition#vertex(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#vertex(Object)}
   */
  @Test
  @DisplayName("Test vertex(Object)")
  @Tag("MaintainedByDiffblue")
  void testVertex() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualVertexResult = elementTupleDefinition.vertex("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.VERTEX));
    assertSame(elementTupleDefinition, actualVertexResult);
  }

  /**
   * Test {@link ElementTupleDefinition#source(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#source(Object)}
   */
  @Test
  @DisplayName("Test source(Object)")
  @Tag("MaintainedByDiffblue")
  void testSource() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualSourceResult = elementTupleDefinition.source("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.SOURCE));
    assertSame(elementTupleDefinition, actualSourceResult);
  }

  /**
   * Test {@link ElementTupleDefinition#destination(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#destination(Object)}
   */
  @Test
  @DisplayName("Test destination(Object)")
  @Tag("MaintainedByDiffblue")
  void testDestination() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualDestinationResult = elementTupleDefinition.destination("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DESTINATION));
    assertSame(elementTupleDefinition, actualDestinationResult);
  }

  /**
   * Test {@link ElementTupleDefinition#directed(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#directed(Object)}
   */
  @Test
  @DisplayName("Test directed(Object)")
  @Tag("MaintainedByDiffblue")
  void testDirected() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualDirectedResult = elementTupleDefinition.directed("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DIRECTED));
    assertSame(elementTupleDefinition, actualDirectedResult);
  }

  /**
   * Test {@link ElementTupleDefinition#property(String)} with {@code key}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#property(String)}
   */
  @Test
  @DisplayName("Test property(String) with 'key'")
  @Tag("MaintainedByDiffblue")
  void testPropertyWithKey() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Key", elementTupleDefinition.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }

  /**
   * Test {@link ElementTupleDefinition#property(String, Object)} with {@code key}, {@code value}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#property(String, Object)}
   */
  @Test
  @DisplayName("Test property(String, Object) with 'key', 'value'")
  @Tag("MaintainedByDiffblue")
  void testPropertyWithKeyValue() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key", "Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }
}
