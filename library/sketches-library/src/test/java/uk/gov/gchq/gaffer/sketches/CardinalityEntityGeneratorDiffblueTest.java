/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.sketches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.sketches.clearspring.cardinality.HyperLogLogPlusEntityGenerator;

class CardinalityEntityGeneratorDiffblueTest {
  /**
   * Test {@link CardinalityEntityGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@code Apply}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; given Function apply(Object) return 'Apply'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CardinalityEntityGenerator._apply(Element)"})
  void test_applyWithElement_givenFunctionApplyReturnApply_thenCallsApply() throws IOException {
    // Arrange
    Function<Object, Object> vertexValueConverter = mock(Function.class);
    when(vertexValueConverter.apply(Mockito.<Object>any())).thenReturn("Apply");

    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();
    hyperLogLogPlusEntityGenerator.setVertexValueConverter(vertexValueConverter);

    // Act
    Iterable<Element> actual_applyResult =
        hyperLogLogPlusEntityGenerator._apply(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());
    actual_applyResult.iterator();

    // Assert
    verify(vertexValueConverter, atLeast(1)).apply(Mockito.<Object>any());
    assertEquals(3, ((List<Element>) actual_applyResult).size());
    Element getResult = ((List<Element>) actual_applyResult).get(1);
    Properties properties = getResult.getProperties();
    assertEquals(1, properties.size());
    Object getResult2 = properties.get("cardinality");
    assertTrue(getResult2 instanceof HyperLogLogPlus);
    Element getResult3 = ((List<Element>) actual_applyResult).get(2);
    Properties properties2 = getResult3.getProperties();
    assertEquals(1, properties2.size());
    Object getResult4 = properties2.get("cardinality");
    assertTrue(getResult4 instanceof HyperLogLogPlus);
    assertTrue(actual_applyResult instanceof List);
    assertTrue(getResult instanceof Entity);
    assertTrue(getResult3 instanceof Entity);
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -7, 7}, ((HyperLogLogPlus) getResult2).getBytes());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -7, 7}, ((HyperLogLogPlus) getResult4).getBytes());
  }

  /**
   * Test {@link CardinalityEntityGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return second Properties {@code 3} longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; then return second Properties '3' longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CardinalityEntityGenerator._apply(Element)"})
  void test_applyWithElement_thenReturnSecondProperties3LongValueIsOne() throws IOException {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();
    hyperLogLogPlusEntityGenerator.setCountProperty("3");

    // Act
    Iterable<Element> actual_applyResult =
        hyperLogLogPlusEntityGenerator._apply(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());
    actual_applyResult.iterator();

    // Assert
    assertEquals(3, ((List<Element>) actual_applyResult).size());
    Element getResult = ((List<Element>) actual_applyResult).get(1);
    Properties properties = getResult.getProperties();
    assertEquals(2, properties.size());
    Object getResult2 = properties.get("cardinality");
    assertTrue(getResult2 instanceof HyperLogLogPlus);
    Element getResult3 = ((List<Element>) actual_applyResult).get(2);
    Properties properties2 = getResult3.getProperties();
    assertEquals(2, properties2.size());
    Object getResult4 = properties2.get("cardinality");
    assertTrue(getResult4 instanceof HyperLogLogPlus);
    assertTrue(actual_applyResult instanceof List);
    assertTrue(getResult instanceof Entity);
    assertTrue(getResult3 instanceof Entity);
    assertEquals(1L, ((Long) properties.get("3")).longValue());
    assertEquals(1L, ((Long) properties2.get("3")).longValue());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -13, 20},
        ((HyperLogLogPlus) getResult2).getBytes());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 21}, ((HyperLogLogPlus) getResult4).getBytes());
  }

  /**
   * Test {@link CardinalityEntityGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return second Properties size is one.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; then return second Properties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CardinalityEntityGenerator._apply(Element)"})
  void test_applyWithElement_thenReturnSecondPropertiesSizeIsOne() throws IOException {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    Iterable<Element> actual_applyResult =
        hyperLogLogPlusEntityGenerator._apply(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());
    actual_applyResult.iterator();

    // Assert
    assertEquals(3, ((List<Element>) actual_applyResult).size());
    Element getResult = ((List<Element>) actual_applyResult).get(1);
    Properties properties = getResult.getProperties();
    assertEquals(1, properties.size());
    Object getResult2 = properties.get("cardinality");
    assertTrue(getResult2 instanceof HyperLogLogPlus);
    Element getResult3 = ((List<Element>) actual_applyResult).get(2);
    Properties properties2 = getResult3.getProperties();
    assertEquals(1, properties2.size());
    Object getResult4 = properties2.get("cardinality");
    assertTrue(getResult4 instanceof HyperLogLogPlus);
    assertTrue(actual_applyResult instanceof List);
    assertTrue(getResult instanceof Entity);
    assertTrue(getResult3 instanceof Entity);
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -13, 20},
        ((HyperLogLogPlus) getResult2).getBytes());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 21}, ((HyperLogLogPlus) getResult4).getBytes());
  }

  /**
   * Test {@link CardinalityEntityGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then second Properties {@code Edge Group Property} return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; then second Properties 'Edge Group Property' return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CardinalityEntityGenerator._apply(Element)"})
  void test_applyWithElement_thenSecondPropertiesEdgeGroupPropertyReturnSet() throws IOException {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();
    hyperLogLogPlusEntityGenerator.setEdgeGroupProperty("Edge Group Property");

    // Act
    Iterable<Element> actual_applyResult =
        hyperLogLogPlusEntityGenerator._apply(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());
    actual_applyResult.iterator();

    // Assert
    assertEquals(3, ((List<Element>) actual_applyResult).size());
    Element getResult = ((List<Element>) actual_applyResult).get(1);
    Properties properties = getResult.getProperties();
    assertEquals(2, properties.size());
    Object getResult2 = properties.get("cardinality");
    assertTrue(getResult2 instanceof HyperLogLogPlus);
    Element getResult3 = ((List<Element>) actual_applyResult).get(2);
    Properties properties2 = getResult3.getProperties();
    assertEquals(2, properties2.size());
    Object getResult4 = properties2.get("cardinality");
    assertTrue(getResult4 instanceof HyperLogLogPlus);
    assertTrue(actual_applyResult instanceof List);
    Object getResult5 = properties.get("Edge Group Property");
    assertTrue(getResult5 instanceof Set);
    assertTrue(getResult instanceof Entity);
    assertTrue(getResult3 instanceof Entity);
    assertEquals(1, ((Set<String>) getResult5).size());
    assertEquals(getResult5, properties2.get("Edge Group Property"));
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -13, 20},
        ((HyperLogLogPlus) getResult2).getBytes());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 21}, ((HyperLogLogPlus) getResult4).getBytes());
  }

  /**
   * Test {@link CardinalityEntityGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return first is {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; when Edge(String) with 'Group'; then return first is Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CardinalityEntityGenerator._apply(Element)"})
  void test_applyWithElement_whenEdgeWithGroup_thenReturnFirstIsEdgeWithGroup() {
    // Arrange
    Edge element = new Edge("Group");

    // Act
    Iterable<Element> actual_applyResult = new HyperLogLogPlusEntityGenerator()._apply(element);
    Iterator<Element> actualIteratorResult = actual_applyResult.iterator();

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertEquals(1, ((List<Element>) actual_applyResult).size());
    assertSame(element, ((List<Element>) actual_applyResult).get(0));
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(element, actualNextResult);
  }

  /**
   * Test {@link CardinalityEntityGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; when Entity(String) with 'Group'; then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CardinalityEntityGenerator._apply(Element)"})
  void test_applyWithElement_whenEntityWithGroup_thenReturnSet() {
    // Arrange
    Entity element = new Entity("Group");

    // Act
    Iterable<Element> actual_applyResult = new HyperLogLogPlusEntityGenerator()._apply(element);
    Iterator<Element> actualIteratorResult = actual_applyResult.iterator();

    // Assert
    assertTrue(actual_applyResult instanceof Set);
    assertEquals(1, ((Set<Element>) actual_applyResult).size());
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(element, actualNextResult);
  }

  /**
   * Test {@link CardinalityEntityGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CardinalityEntityGenerator._apply(Element)"})
  void test_applyWithElement_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Iterable<Element> actual_applyResult = new HyperLogLogPlusEntityGenerator()._apply(null);
    Iterator<Element> actualIteratorResult = actual_applyResult.iterator();

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Element>) actual_applyResult).isEmpty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getPropertiesToCopy()}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#getPropertiesToCopy()}
   */
  @Test
  @DisplayName("Test getPropertiesToCopy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CardinalityEntityGenerator.getPropertiesToCopy()"})
  void testGetPropertiesToCopy() {
    // Arrange, Act and Assert
    assertTrue(new HyperLogLogPlusEntityGenerator().getPropertiesToCopy().isEmpty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}
   */
  @Test
  @DisplayName("Test setPropertiesToCopy(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setPropertiesToCopy(Collection)"})
  void testSetPropertiesToCopy() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    ArrayList<String> propertiesToCopy = new ArrayList<>();
    propertiesToCopy.add("propertiesToCopy is required");

    // Act
    hyperLogLogPlusEntityGenerator.setPropertiesToCopy(propertiesToCopy);

    // Assert
    Set<String> propertiesToCopy2 = hyperLogLogPlusEntityGenerator.getPropertiesToCopy();
    assertEquals(1, propertiesToCopy2.size());
    assertTrue(propertiesToCopy2.contains("propertiesToCopy is required"));
  }

  /**
   * Test {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}
   */
  @Test
  @DisplayName("Test setPropertiesToCopy(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setPropertiesToCopy(Collection)"})
  void testSetPropertiesToCopy2() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    ArrayList<String> propertiesToCopy = new ArrayList<>();
    propertiesToCopy.add("foo");
    propertiesToCopy.add("propertiesToCopy is required");

    // Act
    hyperLogLogPlusEntityGenerator.setPropertiesToCopy(propertiesToCopy);

    // Assert
    Set<String> propertiesToCopy2 = hyperLogLogPlusEntityGenerator.getPropertiesToCopy();
    assertEquals(2, propertiesToCopy2.size());
    assertTrue(propertiesToCopy2.contains("foo"));
    assertTrue(propertiesToCopy2.contains("propertiesToCopy is required"));
  }

  /**
   * Test {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}.
   *
   * <ul>
   *   <li>Then {@link HyperLogLogPlusEntityGenerator} (default constructor) PropertiesToCopy Empty.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}
   */
  @Test
  @DisplayName(
      "Test setPropertiesToCopy(Collection); then HyperLogLogPlusEntityGenerator (default constructor) PropertiesToCopy Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setPropertiesToCopy(Collection)"})
  void testSetPropertiesToCopy_thenHyperLogLogPlusEntityGeneratorPropertiesToCopyEmpty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setPropertiesToCopy(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(hyperLogLogPlusEntityGenerator.getPropertiesToCopy().isEmpty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getGroup()}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CardinalityEntityGenerator.getGroup()"})
  void testGetGroup() {
    // Arrange, Act and Assert
    assertEquals("Cardinality", new HyperLogLogPlusEntityGenerator().getGroup());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setGroup(String)}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setGroup(String)}
   */
  @Test
  @DisplayName("Test setGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setGroup(String)"})
  void testSetGroup() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setGroup("Group");

    // Assert
    assertEquals("Group", hyperLogLogPlusEntityGenerator.getGroup());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getCardinalityPropertyName()}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#getCardinalityPropertyName()}
   */
  @Test
  @DisplayName("Test getCardinalityPropertyName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CardinalityEntityGenerator.getCardinalityPropertyName()"})
  void testGetCardinalityPropertyName() {
    // Arrange, Act and Assert
    assertEquals("cardinality", new HyperLogLogPlusEntityGenerator().getCardinalityPropertyName());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setCardinalityPropertyName(String)}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setCardinalityPropertyName(String)}
   */
  @Test
  @DisplayName("Test setCardinalityPropertyName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setCardinalityPropertyName(String)"})
  void testSetCardinalityPropertyName() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setCardinalityPropertyName("Cardinality Property Name");

    // Assert
    assertEquals(
        "Cardinality Property Name", hyperLogLogPlusEntityGenerator.getCardinalityPropertyName());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getCountProperty()}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#getCountProperty()}
   */
  @Test
  @DisplayName("Test getCountProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CardinalityEntityGenerator.getCountProperty()"})
  void testGetCountProperty() {
    // Arrange, Act and Assert
    assertNull(new HyperLogLogPlusEntityGenerator().getCountProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setCountProperty(String)}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setCountProperty(String)}
   */
  @Test
  @DisplayName("Test setCountProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setCountProperty(String)"})
  void testSetCountProperty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setCountProperty("3");

    // Assert
    assertEquals("3", hyperLogLogPlusEntityGenerator.getCountProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getEdgeGroupProperty()}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#getEdgeGroupProperty()}
   */
  @Test
  @DisplayName("Test getEdgeGroupProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CardinalityEntityGenerator.getEdgeGroupProperty()"})
  void testGetEdgeGroupProperty() {
    // Arrange, Act and Assert
    assertNull(new HyperLogLogPlusEntityGenerator().getEdgeGroupProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setEdgeGroupProperty(String)}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setEdgeGroupProperty(String)}
   */
  @Test
  @DisplayName("Test setEdgeGroupProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setEdgeGroupProperty(String)"})
  void testSetEdgeGroupProperty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setEdgeGroupProperty("Edge Group Property");

    // Assert
    assertEquals("Edge Group Property", hyperLogLogPlusEntityGenerator.getEdgeGroupProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getVertexValueConverter()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#getVertexValueConverter()}
   */
  @Test
  @DisplayName("Test getVertexValueConverter(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function CardinalityEntityGenerator.getVertexValueConverter()"})
  void testGetVertexValueConverter_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new HyperLogLogPlusEntityGenerator().getVertexValueConverter());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setVertexValueConverter(Function)}.
   *
   * <p>Method under test: {@link CardinalityEntityGenerator#setVertexValueConverter(Function)}
   */
  @Test
  @DisplayName("Test setVertexValueConverter(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CardinalityEntityGenerator.setVertexValueConverter(Function)"})
  void testSetVertexValueConverter() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();
    Function<Object, Object> vertexValueConverter = mock(Function.class);

    // Act
    hyperLogLogPlusEntityGenerator.setVertexValueConverter(vertexValueConverter);

    // Assert
    assertSame(vertexValueConverter, hyperLogLogPlusEntityGenerator.getVertexValueConverter());
  }
}
