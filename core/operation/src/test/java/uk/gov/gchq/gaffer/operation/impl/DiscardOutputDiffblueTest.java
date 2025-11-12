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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;

class DiscardOutputDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link DiscardOutput.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    DiscardOutput.Builder actualBuilder = new DiscardOutput.Builder();

    // Assert
    DiscardOutput _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DiscardOutput}
   *   <li>{@link DiscardOutput#setOptions(Map)}
   *   <li>{@link DiscardOutput#setInput(Object)}
   *   <li>{@link DiscardOutput#getInput()}
   *   <li>{@link DiscardOutput#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DiscardOutput actualDiscardOutput = new DiscardOutput();
    HashMap<String, String> options = new HashMap<>();
    actualDiscardOutput.setOptions(options);
    actualDiscardOutput.setInput("Input");
    actualDiscardOutput.getInput();
    Map<String, String> actualOptions = actualDiscardOutput.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link DiscardOutput#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    DiscardOutput actualShallowCloneResult = (new DiscardOutput()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Method under test: {@link DiscardOutput#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
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
   * Method under test: {@link DiscardOutput#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    DiscardOutput discardOutput = new DiscardOutput();
    discardOutput.setOptions(options);

    // Act
    DiscardOutput actualShallowCloneResult = discardOutput.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }
}
