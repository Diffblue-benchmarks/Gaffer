package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ElementTupleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementTuple#ElementTuple()}
   *   <li>{@link ElementTuple#setElement(Element)}
   *   <li>{@link ElementTuple#toString()}
   *   <li>{@link ElementTuple#getElement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElementTuple.<init>()",
    "void ElementTuple.<init>(Element)",
    "Element ElementTuple.getElement()",
    "void ElementTuple.setElement(Element)",
    "String ElementTuple.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ElementTuple actualElementTuple = new ElementTuple();
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    actualElementTuple.setElement(element);
    String actualToStringResult = actualElementTuple.toString();

    // Assert
    assertEquals(
        "ElementTuple[element=Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group"
            + ",properties=Properties[]]]",
        actualToStringResult);
    assertSame(element, actualElementTuple.getElement());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementTuple#ElementTuple(Element)}
   *   <li>{@link ElementTuple#setElement(Element)}
   *   <li>{@link ElementTuple#toString()}
   *   <li>{@link ElementTuple#getElement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElementTuple.<init>()",
    "void ElementTuple.<init>(Element)",
    "Element ElementTuple.getElement()",
    "void ElementTuple.setElement(Element)",
    "String ElementTuple.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    ElementTuple actualElementTuple = new ElementTuple(element);
    Edge element2 =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    actualElementTuple.setElement(element2);
    String actualToStringResult = actualElementTuple.toString();

    // Assert
    assertEquals(
        "ElementTuple[element=Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group"
            + ",properties=Properties[]]]",
        actualToStringResult);
    assertSame(element2, actualElementTuple.getElement());
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   *
   * <p>Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString() {
    // Arrange
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNull(new ElementTuple(element).get("Reference"));
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link ElementTuple#ElementTuple()}.
   *   <li>When {@link ElementTuple#ELEMENT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName(
      "Test get(String) with 'String'; given ElementTuple(); when ELEMENT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString_givenElementTuple_whenElement_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ElementTuple().get(ElementTuple.ELEMENT));
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; then return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString_thenReturnMap() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Object actualGetResult = elementTuple.get(ElementTuple.PROPERTIES);

    // Assert
    assertTrue(actualGetResult instanceof Map);
    assertTrue(((Map<Object, Object>) actualGetResult).isEmpty());
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject() {
    // Arrange
    Edge element = new Edge("Group");
    Properties properties = new Properties();
    element.setProperties(properties);
    ElementTuple elementTuple = new ElementTuple(element);

    // Act
    elementTuple.put("Reference", "Value");

    // Assert
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get("Reference"));
    assertSame(properties, properties2);
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject2() {
    // Arrange
    Edge element = new Edge("Group");
    Properties properties = new Properties();
    element.setProperties(properties);
    ElementTuple elementTuple = new ElementTuple(element);
    GroupedProperties groupedProperties = new GroupedProperties();

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, groupedProperties);

    // Assert
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertEquals(1, properties2.size());
    assertSame(groupedProperties, properties2.get(ElementTuple.PROPERTIES));
    assertSame(properties, properties2);
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Then {@link ElementTuple#ElementTuple(Element)} with element is {@link Edge#Edge(String)}
   *       Element Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName(
      "Test put(String, Object) with 'String', 'Object'; then ElementTuple(Element) with element is Edge(String) Element Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_thenElementTupleWithElementIsEdgeElementPropertiesEmpty() {
    // Arrange
    Edge element = new Edge("Group");
    Properties properties = new Properties();
    element.setProperties(properties);
    ElementTuple elementTuple = new ElementTuple(element);

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, null);

    // Assert that nothing has changed
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>Then {@link ElementTuple#ElementTuple(Element)} with element is {@link Edge#Edge(String)}
   *       Element Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName(
      "Test put(String, Object) with 'String', 'Object'; then ElementTuple(Element) with element is Edge(String) Element Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_thenElementTupleWithElementIsEdgeElementPropertiesEmpty2() {
    // Arrange
    Edge element = new Edge("Group");
    Properties properties = new Properties();
    element.setProperties(properties);
    ElementTuple elementTuple = new ElementTuple(element);

    // Act
    elementTuple.put(null, null);

    // Assert that nothing has changed
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>When {@link ElementTuple#ELEMENT}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName(
      "Test put(String, Object) with 'String', 'Object'; when ELEMENT; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_whenElement_thenThrowIllegalArgumentException() {
    // Arrange
    Edge element = new Edge("Group");
    element.setProperties(new Properties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ElementTuple(element).put(ElementTuple.ELEMENT, null));
  }

  /**
   * Test {@link ElementTuple#equals(Object)}, and {@link ElementTuple#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementTuple#equals(Object)}
   *   <li>{@link ElementTuple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();
    ElementTuple elementTuple2 = new ElementTuple();

    // Act and Assert
    assertEquals(elementTuple, elementTuple2);
    assertEquals(elementTuple.hashCode(), elementTuple2.hashCode());
  }

  /**
   * Test {@link ElementTuple#equals(Object)}, and {@link ElementTuple#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementTuple#equals(Object)}
   *   <li>{@link ElementTuple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();

    // Act and Assert
    assertEquals(elementTuple, elementTuple);
    int expectedHashCodeResult = elementTuple.hashCode();
    assertEquals(expectedHashCodeResult, elementTuple.hashCode());
  }

  /**
   * Test {@link ElementTuple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act and Assert
    assertNotEquals(elementTuple, new ElementTuple());
  }

  /**
   * Test {@link ElementTuple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();

    Builder builder = new Builder();
    elementTuple.setElement(
        builder
            .dest(new ElementTuple())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(elementTuple, new ElementTuple(element));
  }

  /**
   * Test {@link ElementTuple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTuple(), null);
  }

  /**
   * Test {@link ElementTuple#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTuple(), "Different type to ElementTuple");
  }
}
