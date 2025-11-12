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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class SplitStoreFromIterableDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link SplitStoreFromIterable.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    SplitStoreFromIterable.Builder<Object> actualBuilder = new SplitStoreFromIterable.Builder<>();

    // Assert
    SplitStoreFromIterable<Object> _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SplitStoreFromIterable}
   *   <li>{@link SplitStoreFromIterable#setInput(Iterable)}
   *   <li>{@link SplitStoreFromIterable#setOptions(Map)}
   *   <li>{@link SplitStoreFromIterable#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SplitStoreFromIterable<Object> actualSplitStoreFromIterable = new SplitStoreFromIterable<>();
    ArrayList<Object> input = new ArrayList<>();
    actualSplitStoreFromIterable.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualSplitStoreFromIterable.setOptions(options);
    Map<String, String> actualOptions = actualSplitStoreFromIterable.getOptions();

    // Assert that nothing has changed
    Iterable<?> input2 = actualSplitStoreFromIterable.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link SplitStoreFromIterable#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    SplitStoreFromIterable<Object> splitStoreFromIterable = new SplitStoreFromIterable<>();

    // Act
    SplitStoreFromIterable<Object> actualShallowCloneResult = splitStoreFromIterable.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Method under test: {@link SplitStoreFromIterable#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    SplitStoreFromIterable<Object> splitStoreFromIterable = new SplitStoreFromIterable<>();
    splitStoreFromIterable.setOptions(new HashMap<>());

    // Act
    SplitStoreFromIterable<Object> actualShallowCloneResult = splitStoreFromIterable.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Method under test: {@link SplitStoreFromIterable#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    SplitStoreFromIterable<Object> splitStoreFromIterable = new SplitStoreFromIterable<>();
    splitStoreFromIterable.setOptions(options);

    // Act
    SplitStoreFromIterable<Object> actualShallowCloneResult = splitStoreFromIterable.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }
}
