/*
 * Copyright 2025 Crown Copyright
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.sketches.clearspring.cardinality.HyperLogLogPlusEntityGenerator;

class CardinalityEntityGeneratorDiffblueTest {
  /**
   * Test {@link CardinalityEntityGenerator#getPropertiesToCopy()}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#getPropertiesToCopy()}
   */
  @Test
  @DisplayName("Test getPropertiesToCopy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set CardinalityEntityGenerator.getPropertiesToCopy()"})
  void testGetPropertiesToCopy() {
    // Arrange, Act and Assert
    assertTrue((new HyperLogLogPlusEntityGenerator()).getPropertiesToCopy().isEmpty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}
   */
  @Test
  @DisplayName("Test setPropertiesToCopy(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setPropertiesToCopy(Collection)"})
  void testSetPropertiesToCopy() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();

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
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}
   */
  @Test
  @DisplayName("Test setPropertiesToCopy(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setPropertiesToCopy(Collection)"})
  void testSetPropertiesToCopy2() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();

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
   * <ul>
   *   <li>Then {@link HyperLogLogPlusEntityGenerator} (default constructor) PropertiesToCopy Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setPropertiesToCopy(Collection)}
   */
  @Test
  @DisplayName("Test setPropertiesToCopy(Collection); then HyperLogLogPlusEntityGenerator (default constructor) PropertiesToCopy Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setPropertiesToCopy(Collection)"})
  void testSetPropertiesToCopy_thenHyperLogLogPlusEntityGeneratorPropertiesToCopyEmpty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setPropertiesToCopy(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(hyperLogLogPlusEntityGenerator.getPropertiesToCopy().isEmpty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getGroup()}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CardinalityEntityGenerator.getGroup()"})
  void testGetGroup() {
    // Arrange, Act and Assert
    assertEquals("Cardinality", (new HyperLogLogPlusEntityGenerator()).getGroup());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setGroup(String)}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setGroup(String)}
   */
  @Test
  @DisplayName("Test setGroup(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setGroup(String)"})
  void testSetGroup() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setGroup("Group");

    // Assert
    assertEquals("Group", hyperLogLogPlusEntityGenerator.getGroup());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getCardinalityPropertyName()}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#getCardinalityPropertyName()}
   */
  @Test
  @DisplayName("Test getCardinalityPropertyName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CardinalityEntityGenerator.getCardinalityPropertyName()"})
  void testGetCardinalityPropertyName() {
    // Arrange, Act and Assert
    assertEquals("cardinality", (new HyperLogLogPlusEntityGenerator()).getCardinalityPropertyName());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setCardinalityPropertyName(String)}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setCardinalityPropertyName(String)}
   */
  @Test
  @DisplayName("Test setCardinalityPropertyName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setCardinalityPropertyName(String)"})
  void testSetCardinalityPropertyName() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setCardinalityPropertyName("Cardinality Property Name");

    // Assert
    assertEquals("Cardinality Property Name", hyperLogLogPlusEntityGenerator.getCardinalityPropertyName());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getCountProperty()}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#getCountProperty()}
   */
  @Test
  @DisplayName("Test getCountProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CardinalityEntityGenerator.getCountProperty()"})
  void testGetCountProperty() {
    // Arrange, Act and Assert
    assertNull((new HyperLogLogPlusEntityGenerator()).getCountProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setCountProperty(String)}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setCountProperty(String)}
   */
  @Test
  @DisplayName("Test setCountProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setCountProperty(String)"})
  void testSetCountProperty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setCountProperty("3");

    // Assert
    assertEquals("3", hyperLogLogPlusEntityGenerator.getCountProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#getEdgeGroupProperty()}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#getEdgeGroupProperty()}
   */
  @Test
  @DisplayName("Test getEdgeGroupProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CardinalityEntityGenerator.getEdgeGroupProperty()"})
  void testGetEdgeGroupProperty() {
    // Arrange, Act and Assert
    assertNull((new HyperLogLogPlusEntityGenerator()).getEdgeGroupProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setEdgeGroupProperty(String)}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setEdgeGroupProperty(String)}
   */
  @Test
  @DisplayName("Test setEdgeGroupProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setEdgeGroupProperty(String)"})
  void testSetEdgeGroupProperty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();

    // Act
    hyperLogLogPlusEntityGenerator.setEdgeGroupProperty("Edge Group Property");

    // Assert
    assertEquals("Edge Group Property", hyperLogLogPlusEntityGenerator.getEdgeGroupProperty());
  }

  /**
   * Test {@link CardinalityEntityGenerator#setVertexValueConverter(Function)}.
   * <p>
   * Method under test: {@link CardinalityEntityGenerator#setVertexValueConverter(Function)}
   */
  @Test
  @DisplayName("Test setVertexValueConverter(Function)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CardinalityEntityGenerator.setVertexValueConverter(Function)"})
  void testSetVertexValueConverter() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator = new HyperLogLogPlusEntityGenerator();
    Function<Object, Object> vertexValueConverter = mock(Function.class);

    // Act
    hyperLogLogPlusEntityGenerator.setVertexValueConverter(vertexValueConverter);

    // Assert
    assertSame(vertexValueConverter, hyperLogLogPlusEntityGenerator.getVertexValueConverter());
  }
}
