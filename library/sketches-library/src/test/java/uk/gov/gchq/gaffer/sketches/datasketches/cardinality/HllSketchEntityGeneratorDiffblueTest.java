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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.sketches.datasketches.cardinality.function.ToHllSketch;

class HllSketchEntityGeneratorDiffblueTest {
  /**
   * Test {@link HllSketchEntityGenerator#propertyToCopy(String)}.
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#propertyToCopy(String)}
   */
  @Test
  @DisplayName("Test propertyToCopy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketchEntityGenerator HllSketchEntityGenerator.propertyToCopy(String)"})
  void testPropertyToCopy() {
    // Arrange
    HllSketchEntityGenerator hllSketchEntityGenerator = new HllSketchEntityGenerator();

    // Act
    HllSketchEntityGenerator actualPropertyToCopyResult =
        hllSketchEntityGenerator.propertyToCopy("Property To Copy");

    // Assert
    assertSame(hllSketchEntityGenerator, actualPropertyToCopyResult);
  }

  /**
   * Test {@link HllSketchEntityGenerator#propertiesToCopy(String[])}.
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#propertiesToCopy(String[])}
   */
  @Test
  @DisplayName("Test propertiesToCopy(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HllSketchEntityGenerator HllSketchEntityGenerator.propertiesToCopy(String[])"
  })
  void testPropertiesToCopy() {
    // Arrange
    HllSketchEntityGenerator hllSketchEntityGenerator = new HllSketchEntityGenerator();

    // Act
    HllSketchEntityGenerator actualPropertiesToCopyResult =
        hllSketchEntityGenerator.propertiesToCopy("Properties To Copy");

    // Assert
    assertSame(hllSketchEntityGenerator, actualPropertiesToCopyResult);
  }

  /**
   * Test {@link HllSketchEntityGenerator#group(String)}.
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#group(String)}
   */
  @Test
  @DisplayName("Test group(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketchEntityGenerator HllSketchEntityGenerator.group(String)"})
  void testGroup() {
    // Arrange
    HllSketchEntityGenerator hllSketchEntityGenerator = new HllSketchEntityGenerator();

    // Act
    HllSketchEntityGenerator actualGroupResult = hllSketchEntityGenerator.group("Group");

    // Assert
    assertEquals("Group", hllSketchEntityGenerator.getGroup());
    assertSame(hllSketchEntityGenerator, actualGroupResult);
  }

  /**
   * Test {@link HllSketchEntityGenerator#cardinalityPropertyName(String)}.
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#cardinalityPropertyName(String)}
   */
  @Test
  @DisplayName("Test cardinalityPropertyName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HllSketchEntityGenerator HllSketchEntityGenerator.cardinalityPropertyName(String)"
  })
  void testCardinalityPropertyName() {
    // Arrange
    HllSketchEntityGenerator hllSketchEntityGenerator = new HllSketchEntityGenerator();

    // Act
    HllSketchEntityGenerator actualCardinalityPropertyNameResult =
        hllSketchEntityGenerator.cardinalityPropertyName("Cardinality Property Name");

    // Assert
    assertEquals(
        "Cardinality Property Name", hllSketchEntityGenerator.getCardinalityPropertyName());
    assertSame(hllSketchEntityGenerator, actualCardinalityPropertyNameResult);
  }

  /**
   * Test {@link HllSketchEntityGenerator#countProperty(String)}.
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#countProperty(String)}
   */
  @Test
  @DisplayName("Test countProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketchEntityGenerator HllSketchEntityGenerator.countProperty(String)"})
  void testCountProperty() {
    // Arrange
    HllSketchEntityGenerator hllSketchEntityGenerator = new HllSketchEntityGenerator();

    // Act
    HllSketchEntityGenerator actualCountPropertyResult =
        hllSketchEntityGenerator.countProperty("3");

    // Assert
    assertEquals("3", hllSketchEntityGenerator.getCountProperty());
    assertSame(hllSketchEntityGenerator, actualCountPropertyResult);
  }

  /**
   * Test {@link HllSketchEntityGenerator#edgeGroupProperty(String)}.
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#edgeGroupProperty(String)}
   */
  @Test
  @DisplayName("Test edgeGroupProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketchEntityGenerator HllSketchEntityGenerator.edgeGroupProperty(String)"})
  void testEdgeGroupProperty() {
    // Arrange
    HllSketchEntityGenerator hllSketchEntityGenerator = new HllSketchEntityGenerator();

    // Act
    HllSketchEntityGenerator actualEdgeGroupPropertyResult =
        hllSketchEntityGenerator.edgeGroupProperty("Edge Group Property");

    // Assert
    assertEquals("Edge Group Property", hllSketchEntityGenerator.getEdgeGroupProperty());
    assertSame(hllSketchEntityGenerator, actualEdgeGroupPropertyResult);
  }

  /**
   * Test {@link HllSketchEntityGenerator#getToSketchFunction()}.
   *
   * <ul>
   *   <li>Then return HllSketch CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#getToSketchFunction()}
   */
  @Test
  @DisplayName("Test getToSketchFunction(); then return HllSketch CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function HllSketchEntityGenerator.getToSketchFunction()"})
  void testGetToSketchFunction_thenReturnHllSketchCompositeEstimateIsOne() {
    // Arrange and Act
    Function<Object, HllSketch> actualToSketchFunction =
        new HllSketchEntityGenerator().getToSketchFunction();
    actualToSketchFunction.apply("42");

    // Assert
    assertTrue(actualToSketchFunction instanceof ToHllSketch);
    HllSketch hllSketch = ((ToHllSketch) actualToSketchFunction).getHllSketch();
    assertEquals(1.0d, hllSketch.getCompositeEstimate());
    assertEquals(1.0d, hllSketch.getEstimate());
    assertEquals(12, hllSketch.getCompactSerializationBytes());
    assertFalse(hllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchEntityGenerator#getToSketchFunction()}.
   *
   * <ul>
   *   <li>Then return HllSketch CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#getToSketchFunction()}
   */
  @Test
  @DisplayName("Test getToSketchFunction(); then return HllSketch CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function HllSketchEntityGenerator.getToSketchFunction()"})
  void testGetToSketchFunction_thenReturnHllSketchCompositeEstimateIsOne2() {
    // Arrange and Act
    Function<Object, HllSketch> actualToSketchFunction =
        new HllSketchEntityGenerator().getToSketchFunction();
    actualToSketchFunction.apply(1);

    // Assert
    assertTrue(actualToSketchFunction instanceof ToHllSketch);
    HllSketch hllSketch = ((ToHllSketch) actualToSketchFunction).getHllSketch();
    assertEquals(1.0d, hllSketch.getCompositeEstimate());
    assertEquals(1.0d, hllSketch.getEstimate());
    assertEquals(12, hllSketch.getCompactSerializationBytes());
    assertFalse(hllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchEntityGenerator#getToSketchFunction()}.
   *
   * <ul>
   *   <li>Then return HllSketch CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#getToSketchFunction()}
   */
  @Test
  @DisplayName("Test getToSketchFunction(); then return HllSketch CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function HllSketchEntityGenerator.getToSketchFunction()"})
  void testGetToSketchFunction_thenReturnHllSketchCompositeEstimateIsOne3() {
    // Arrange and Act
    Function<Object, HllSketch> actualToSketchFunction =
        new HllSketchEntityGenerator().getToSketchFunction();
    actualToSketchFunction.apply(1L);

    // Assert
    assertTrue(actualToSketchFunction instanceof ToHllSketch);
    HllSketch hllSketch = ((ToHllSketch) actualToSketchFunction).getHllSketch();
    assertEquals(1.0d, hllSketch.getCompositeEstimate());
    assertEquals(1.0d, hllSketch.getEstimate());
    assertEquals(12, hllSketch.getCompactSerializationBytes());
    assertFalse(hllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchEntityGenerator#getToSketchFunction()}.
   *
   * <ul>
   *   <li>Then return HllSketch CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchEntityGenerator#getToSketchFunction()}
   */
  @Test
  @DisplayName("Test getToSketchFunction(); then return HllSketch CompositeEstimate is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function HllSketchEntityGenerator.getToSketchFunction()"})
  void testGetToSketchFunction_thenReturnHllSketchCompositeEstimateIsZero() {
    // Arrange and Act
    Function<Object, HllSketch> actualToSketchFunction =
        new HllSketchEntityGenerator().getToSketchFunction();
    actualToSketchFunction.apply("");

    // Assert
    assertTrue(actualToSketchFunction instanceof ToHllSketch);
    HllSketch hllSketch = ((ToHllSketch) actualToSketchFunction).getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertTrue(hllSketch.isEmpty());
  }
}
