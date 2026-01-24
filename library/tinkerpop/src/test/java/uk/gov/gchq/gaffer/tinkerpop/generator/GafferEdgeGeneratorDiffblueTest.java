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

package uk.gov.gchq.gaffer.tinkerpop.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopEdge;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class GafferEdgeGeneratorDiffblueTest {
  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName("Test _apply(GafferPopEdge) with 'GafferPopEdge'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Act
    Edge actual_applyResult = gafferEdgeGenerator._apply(gafferPopEdge);

    // Assert
    assertEquals("Out Vertex", actual_applyResult.getSource());
    assertEquals("Out Vertex", actual_applyResult.getMatchedVertexValue());
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return MatchedVertexValue size is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; given '42'; then return MatchedVertexValue size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_given42_thenReturnMatchedVertexValueSizeIsOne() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", objectList, "In Vertex", null);

    // Act
    Edge actual_applyResult = gafferEdgeGenerator._apply(gafferPopEdge);

    // Assert
    Object matchedVertexValue = actual_applyResult.getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof List);
    assertEquals(1, ((List<String>) matchedVertexValue).size());
    assertEquals("42", ((List<String>) matchedVertexValue).get(0));
    assertSame(matchedVertexValue, actual_applyResult.getSource());
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return MatchedVertexValue size is two.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; given '42'; then return MatchedVertexValue size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_given42_thenReturnMatchedVertexValueSizeIsTwo() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", objectList, "In Vertex", null);

    // Act and Assert
    Object matchedVertexValue = gafferEdgeGenerator._apply(gafferPopEdge).getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof List);
    assertEquals(2, ((List<String>) matchedVertexValue).size());
    assertEquals("42", ((List<String>) matchedVertexValue).get(0));
    assertEquals("42", ((List<String>) matchedVertexValue).get(1));
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Then MatchedVertexValue return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; then MatchedVertexValue return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_thenMatchedVertexValueReturnSet() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", new HashSet<>(), "In Vertex", null);

    // Act
    Edge actual_applyResult = gafferEdgeGenerator._apply(gafferPopEdge);

    // Assert
    Object matchedVertexValue = actual_applyResult.getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof Set);
    assertTrue(((Set<Object>) matchedVertexValue).isEmpty());
    assertSame(matchedVertexValue, actual_applyResult.getSource());
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Then MatchedVertexValue return {@link TypeSubTypeValue}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; then MatchedVertexValue return TypeSubTypeValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_thenMatchedVertexValueReturnTypeSubTypeValue() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();
    GafferPopEdge gafferPopEdge =
        new GafferPopEdge("Label", "xx[type=xx,  subType=xx,  value=xx]", "In Vertex", null);

    // Act
    Edge actual_applyResult = gafferEdgeGenerator._apply(gafferPopEdge);

    // Assert
    Object matchedVertexValue = actual_applyResult.getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof TypeSubTypeValue);
    assertEquals("xx", ((TypeSubTypeValue) matchedVertexValue).getSubType());
    assertEquals("xx", ((TypeSubTypeValue) matchedVertexValue).getType());
    assertEquals("xx", ((TypeSubTypeValue) matchedVertexValue).getValue());
    assertSame(matchedVertexValue, actual_applyResult.getSource());
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Then return Group is {@code xx[type=xx, subType=xx, value=xx]}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; then return Group is 'xx[type=xx, subType=xx, value=xx]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_thenReturnGroupIsXxTypeXxSubTypeXxValueXx() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();
    GafferPopEdge gafferPopEdge =
        new GafferPopEdge("xx[type=xx,  subType=xx,  value=xx]", "Out Vertex", "In Vertex", null);

    // Act
    Edge actual_applyResult = gafferEdgeGenerator._apply(gafferPopEdge);

    // Assert
    assertEquals("Out Vertex", actual_applyResult.getSource());
    assertEquals("Out Vertex", actual_applyResult.getMatchedVertexValue());
    assertEquals("xx[type=xx,  subType=xx,  value=xx]", actual_applyResult.getGroup());
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Then return MatchedVertexValue Empty.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; then return MatchedVertexValue Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_thenReturnMatchedVertexValueEmpty() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", new ArrayList<>(), "In Vertex", null);

    // Act
    Edge actual_applyResult = gafferEdgeGenerator._apply(gafferPopEdge);

    // Assert
    Object matchedVertexValue = actual_applyResult.getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof List);
    assertTrue(((List<Object>) matchedVertexValue).isEmpty());
    assertSame(matchedVertexValue, actual_applyResult.getSource());
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Then return Properties size is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; then return Properties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_thenReturnPropertiesSizeIsOne() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();

    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("xx[type=xx,  subType=xx,  value=xx]", "Value");

    // Act and Assert
    Properties properties = gafferEdgeGenerator._apply(gafferPopEdge).getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("xx[type=xx,  subType=xx,  value=xx]"));
  }

  /**
   * Test {@link GafferEdgeGenerator#_apply(GafferPopEdge)} with {@code GafferPopEdge}.
   *
   * <ul>
   *   <li>Then return Source intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferEdgeGenerator#_apply(GafferPopEdge)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopEdge) with 'GafferPopEdge'; then return Source intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge GafferEdgeGenerator._apply(GafferPopEdge)"})
  void test_applyWithGafferPopEdge_thenReturnSourceIntValueIsOne() {
    // Arrange
    GafferEdgeGenerator gafferEdgeGenerator = new GafferEdgeGenerator();
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", 1, "In Vertex", null);

    // Act
    Edge actual_applyResult = gafferEdgeGenerator._apply(gafferPopEdge);

    // Assert
    assertEquals(1, ((Integer) actual_applyResult.getSource()).intValue());
    assertEquals(1, ((Integer) actual_applyResult.getMatchedVertexValue()).intValue());
  }
}
