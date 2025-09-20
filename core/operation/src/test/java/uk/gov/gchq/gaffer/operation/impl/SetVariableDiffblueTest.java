package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.SetVariable.Builder;

class SetVariableDiffblueTest {
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
    SetVariable _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getVariableName());
    assertNull(_getOpResult.getOptions());
    SetVariable actualSetVariable = actualBuilder.build();
    assertSame(_getOpResult, actualSetVariable);
  }

  /**
   * Test Builder {@link Builder#variableName(String)}.
   *
   * <p>Method under test: {@link Builder#variableName(String)}
   */
  @Test
  @DisplayName("Test Builder variableName(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderVariableName() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVariableNameResult = builder.variableName("Variable Name");

    // Assert
    assertSame(builder, actualVariableNameResult);
  }

  /**
   * Test {@link SetVariable#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SetVariable} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link SetVariable#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SetVariable (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenSetVariableOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    SetVariable setVariable = new SetVariable();
    setVariable.setOptions(new HashMap<>());

    // Act
    SetVariable actualShallowCloneResult = setVariable.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getVariableName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link SetVariable#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SetVariable} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SetVariable#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SetVariable (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenSetVariable_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    SetVariable actualShallowCloneResult = new SetVariable().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getVariableName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SetVariable}
   *   <li>{@link SetVariable#setInput(Object)}
   *   <li>{@link SetVariable#setOptions(Map)}
   *   <li>{@link SetVariable#setVariableName(String)}
   *   <li>{@link SetVariable#getInput()}
   *   <li>{@link SetVariable#getOptions()}
   *   <li>{@link SetVariable#getVariableName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    SetVariable actualSetVariable = new SetVariable();
    actualSetVariable.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualSetVariable.setOptions(options);
    actualSetVariable.setVariableName("Variable Name");
    Object actualInput = actualSetVariable.getInput();
    Map<String, String> actualOptions = actualSetVariable.getOptions();

    // Assert
    assertEquals("Input", actualInput);
    assertEquals("Variable Name", actualSetVariable.getVariableName());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
