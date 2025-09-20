package uk.gov.gchq.gaffer.sketches.clearspring.cardinality;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import java.io.IOException;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.sketches.clearspring.cardinality.function.ToHyperLogLogPlus;

class HyperLogLogPlusEntityGeneratorDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusEntityGenerator#propertyToCopy(String)}.
   *
   * <p>Method under test: {@link HyperLogLogPlusEntityGenerator#propertyToCopy(String)}
   */
  @Test
  @DisplayName("Test propertyToCopy(String)")
  @Tag("MaintainedByDiffblue")
  void testPropertyToCopy() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    HyperLogLogPlusEntityGenerator actualPropertyToCopyResult =
        hyperLogLogPlusEntityGenerator.propertyToCopy("Property To Copy");

    // Assert
    assertSame(hyperLogLogPlusEntityGenerator, actualPropertyToCopyResult);
  }

  /**
   * Test {@link HyperLogLogPlusEntityGenerator#propertiesToCopy(String[])}.
   *
   * <p>Method under test: {@link HyperLogLogPlusEntityGenerator#propertiesToCopy(String[])}
   */
  @Test
  @DisplayName("Test propertiesToCopy(String[])")
  @Tag("MaintainedByDiffblue")
  void testPropertiesToCopy() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    HyperLogLogPlusEntityGenerator actualPropertiesToCopyResult =
        hyperLogLogPlusEntityGenerator.propertiesToCopy("Properties To Copy");

    // Assert
    assertSame(hyperLogLogPlusEntityGenerator, actualPropertiesToCopyResult);
  }

  /**
   * Test {@link HyperLogLogPlusEntityGenerator#group(String)}.
   *
   * <p>Method under test: {@link HyperLogLogPlusEntityGenerator#group(String)}
   */
  @Test
  @DisplayName("Test group(String)")
  @Tag("MaintainedByDiffblue")
  void testGroup() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    HyperLogLogPlusEntityGenerator actualGroupResult =
        hyperLogLogPlusEntityGenerator.group("Group");

    // Assert
    assertEquals("Group", hyperLogLogPlusEntityGenerator.getGroup());
    assertSame(hyperLogLogPlusEntityGenerator, actualGroupResult);
  }

  /**
   * Test {@link HyperLogLogPlusEntityGenerator#cardinalityPropertyName(String)}.
   *
   * <p>Method under test: {@link HyperLogLogPlusEntityGenerator#cardinalityPropertyName(String)}
   */
  @Test
  @DisplayName("Test cardinalityPropertyName(String)")
  @Tag("MaintainedByDiffblue")
  void testCardinalityPropertyName() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    HyperLogLogPlusEntityGenerator actualCardinalityPropertyNameResult =
        hyperLogLogPlusEntityGenerator.cardinalityPropertyName("Cardinality Property Name");

    // Assert
    assertEquals(
        "Cardinality Property Name", hyperLogLogPlusEntityGenerator.getCardinalityPropertyName());
    assertSame(hyperLogLogPlusEntityGenerator, actualCardinalityPropertyNameResult);
  }

  /**
   * Test {@link HyperLogLogPlusEntityGenerator#countProperty(String)}.
   *
   * <p>Method under test: {@link HyperLogLogPlusEntityGenerator#countProperty(String)}
   */
  @Test
  @DisplayName("Test countProperty(String)")
  @Tag("MaintainedByDiffblue")
  void testCountProperty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    HyperLogLogPlusEntityGenerator actualCountPropertyResult =
        hyperLogLogPlusEntityGenerator.countProperty("3");

    // Assert
    assertEquals("3", hyperLogLogPlusEntityGenerator.getCountProperty());
    assertSame(hyperLogLogPlusEntityGenerator, actualCountPropertyResult);
  }

  /**
   * Test {@link HyperLogLogPlusEntityGenerator#edgeGroupProperty(String)}.
   *
   * <p>Method under test: {@link HyperLogLogPlusEntityGenerator#edgeGroupProperty(String)}
   */
  @Test
  @DisplayName("Test edgeGroupProperty(String)")
  @Tag("MaintainedByDiffblue")
  void testEdgeGroupProperty() {
    // Arrange
    HyperLogLogPlusEntityGenerator hyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Act
    HyperLogLogPlusEntityGenerator actualEdgeGroupPropertyResult =
        hyperLogLogPlusEntityGenerator.edgeGroupProperty("Edge Group Property");

    // Assert
    assertEquals("Edge Group Property", hyperLogLogPlusEntityGenerator.getEdgeGroupProperty());
    assertSame(hyperLogLogPlusEntityGenerator, actualEdgeGroupPropertyResult);
  }

  /**
   * Test {@link HyperLogLogPlusEntityGenerator#getToSketchFunction()}.
   *
   * <p>Method under test: {@link HyperLogLogPlusEntityGenerator#getToSketchFunction()}
   */
  @Test
  @DisplayName("Test getToSketchFunction()")
  @Tag("MaintainedByDiffblue")
  void testGetToSketchFunction() throws IOException {
    // Arrange and Act
    Function<Object, HyperLogLogPlus> actualToSketchFunction =
        new HyperLogLogPlusEntityGenerator().getToSketchFunction();
    HyperLogLogPlus actualApplyResult = actualToSketchFunction.apply("42");

    // Assert
    assertTrue(actualToSketchFunction instanceof ToHyperLogLogPlus);
    assertEquals(24, actualApplyResult.sizeof());
    assertEquals(5, ((ToHyperLogLogPlus) actualToSketchFunction).getP());
    assertEquals(5, ((ToHyperLogLogPlus) actualToSketchFunction).getSp());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualApplyResult.getBytes());
  }

  /**
   * Test new {@link HyperLogLogPlusEntityGenerator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * HyperLogLogPlusEntityGenerator}
   */
  @Test
  @DisplayName("Test new HyperLogLogPlusEntityGenerator (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewHyperLogLogPlusEntityGenerator() {
    // Arrange and Act
    HyperLogLogPlusEntityGenerator actualHyperLogLogPlusEntityGenerator =
        new HyperLogLogPlusEntityGenerator();

    // Assert
    assertEquals("Cardinality", actualHyperLogLogPlusEntityGenerator.getGroup());
    assertEquals("cardinality", actualHyperLogLogPlusEntityGenerator.getCardinalityPropertyName());
    assertNull(actualHyperLogLogPlusEntityGenerator.getCountProperty());
    assertNull(actualHyperLogLogPlusEntityGenerator.getEdgeGroupProperty());
    assertNull(actualHyperLogLogPlusEntityGenerator.getVertexValueConverter());
    assertTrue(actualHyperLogLogPlusEntityGenerator.getPropertiesToCopy().isEmpty());
  }
}
