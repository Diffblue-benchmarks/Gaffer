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
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    SetVariable _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getVariableName());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test Builder {@link Builder#variableName(String)}.
   * <p>
   * Method under test: {@link Builder#variableName(String)}
   */
  @Test
  @DisplayName("Test Builder variableName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.variableName(String)"})
  void testBuilderVariableName() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.variableName("Variable Name"));
  }

  /**
   * Test {@link SetVariable#shallowClone()}.
   * <ul>
   *   <li>Given {@link SetVariable} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetVariable#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given SetVariable (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SetVariable SetVariable.shallowClone()"})
  void testShallowClone_givenSetVariableOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
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
   * <ul>
   *   <li>Given {@link SetVariable} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetVariable#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given SetVariable (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SetVariable SetVariable.shallowClone()"})
  void testShallowClone_givenSetVariable_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    SetVariable actualShallowCloneResult = (new SetVariable()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getVariableName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetVariable.<init>()", "Object SetVariable.getInput()", "Map SetVariable.getOptions()",
      "String SetVariable.getVariableName()", "void SetVariable.setInput(Object)", "void SetVariable.setOptions(Map)",
      "void SetVariable.setVariableName(String)"})
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
