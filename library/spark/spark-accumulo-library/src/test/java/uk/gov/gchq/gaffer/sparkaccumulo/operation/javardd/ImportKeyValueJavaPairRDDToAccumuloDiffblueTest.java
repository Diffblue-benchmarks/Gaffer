package uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd.ImportKeyValueJavaPairRDDToAccumulo.Builder;

class ImportKeyValueJavaPairRDDToAccumuloDiffblueTest {
  /**
   * Test Builder {@link Builder#failurePath(String)}.
   *
   * <p>Method under test: {@link Builder#failurePath(String)}
   */
  @Test
  @DisplayName("Test Builder failurePath(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderFailurePath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualFailurePathResult = builder.failurePath("Failure Path");

    // Assert
    assertSame(builder, actualFailurePathResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    ImportKeyValueJavaPairRDDToAccumulo _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getFailurePath());
    assertNull(_getOpResult.getOutputPath());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    ImportKeyValueJavaPairRDDToAccumulo actualImportKeyValueJavaPairRDDToAccumulo =
        actualBuilder.build();
    assertSame(_getOpResult, actualImportKeyValueJavaPairRDDToAccumulo);
  }

  /**
   * Test Builder {@link Builder#outputPath(String)}.
   *
   * <p>Method under test: {@link Builder#outputPath(String)}
   */
  @Test
  @DisplayName("Test Builder outputPath(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderOutputPath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOutputPathResult = builder.outputPath("Output Path");

    // Assert
    assertSame(builder, actualOutputPathResult);
  }

  /**
   * Test {@link ImportKeyValueJavaPairRDDToAccumulo#getInput()}.
   *
   * <p>Method under test: {@link ImportKeyValueJavaPairRDDToAccumulo#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("MaintainedByDiffblue")
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new ImportKeyValueJavaPairRDDToAccumulo().getInput());
  }

  /**
   * Test {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumulo importKeyValueJavaPairRDDToAccumulo =
        new ImportKeyValueJavaPairRDDToAccumulo();
    importKeyValueJavaPairRDDToAccumulo.setOptions(new HashMap<>());

    // Act
    ImportKeyValueJavaPairRDDToAccumulo actualShallowCloneResult =
        importKeyValueJavaPairRDDToAccumulo.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getOutputPath());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsIsNull() {
    // Arrange and Act
    ImportKeyValueJavaPairRDDToAccumulo actualShallowCloneResult =
        new ImportKeyValueJavaPairRDDToAccumulo().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getOutputPath());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getInput());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportKeyValueJavaPairRDDToAccumulo}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#setFailurePath(String)}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#setOptions(Map)}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#setOutputPath(String)}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#getFailurePath()}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#getOptions()}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#getOutputPath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ImportKeyValueJavaPairRDDToAccumulo actualImportKeyValueJavaPairRDDToAccumulo =
        new ImportKeyValueJavaPairRDDToAccumulo();
    actualImportKeyValueJavaPairRDDToAccumulo.setFailurePath("Failure Path");
    HashMap<String, String> options = new HashMap<>();
    actualImportKeyValueJavaPairRDDToAccumulo.setOptions(options);
    actualImportKeyValueJavaPairRDDToAccumulo.setOutputPath("Output Path");
    String actualFailurePath = actualImportKeyValueJavaPairRDDToAccumulo.getFailurePath();
    Map<String, String> actualOptions = actualImportKeyValueJavaPairRDDToAccumulo.getOptions();

    // Assert
    assertEquals("Failure Path", actualFailurePath);
    assertEquals("Output Path", actualImportKeyValueJavaPairRDDToAccumulo.getOutputPath());
    assertNull(actualImportKeyValueJavaPairRDDToAccumulo.getInput());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
