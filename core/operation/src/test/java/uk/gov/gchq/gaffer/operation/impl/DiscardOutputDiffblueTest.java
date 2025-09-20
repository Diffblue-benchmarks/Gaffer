package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.DiscardOutput.Builder;

class DiscardOutputDiffblueTest {
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
    DiscardOutput _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    DiscardOutput actualDiscardOutput = actualBuilder.build();
    assertSame(_getOpResult, actualDiscardOutput);
  }

  /**
   * Test {@link DiscardOutput#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link DiscardOutput} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link DiscardOutput#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given DiscardOutput (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenDiscardOutputOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    DiscardOutput discardOutput = new DiscardOutput();
    discardOutput.setOptions(new HashMap<>());

    // Act
    DiscardOutput actualShallowCloneResult = discardOutput.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link DiscardOutput#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link DiscardOutput} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DiscardOutput#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given DiscardOutput (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenDiscardOutput_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    DiscardOutput actualShallowCloneResult = new DiscardOutput().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DiscardOutput}
   *   <li>{@link DiscardOutput#setOptions(Map)}
   *   <li>{@link DiscardOutput#setInput(Object)}
   *   <li>{@link DiscardOutput#getInput()}
   *   <li>{@link DiscardOutput#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    DiscardOutput actualDiscardOutput = new DiscardOutput();
    HashMap<String, String> options = new HashMap<>();
    actualDiscardOutput.setOptions(options);
    actualDiscardOutput.setInput("Input");
    Object actualInput = actualDiscardOutput.getInput();
    Map<String, String> actualOptions = actualDiscardOutput.getOptions();

    // Assert
    assertNull(actualInput);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
