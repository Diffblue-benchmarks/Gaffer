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

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;

class DeleteAllDataDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link DeleteAllData.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    DeleteAllData.Builder actualBuilder = new DeleteAllData.Builder();

    // Assert
    DeleteAllData _getOpResult = actualBuilder._getOp();
    Map<String, String> options = _getOpResult.getOptions();
    assertTrue(options.isEmpty());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(options, _getOpResult.options);
  }

  /**
   * Method under test: {@link DeleteAllData#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    DeleteAllData actualShallowCloneResult = (new DeleteAllData()).shallowClone();

    // Assert
    Map<String, String> options = actualShallowCloneResult.getOptions();
    assertTrue(options.isEmpty());
    assertTrue(actualShallowCloneResult.options.isEmpty());
    assertSame(actualShallowCloneResult.options, options);
  }

  /**
   * Method under test: {@link DeleteAllData#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    DeleteAllData deleteAllData = new DeleteAllData();
    deleteAllData.setOptions(options);

    // Act
    DeleteAllData actualShallowCloneResult = deleteAllData.shallowClone();

    // Assert
    Map<String, String> options2 = actualShallowCloneResult.getOptions();
    assertTrue(options2.isEmpty());
    assertTrue(actualShallowCloneResult.options.isEmpty());
    assertSame(actualShallowCloneResult.options, options2);
  }

  /**
   * Method under test: {@link DeleteAllData#getOptions()}
   */
  @Test
  void testGetOptions() {
    // Arrange
    DeleteAllData deleteAllData = new DeleteAllData();

    // Act
    Map<String, String> actualOptions = deleteAllData.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(deleteAllData.options, actualOptions);
  }

  /**
   * Method under test: {@link DeleteAllData#getOptions()}
   */
  @Test
  void testGetOptions2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    DeleteAllData deleteAllData = new DeleteAllData();
    deleteAllData.setOptions(options);

    // Act
    Map<String, String> actualOptions = deleteAllData.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(deleteAllData.options, actualOptions);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DeleteAllData}
   */
  @Test
  void testNewDeleteAllData() {
    // Arrange, Act and Assert
    assertTrue((new DeleteAllData()).options.isEmpty());
  }
}
