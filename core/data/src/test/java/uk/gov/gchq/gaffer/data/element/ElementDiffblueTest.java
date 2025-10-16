package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ElementDiffblueTest {
  /**
   * Test {@link Element#putProperty(String, Object)}.
   *
   * <p>Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putProperty("Name", "Value");

    // Assert
    Properties properties = lazyEdge.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link Element#putProperty(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code Value}.
   *   <li>Then {@link Edge#Edge()} Properties size is one.
   * </ul>
   *
   * <p>Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName(
      "Test putProperty(String, Object); given Edge(); when 'Value'; then Edge() Properties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty_givenEdge_whenValue_thenEdgePropertiesSizeIsOne() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putProperty("Name", "Value");

    // Assert
    Properties properties = edge.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link Element#putProperty(String, Object)}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object); then Edge(String) with 'Group' Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty_thenEdgeWithGroupPropertiesEmpty() {
    // Arrange
    Edge edge = new Edge("Group");
    Properties properties = new Properties();
    edge.setProperties(properties);

    // Act
    edge.putProperty(null, null);

    // Assert that nothing has changed
    Properties properties2 = edge.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link Element#putProperty(String, Object)}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object); then Edge(String) with 'Group' Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty_thenEdgeWithGroupPropertiesEmpty2() {
    // Arrange
    Edge edge = new Edge("Group");
    Properties properties = new Properties();
    edge.setProperties(properties);

    // Act
    edge.putProperty("Name", null);

    // Assert that nothing has changed
    Properties properties2 = edge.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   *
   * <p>Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName("Test copyProperties(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));
    lazyEdge.putIdentifier(IdentifierType.SOURCE, "Value");

    Properties properties = new Properties();
    properties.put("Name", "Value");

    // Act
    lazyEdge.copyProperties(properties);

    // Assert
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
    assertEquals(properties, lazyEdge.getElement().getProperties());
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>Then {@link Edge#Edge()} Properties is {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test copyProperties(Properties); given Edge(); then Edge() Properties is Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties_givenEdge_thenEdgePropertiesIsProperties() {
    // Arrange
    Edge edge = new Edge();

    Properties properties = new Properties();
    properties.put("Name", "Value");

    // Act
    edge.copyProperties(properties);

    // Assert
    assertEquals(properties, edge.getProperties());
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then {@link Edge#Edge()} Properties is {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test copyProperties(Properties); given Edge(); when Properties(); then Edge() Properties is Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties_givenEdge_whenProperties_thenEdgePropertiesIsProperties() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();

    // Act
    edge.copyProperties(properties);

    // Assert that nothing has changed
    assertEquals(properties, edge.getProperties());
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName("Test copyProperties(Properties); then Edge(String) with 'Group' Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties_thenEdgeWithGroupPropertiesEmpty() {
    // Arrange
    Edge edge = new Edge("Group");
    Properties properties = new Properties();
    edge.setProperties(properties);

    // Act
    edge.copyProperties(null);

    // Assert that nothing has changed
    Properties properties2 = edge.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link Element#getProperty(String)}.
   *
   * <p>Method under test: {@link Element#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Element.getProperty(String)"})
  void testGetProperty() {
    // Arrange
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

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualProperty = lazyEdge.getProperty("Name");

    // Assert
    verify(valueLoader).getProperty(eq("Name"), isA(Properties.class));
    Properties properties = lazyEdge.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Name"));
    assertEquals("Property", actualProperty);
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link Element#getProperty(String)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Element#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); given Edge(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Element.getProperty(String)"})
  void testGetProperty_givenEdge_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Edge().getProperty("Name"));
  }

  /**
   * Test {@link Element#getProperties()}.
   *
   * <p>Method under test: {@link Element#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties Element.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue(new Edge().getProperties().isEmpty());
  }

  /**
   * Test {@link Element#removeProperty(String)}.
   *
   * <p>Method under test: {@link Element#removeProperty(String)}
   */
  @Test
  @DisplayName("Test removeProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Element.removeProperty(String)"})
  void testRemoveProperty() {
    // Arrange, Act and Assert
    assertNull(new Edge().removeProperty("Prop Name"));
  }

  /**
   * Test {@link Element#getGroup()}.
   *
   * <p>Method under test: {@link Element#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Element.getGroup()"})
  void testGetGroup() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, new Edge().getGroup());
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code foo}.
   *   <li>When {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Element) with 'element'; given Edge(String) with 'Group' Group is 'foo'; when Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement_givenEdgeWithGroupGroupIsFoo_whenEdge() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");

    // Act and Assert
    assertFalse(edge.shallowEquals(new Edge()));
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code null}.
   *   <li>When {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Element) with 'element'; given Edge(String) with 'Group' Group is 'null'; when Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement_givenEdgeWithGroupGroupIsNull_whenEdge() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup(null);

    // Act and Assert
    assertFalse(edge.shallowEquals(new Edge()));
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Element) with 'element'; given Edge(String) with 'Group' Group is 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement_givenEdgeWithGroupGroupIsNull_whenNull() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup(null);

    // Act and Assert
    assertFalse(edge.shallowEquals((Element) null));
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@link Edge#Edge()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Element) with 'element'; given Edge(); when Edge(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement_givenEdge_whenEdge_thenReturnTrue() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.shallowEquals(new Edge()));
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group} Group is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Element) with 'element'; given 'null'; when Edge(String) with 'Group' Group is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement_givenNull_whenEdgeWithGroupGroupIsNull() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");

    Edge element = new Edge("Group");
    element.setGroup(null);

    // Act
    boolean actualShallowEqualsResult = edge.shallowEquals(element);

    // Assert
    assertFalse(actualShallowEqualsResult);
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Object) with 'obj'; given Edge(String) with 'Group' Group is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_givenEdgeWithGroupGroupIsFoo() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");

    Edge edge2 = new Edge("Group");
    edge2.setGroup(null);

    // Act
    boolean actualShallowEqualsResult = edge.shallowEquals((Object) edge2);

    // Assert
    assertFalse(actualShallowEqualsResult);
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Object) with 'obj'; given Edge(String) with 'Group' Group is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_givenEdgeWithGroupGroupIsFoo2() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup("foo");

    Edge edge2 = new Edge("Group");
    edge2.setGroup("Obj");

    // Act
    boolean actualShallowEqualsResult = edge.shallowEquals((Object) edge2);

    // Assert
    assertFalse(actualShallowEqualsResult);
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group} Group is {@code null}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Object) with 'obj'; given Edge(String) with 'Group' Group is 'null'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_givenEdgeWithGroupGroupIsNull_whenNull_thenReturnFalse() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup(null);

    // Act and Assert
    assertFalse(edge.shallowEquals((Object) null));
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Object) with 'obj'; given Edge(); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_givenEdge_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Edge().shallowEquals("Obj"));
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group} Group is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Object) with 'obj'; given 'null'; when Edge(String) with 'Group' Group is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_givenNull_whenEdgeWithGroupGroupIsNull_thenReturnTrue() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup(null);

    Edge edge2 = new Edge("Group");
    edge2.setGroup(null);

    // Act
    boolean actualShallowEqualsResult = edge.shallowEquals((Object) edge2);

    // Assert
    assertTrue(actualShallowEqualsResult);
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   *
   * <ul>
   *   <li>Given {@code Obj}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group} Group is {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName(
      "Test shallowEquals(Object) with 'obj'; given 'Obj'; when Edge(String) with 'Group' Group is 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_givenObj_whenEdgeWithGroupGroupIsObj_thenReturnFalse() {
    // Arrange
    Edge edge = new Edge("Group");
    edge.setGroup(null);

    Edge edge2 = new Edge("Group");
    edge2.setGroup("Obj");

    // Act
    boolean actualShallowEqualsResult = edge.shallowEquals((Object) edge2);

    // Assert
    assertFalse(actualShallowEqualsResult);
  }

  /**
   * Test {@link Element#equals(Object)}, and {@link Element#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Edge edge2 =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertEquals(edge, edge2);
    assertEquals(edge.hashCode(), edge2.hashCode());
  }

  /**
   * Test {@link Element#equals(Object)}, and {@link Element#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertEquals(edge, edge);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Test {@link Element#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest(1)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(
        edge,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link Element#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build(),
        null);
  }

  /**
   * Test {@link Element#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build(),
        "Different type to Element");
  }

  /**
   * Test {@link Element#toString()}.
   *
   * <p>Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Element.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group,properties"
            + "=Properties[]]",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build()
            .toString());
  }

  /**
   * Test {@link Element#toString()}.
   *
   * <p>Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Element.toString()"})
  void testToString2() {
    // Arrange
    Edge edge = new Edge();
    edge.putProperty("source", "Value");

    // Act and Assert
    assertEquals(
        "Edge[directed=false,group=UNKNOWN,properties=Properties[source=<java.lang.String>Value]]",
        edge.toString());
  }

  /**
   * Test {@link Element#toString()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()} Property {@code destination} is {@code Value}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Edge() Property 'destination' is 'Value'; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Element.toString()"})
  void testToString_givenEdgePropertyDestinationIsValue_thenReturnAString() {
    // Arrange
    Edge edge = new Edge();
    edge.putProperty("destination", "Value");
    edge.putProperty("source", "Value");

    // Act and Assert
    assertEquals(
        "Edge[directed=false,group=UNKNOWN,properties=Properties[destination=<java.lang.String>Value,source="
            + "<java.lang.String>Value]]",
        edge.toString());
  }

  /**
   * Test {@link Element#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Edge[directed=false,group=UNKNOWN,properties=Properties[]]}.
   * </ul>
   *
   * <p>Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'Edge[directed=false,group=UNKNOWN,properties=Properties[]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Element.toString()"})
  void testToString_thenReturnEdgeDirectedFalseGroupUnknownPropertiesProperties() {
    // Arrange, Act and Assert
    assertEquals(
        "Edge[directed=false,group=UNKNOWN,properties=Properties[]]", new Edge().toString());
  }

  /**
   * Test {@link Element#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()}.
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Edge(); then return Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone_givenEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();

    // Act
    Edge actualShallowCloneResult = edge.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof Edge);
    assertEquals(edge, actualShallowCloneResult);
  }

  /**
   * Test {@link Element#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Destination is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Destination is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone_thenReturnDestinationIsDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Edge actualShallowCloneResult = lazyEdge.shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualShallowCloneResult instanceof Edge);
    assertEquals("Dest", ((Edge) actualShallowCloneResult).getDestination());
    assertEquals("Dest", ((Edge) actualShallowCloneResult).getAdjacentMatchedVertexValue());
    assertEquals("Group", actualShallowCloneResult.getGroup());
    assertEquals("Source", ((Edge) actualShallowCloneResult).getSource());
    assertEquals("Source", ((Edge) actualShallowCloneResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualShallowCloneResult.getClassName());
    assertEquals(DirectedType.DIRECTED, ((Edge) actualShallowCloneResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) actualShallowCloneResult).getMatchedVertex());
    assertFalse(((Edge) actualShallowCloneResult).isUndirected());
    assertTrue(actualShallowCloneResult.getProperties().isEmpty());
    assertTrue(((Edge) actualShallowCloneResult).isDirected());
  }

  /**
   * Test {@link Element#getElement()}.
   *
   * <p>Method under test: {@link Element#getElement()}
   */
  @Test
  @DisplayName("Test getElement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element Element.getElement()"})
  void testGetElement() {
    // Arrange
    Edge edge = new Edge();

    // Act
    Element actualElement = edge.getElement();

    // Assert
    assertSame(edge, actualElement);
  }

  /**
   * Test {@link Element#setGroup(String)}.
   *
   * <p>Method under test: {@link Element#setGroup(String)}
   */
  @Test
  @DisplayName("Test setGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.setGroup(String)"})
  void testSetGroup() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setGroup("Group");

    // Assert
    assertEquals("Group", edge.getGroup());
  }

  /**
   * Test {@link Element#setProperties(Properties)}.
   *
   * <p>Method under test: {@link Element#setProperties(Properties)}
   */
  @Test
  @DisplayName("Test setProperties(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Element.setProperties(Properties)"})
  void testSetProperties() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();

    // Act
    edge.setProperties(properties);

    // Assert
    assertSame(properties, edge.getProperties());
  }
}
