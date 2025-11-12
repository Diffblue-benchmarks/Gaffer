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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;

class SetVariableDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link SetVariable.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    SetVariable.Builder actualBuilder = new SetVariable.Builder();

    // Assert
    SetVariable _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getVariableName());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Method under test: {@link SetVariable.Builder#variableName(String)}
   */
  @Test
  void testBuilderVariableName() {
    // Arrange
    SetVariable.Builder builder = new SetVariable.Builder();

    // Act and Assert
    assertSame(builder, builder.variableName("Variable Name"));
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    SetVariable actualSetVariable = new SetVariable();
    actualSetVariable.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualSetVariable.setOptions(options);
    actualSetVariable.setVariableName("Variable Name");
    Object actualInput = actualSetVariable.getInput();
    Map<String, String> actualOptions = actualSetVariable.getOptions();

    // Assert that nothing has changed
    assertEquals("Input", actualInput);
    assertEquals("Variable Name", actualSetVariable.getVariableName());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link SetVariable#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    SetVariable actualShallowCloneResult = (new SetVariable()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getVariableName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Method under test: {@link SetVariable#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
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
   * Method under test: {@link SetVariable#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    SetVariable setVariable = new SetVariable();
    setVariable.setOptions(options);

    // Act
    SetVariable actualShallowCloneResult = setVariable.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getVariableName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }
}
