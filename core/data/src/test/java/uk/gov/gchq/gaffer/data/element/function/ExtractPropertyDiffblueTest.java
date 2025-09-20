package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.LazyEntity;
import uk.gov.gchq.gaffer.data.element.LazyProperties;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ExtractPropertyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractProperty#ExtractProperty()}
   *   <li>{@link ExtractProperty#setName(String)}
   *   <li>{@link ExtractProperty#toString()}
   *   <li>{@link ExtractProperty#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractProperty actualExtractProperty = new ExtractProperty();
    actualExtractProperty.setName("Name");
    actualExtractProperty.toString();

    // Assert
    assertEquals("Name", actualExtractProperty.getName());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractProperty#ExtractProperty(String)}
   *   <li>{@link ExtractProperty#setName(String)}
   *   <li>{@link ExtractProperty#toString()}
   *   <li>{@link ExtractProperty#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenName() {
    // Arrange and Act
    ExtractProperty actualExtractProperty = new ExtractProperty("Name");
    actualExtractProperty.setName("Name");
    actualExtractProperty.toString();

    // Assert
    assertEquals("Name", actualExtractProperty.getName());
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   *
   * <p>Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);

    // Act
    extractProperty.apply(element);

    // Assert
    verify(valueLoader).getProperty(eq("Name"), isA(Properties.class));
    Properties properties = element.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Name"));
    LazyProperties properties2 = element.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ExtractProperty#ExtractProperty(String)} with {@code Name}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given ExtractProperty(String) with 'Name'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement_givenExtractPropertyWithName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ExtractProperty("Name").apply(null));
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ExtractProperty#ExtractProperty()}.
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given ExtractProperty(); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement_givenExtractProperty_thenReturnProperty() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty();

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);

    // Act
    Object actualApplyResult = extractProperty.apply(element);

    // Assert
    verify(valueLoader).getProperty(isNull(), isA(Properties.class));
    assertEquals("Property", actualApplyResult);
    assertTrue(element.getElement().getProperties().isEmpty());
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given 'Name'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement_givenName_thenReturnValue() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();

    LazyEntity element = new LazyEntity(entity, mock(ElementValueLoader.class));
    element.putProperty("Name", "Value");

    // Act
    Object actualApplyResult = extractProperty.apply(element);

    // Assert
    assertEquals("Value", actualApplyResult);
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement_whenEdgeWithGroup_thenReturnNull() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");

    // Act
    Object actualApplyResult = extractProperty.apply(new Edge("Group"));

    // Assert
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}, and {@link ExtractProperty#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractProperty#equals(Object)}
   *   <li>{@link ExtractProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");
    ExtractProperty extractProperty2 = new ExtractProperty("Name");

    // Act and Assert
    assertEquals(extractProperty, extractProperty2);
    assertEquals(extractProperty.hashCode(), extractProperty2.hashCode());
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}, and {@link ExtractProperty#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractProperty#equals(Object)}
   *   <li>{@link ExtractProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");

    // Act and Assert
    assertEquals(extractProperty, extractProperty);
    int expectedHashCodeResult = extractProperty.hashCode();
    assertEquals(expectedHashCodeResult, extractProperty.hashCode());
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExtractProperty extractProperty =
        new ExtractProperty("uk.gov.gchq.gaffer.data.element.function.ExtractProperty");

    // Act and Assert
    assertNotEquals(extractProperty, new ExtractProperty("Name"));
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractProperty("Name"), null);
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractProperty("Name"), "Different type to ExtractProperty");
  }
}
