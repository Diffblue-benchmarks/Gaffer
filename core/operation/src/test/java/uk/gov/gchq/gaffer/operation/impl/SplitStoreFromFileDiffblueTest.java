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
import org.junit.jupiter.api.Test;

class SplitStoreFromFileDiffblueTest {
  /**
   * Method under test: {@link SplitStoreFromFile.Builder#inputPath(String)}
   */
  @Test
  void testBuilderInputPath() {
    // Arrange
    SplitStoreFromFile.Builder builder = new SplitStoreFromFile.Builder();

    // Act and Assert
    assertSame(builder, builder.inputPath("Input Path"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SplitStoreFromFile.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    SplitStoreFromFile.Builder actualBuilder = new SplitStoreFromFile.Builder();

    // Assert
    SplitStoreFromFile _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInputPath());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SplitStoreFromFile}
   *   <li>{@link SplitStoreFromFile#setInputPath(String)}
   *   <li>{@link SplitStoreFromFile#setOptions(Map)}
   *   <li>{@link SplitStoreFromFile#getInputPath()}
   *   <li>{@link SplitStoreFromFile#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SplitStoreFromFile actualSplitStoreFromFile = new SplitStoreFromFile();
    actualSplitStoreFromFile.setInputPath("Input Path");
    HashMap<String, String> options = new HashMap<>();
    actualSplitStoreFromFile.setOptions(options);
    String actualInputPath = actualSplitStoreFromFile.getInputPath();
    Map<String, String> actualOptions = actualSplitStoreFromFile.getOptions();

    // Assert that nothing has changed
    assertEquals("Input Path", actualInputPath);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link SplitStoreFromFile#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    SplitStoreFromFile actualShallowCloneResult = (new SplitStoreFromFile()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInputPath());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Method under test: {@link SplitStoreFromFile#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    SplitStoreFromFile splitStoreFromFile = new SplitStoreFromFile();
    splitStoreFromFile.setOptions(new HashMap<>());

    // Act
    SplitStoreFromFile actualShallowCloneResult = splitStoreFromFile.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInputPath());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Method under test: {@link SplitStoreFromFile#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    SplitStoreFromFile splitStoreFromFile = new SplitStoreFromFile();
    splitStoreFromFile.setOptions(options);

    // Act
    SplitStoreFromFile actualShallowCloneResult = splitStoreFromFile.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInputPath());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }
}
