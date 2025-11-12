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

package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class DeleteNamedOperationDiffblueTest {
  /**
   * Method under test: {@link DeleteNamedOperation.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    DeleteNamedOperation.Builder builder = new DeleteNamedOperation.Builder();

    // Act and Assert
    assertSame(builder, builder.name("Name"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DeleteNamedOperation.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    DeleteNamedOperation.Builder actualBuilder = new DeleteNamedOperation.Builder();

    // Assert
    DeleteNamedOperation _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getOperationName());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeleteNamedOperation}
   *   <li>{@link DeleteNamedOperation#setOperationName(String)}
   *   <li>{@link DeleteNamedOperation#setOptions(Map)}
   *   <li>{@link DeleteNamedOperation#getOperationName()}
   *   <li>{@link DeleteNamedOperation#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeleteNamedOperation actualDeleteNamedOperation = new DeleteNamedOperation();
    actualDeleteNamedOperation.setOperationName("Operation Name");
    HashMap<String, String> options = new HashMap<>();
    actualDeleteNamedOperation.setOptions(options);
    String actualOperationName = actualDeleteNamedOperation.getOperationName();
    Map<String, String> actualOptions = actualDeleteNamedOperation.getOptions();

    // Assert that nothing has changed
    assertEquals("Operation Name", actualOperationName);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link DeleteNamedOperation#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    DeleteNamedOperation actualShallowCloneResult = (new DeleteNamedOperation()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Method under test: {@link DeleteNamedOperation#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    DeleteNamedOperation deleteNamedOperation = new DeleteNamedOperation();
    deleteNamedOperation.setOptions(new HashMap<>());

    // Act
    DeleteNamedOperation actualShallowCloneResult = deleteNamedOperation.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOperationName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Method under test: {@link DeleteNamedOperation#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    DeleteNamedOperation deleteNamedOperation = new DeleteNamedOperation();
    deleteNamedOperation.setOptions(options);

    // Act
    DeleteNamedOperation actualShallowCloneResult = deleteNamedOperation.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOperationName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }
}
