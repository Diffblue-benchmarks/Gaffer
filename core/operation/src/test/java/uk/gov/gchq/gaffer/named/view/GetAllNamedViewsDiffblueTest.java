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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;

class GetAllNamedViewsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetAllNamedViews}
   *   <li>{@link GetAllNamedViews#setOptions(Map)}
   *   <li>{@link GetAllNamedViews#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllNamedViews actualGetAllNamedViews = new GetAllNamedViews();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllNamedViews.setOptions(options);
    Map<String, String> actualOptions = actualGetAllNamedViews.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link GetAllNamedViews#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange, Act and Assert
    assertNull((new GetAllNamedViews()).shallowClone().getOptions());
  }

  /**
   * Method under test: {@link GetAllNamedViews#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    GetAllNamedViews getAllNamedViews = new GetAllNamedViews();
    getAllNamedViews.setOptions(new HashMap<>());

    // Act and Assert
    assertTrue(getAllNamedViews.shallowClone().getOptions().isEmpty());
  }

  /**
   * Method under test: {@link GetAllNamedViews#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetAllNamedViews getAllNamedViews = new GetAllNamedViews();
    getAllNamedViews.setOptions(options);

    // Act and Assert
    assertTrue(getAllNamedViews.shallowClone().getOptions().isEmpty());
  }
}
