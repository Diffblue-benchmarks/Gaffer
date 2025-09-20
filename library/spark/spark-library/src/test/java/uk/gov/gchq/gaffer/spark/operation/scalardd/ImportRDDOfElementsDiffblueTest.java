package uk.gov.gchq.gaffer.spark.operation.scalardd;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.operation.scalardd.ImportRDDOfElements.Builder;

class ImportRDDOfElementsDiffblueTest {
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
    ImportRDDOfElements _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    ImportRDDOfElements actualImportRDDOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualImportRDDOfElements);
  }

  /**
   * Test {@link ImportRDDOfElements#getInput()}.
   *
   * <p>Method under test: {@link ImportRDDOfElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("MaintainedByDiffblue")
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new ImportRDDOfElements().getInput());
  }

  /**
   * Test {@link ImportRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ImportRDDOfElements} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImportRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ImportRDDOfElements (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenImportRDDOfElementsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ImportRDDOfElements importRDDOfElements = new ImportRDDOfElements();
    importRDDOfElements.setOptions(new HashMap<>());

    // Act
    ImportRDDOfElements actualShallowCloneResult = importRDDOfElements.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link ImportRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ImportRDDOfElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImportRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ImportRDDOfElements (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenImportRDDOfElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    ImportRDDOfElements actualShallowCloneResult = new ImportRDDOfElements().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getInput());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportRDDOfElements}
   *   <li>{@link ImportRDDOfElements#setOptions(Map)}
   *   <li>{@link ImportRDDOfElements#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ImportRDDOfElements actualImportRDDOfElements = new ImportRDDOfElements();
    HashMap<String, String> options = new HashMap<>();
    actualImportRDDOfElements.setOptions(options);
    Map<String, String> actualOptions = actualImportRDDOfElements.getOptions();

    // Assert
    assertNull(actualImportRDDOfElements.getInput());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
