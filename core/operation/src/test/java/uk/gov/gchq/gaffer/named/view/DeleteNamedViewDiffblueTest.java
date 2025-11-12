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

package uk.gov.gchq.gaffer.named.view;

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

class DeleteNamedViewDiffblueTest {
  /**
   * Method under test: {@link DeleteNamedView.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    DeleteNamedView.Builder builder = new DeleteNamedView.Builder();

    // Act and Assert
    assertSame(builder, builder.name("Name"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DeleteNamedView.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    DeleteNamedView.Builder actualBuilder = new DeleteNamedView.Builder();

    // Assert
    DeleteNamedView _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getName());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeleteNamedView}
   *   <li>{@link DeleteNamedView#setName(String)}
   *   <li>{@link DeleteNamedView#setOptions(Map)}
   *   <li>{@link DeleteNamedView#getName()}
   *   <li>{@link DeleteNamedView#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeleteNamedView actualDeleteNamedView = new DeleteNamedView();
    actualDeleteNamedView.setName("Name");
    HashMap<String, String> options = new HashMap<>();
    actualDeleteNamedView.setOptions(options);
    String actualName = actualDeleteNamedView.getName();
    Map<String, String> actualOptions = actualDeleteNamedView.getOptions();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link DeleteNamedView#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    DeleteNamedView actualShallowCloneResult = (new DeleteNamedView()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Method under test: {@link DeleteNamedView#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    DeleteNamedView deleteNamedView = new DeleteNamedView();
    deleteNamedView.setOptions(new HashMap<>());

    // Act
    DeleteNamedView actualShallowCloneResult = deleteNamedView.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Method under test: {@link DeleteNamedView#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    DeleteNamedView deleteNamedView = new DeleteNamedView();
    deleteNamedView.setOptions(options);

    // Act
    DeleteNamedView actualShallowCloneResult = deleteNamedView.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }
}
