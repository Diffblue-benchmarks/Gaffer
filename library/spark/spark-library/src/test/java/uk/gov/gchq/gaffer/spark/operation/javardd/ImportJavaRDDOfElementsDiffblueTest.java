package uk.gov.gchq.gaffer.spark.operation.javardd;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.operation.javardd.ImportJavaRDDOfElements.Builder;

class ImportJavaRDDOfElementsDiffblueTest {
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
    ImportJavaRDDOfElements _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    ImportJavaRDDOfElements actualImportJavaRDDOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualImportJavaRDDOfElements);
  }

  /**
   * Test {@link ImportJavaRDDOfElements#getInput()}.
   *
   * <p>Method under test: {@link ImportJavaRDDOfElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("MaintainedByDiffblue")
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new ImportJavaRDDOfElements().getInput());
  }

  /**
   * Test {@link ImportJavaRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ImportJavaRDDOfElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImportJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ImportJavaRDDOfElements (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenImportJavaRDDOfElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    ImportJavaRDDOfElements actualShallowCloneResult = new ImportJavaRDDOfElements().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getInput());
  }

  /**
   * Test {@link ImportJavaRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImportJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ImportJavaRDDOfElements importJavaRDDOfElements = new ImportJavaRDDOfElements();
    importJavaRDDOfElements.setOptions(new HashMap<>());

    // Act
    ImportJavaRDDOfElements actualShallowCloneResult = importJavaRDDOfElements.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportJavaRDDOfElements}
   *   <li>{@link ImportJavaRDDOfElements#setOptions(Map)}
   *   <li>{@link ImportJavaRDDOfElements#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ImportJavaRDDOfElements actualImportJavaRDDOfElements = new ImportJavaRDDOfElements();
    HashMap<String, String> options = new HashMap<>();
    actualImportJavaRDDOfElements.setOptions(options);
    Map<String, String> actualOptions = actualImportJavaRDDOfElements.getOptions();

    // Assert
    assertNull(actualImportJavaRDDOfElements.getInput());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
